package com.samkingworld.librarySystem.repository;

import com.samkingworld.librarySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT MAX(CAST(SUBSTRING(user_id, 9) AS SIGNED)) FROM users", nativeQuery = true)
    Integer findLastUserIdNumber();

    @Query(value = "SELECT current_timestamp()", nativeQuery = true)
    String createTime();

    @Query(value = "SELECT * FROM users where user_id = :userId", nativeQuery = true)
    Optional<User> findByUserId(@Param("userId") String userId);

    Optional<User> findByEmail(String email);


    void deleteByUserId(String userId);

    void deleteByEmail(String email);
}