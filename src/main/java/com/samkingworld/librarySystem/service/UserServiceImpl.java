package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.utils.EmailServiceImpl;
import com.samkingworld.librarySystem.utils.UpdateReqest;
import com.samkingworld.librarySystem.exception.UserException;
import com.samkingworld.librarySystem.model.User;
import com.samkingworld.librarySystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    public final EmailServiceImpl emailService;



    @Cacheable(value = "allUsers")
    public List<User> getAllUsers() {return userRepository.findAll();}

    @Cacheable(value = "getUser", key = "#id")
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    @Cacheable(value = "getUser", key = "#userId")
    public User getUserByUserId(String userId){
        return userRepository.findByUserId(userId).orElseThrow(() -> new UserException("User not found"));

    }

    @Cacheable(value = "getUser", key = "#email")
    public User getUserByEmail(String email){
        return   userRepository.findByEmail(email).orElseThrow(() -> new  UserException("User not found"));
    }

    @CacheEvict(value = "allUsers", allEntries = true)
    public String createUser(User user) {
        Optional<User> u = userRepository.findByEmail(user.getEmail());

        if (!u.isPresent()){
            // Get the maximum userId number from the database
            Integer maxUserIdNumber = userRepository.findLastUserIdNumber();
            maxUserIdNumber = (maxUserIdNumber == null) ? 10001 : maxUserIdNumber + 1;
            String customUserId = "SLB/LAG/" + maxUserIdNumber;
            user.setUserId(customUserId);
            // Set date and time of registration
            user.setCreatedDateTime(userRepository.createTime());
            userRepository.save(user);
            // Sending email to user
            return welcomeEmail(user);
        }
        else{
            return "Duplicate email! Email already exist";
        }
    }

//    @Cacheable(value = "allUsers")
//    public String createUser(User user) {
//        String result= "Bad Request";
//        Optional<User> u = userRepository.findByEmail(user.getEmail());
//
//        if (!u.isPresent()){
//            // Get the maximum userId number from the database
//            Integer maxUserIdNumber = userRepository.findLastUserIdNumber();
//            maxUserIdNumber = (maxUserIdNumber == null) ? 10001 : maxUserIdNumber + 1;
//            String customUserId = "SLB/LAG/" + maxUserIdNumber;
//            user.setUserId(customUserId);
//            // Set date and time of registration
//            user.setCreatedDateTime(userRepository.createTime());
//            userRepository.save(user);
//            // Sending email to user
//            try {
//                result =  welcomeEmail(user).get();
//            } catch (Exception e) {
//                e.getMessage();
//            }
//        }
//        else{
//            result =  "Duplicate email! Email already exist";
//        }
//        return result;
//    }

    @CachePut(value = "allUser", key = "#user_id")
    @CacheEvict(value = "getUser", key = "#user_id")
    public User updateUser( String user_id, UpdateReqest updateReqest){
        User user1 = getUserByUserId(user_id);
        if (!updateReqest.getAddress().isEmpty()){user1.setAddress(updateReqest.getAddress());}
        if (updateReqest.getAge() > 18 && updateReqest.getAge() <70){user1.setAge(updateReqest.getAge());}
        if (!updateReqest.getEmail().isEmpty() || !updateReqest.getEmail().isBlank()){user1.setEmail(updateReqest.getEmail());}
        if (!updateReqest.getPhone_no().isEmpty() || !updateReqest.getPhone_no().isBlank()){user1.setPhone_no(updateReqest.getPhone_no());}
        if (!updateReqest.getFull_name().isEmpty() || !updateReqest.getFull_name().isBlank()){user1.setFull_name(updateReqest.getFull_name());}
        user1.setLastModifiedDateTime(userRepository.createTime());

        return userRepository.save(user1);

    }

    @CacheEvict(value = {"allUsers", "getUser"}, key = "#id")
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    @CacheEvict(value = {"allUsers", "getUser"}, key = "#user_id")
    public String deleteUserByUserId(String user_id) {
        userRepository.deleteByUserId(user_id);
        return "User Deleted Successfully.";
    }

    @CacheEvict(value = {"allUsers", "getUser"}, allEntries = true)
    public String deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
        return "User Deleted Successfully.";
    }

    public String welcomeEmail(User user){
        String m;
        String message = "Hello " + user.getFull_name()
                + ", \n \n Thank you for opening an account with us. Congratulation! Your Account has been " +
                "opened successfully." +
                "\n please find below your Account details.\n " +
                " Your User Id is: \t " +
                user.getUserId() +
                "\n Full Name: \t " + user.getFull_name() +
                "\n Address: \t " + user.getAddress() +
                "\n Phone No: \t " + user.getPhone_no()  +
                "\nCongratulation once again " +
                "\n" +
                "Regards\n" +
                "Ogoh Samuel Otor\n" +
                "CEO";

        try {
            emailService.sendSimpleEmail(user.getEmail(), "WELCOME TO SAMKING LIBRARY", message );
            m = "Congratulation! Please check your email to get your login registration details";
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            m =  "Successfully registered. But Couldnt Send Email";

        }
        return m;

    }

}
