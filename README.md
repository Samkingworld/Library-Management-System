OpenAPI definition
 v0 
OAS3
/api-docs
Servers
http://localhost:8082 - Generated server url

controller
PUT/user/update/{user_id}
Parameters
Try it out
Name	Description
user_id *
string
(path)	
Request body
application/json
•	Example Value
•	Schema
{
  "full_name": "string",
  "email": "string",
  "age": 0,
  "address": "string",
  "phone_no": "string"
}

Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "full_name": "string",
  "email": "string",
  "age": 70,
  "address": "string",
  "phone_no": "string",
  "createdDateTime": "string",
  "lastModifiedDateTime": "string"
}	No links


PUT/borrowedBooks/return/{isbn}
Parameters
Try it out
Name	Description
isbn *
string
(query)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links
POST/user/add
Parameters
Try it out
No parameters
Request body
application/json
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "full_name": "string",
  "email": "string",
  "age": 70,
  "address": "string",
  "phone_no": "string",
  "createdDateTime": "string",
  "lastModifiedDateTime": "string"
}
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


POST/book/borrow
Parameters
Try it out
No parameters
Request body
application/json
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "bookName": "string",
  "bookAuthor": "string",
  "borrowedDateTime": "string"
}
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


POST/book/add
Parameters
Try it out
No parameters
Request body
application/json
•	Example Value
•	Schema
{
  "id": 0,
  "title": "string",
  "author": "string",
  "isbn": "string",
  "publicationYear": "string",
  "createdDateTime": "string",
  "borrowed": true
}
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "title": "string",
  "author": "string",
  "isbn": "string",
  "publicationYear": "string",
  "createdDateTime": "string",
  "borrowed": true
}	No links


GET/users
Parameters
Try it out
No parameters
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
[
  {
    "id": 0,
    "userId": "string",
    "full_name": "string",
    "email": "string",
    "age": 70,
    "address": "string",
    "phone_no": "string",
    "createdDateTime": "string",
    "lastModifiedDateTime": "string"
  }
]	No links


GET/user/userId
Parameters
Try it out
Name	Description
id *
string
(query)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "full_name": "string",
  "email": "string",
  "age": 70,
  "address": "string",
  "phone_no": "string",
  "createdDateTime": "string",
  "lastModifiedDateTime": "string"
}	No links


GET/user/id/{id}
Parameters
Try it out
Name	Description
id *
integer($int64)
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "full_name": "string",
  "email": "string",
  "age": 70,
  "address": "string",
  "phone_no": "string",
  "createdDateTime": "string",
  "lastModifiedDateTime": "string"
}	No links


GET/user/email/{email}
Parameters
Try it out
Name	Description
email *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "userId": "string",
  "full_name": "string",
  "email": "string",
  "age": 70,
  "address": "string",
  "phone_no": "string",
  "createdDateTime": "string",
  "lastModifiedDateTime": "string"
}	No links


DELETE/user/email/{email}
Parameters
Try it out
Name	Description
email *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


GET/borrowedBooks
Parameters
Try it out
No parameters
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
[
  {
    "id": 0,
    "userId": "string",
    "bookName": "string",
    "bookAuthor": "string",
    "borrowedDateTime": "string"
  }
]	No links


GET/borrowedBooks/userId
Parameters
Try it out
Name	Description
user_id *
string
(query)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
[
  {
    "id": 0,
    "userId": "string",
    "bookName": "string",
    "bookAuthor": "string",
    "borrowedDateTime": "string"
  }
]	No links


GET/books
Parameters
Try it out
No parameters
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
[
  {
    "id": 0,
    "title": "string",
    "author": "string",
    "isbn": "string",
    "publicationYear": "string",
    "createdDateTime": "string",
    "borrowed": true
  }
]	No links


GET/book/byTitle/{title}
Parameters
Try it out
Name	Description
title *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "title": "string",
  "author": "string",
  "isbn": "string",
  "publicationYear": "string",
  "createdDateTime": "string",
  "borrowed": true
}	No links


GET/book/byIsbn/{isbn}
Parameters
Try it out
Name	Description
isbn *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
{
  "id": 0,
  "title": "string",
  "author": "string",
  "isbn": "string",
  "publicationYear": "string",
  "createdDateTime": "string",
  "borrowed": true
}	No links


DELETE/book/byIsbn/{isbn}
Parameters
Try it out
Name	Description
isbn *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


GET/book/byAuthor/{author}
Parameters
Try it out
Name	Description
author *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
[
  {
    "id": 0,
    "title": "string",
    "author": "string",
    "isbn": "string",
    "publicationYear": "string",
    "createdDateTime": "string",
    "borrowed": true
  }
]	No links


DELETE/user/userId/{user_id}
Parameters
Try it out
Name	Description
user_id *
string
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


DELETE/user/Id/{id}
Parameters
Try it out
Name	Description
id *
integer($int64)
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links


DELETE/book/byBookId/{bookId}
Parameters
Try it out
Name	Description
bookId *
integer($int64)
(path)	
Responses
Code	Description	Links
200	OK
Media type
*/*
Controls Accept header.
•	Example Value
•	Schema
string	No links
Schemas
UpdateReqest{
full_name	string
email	string
age	integer($int32)
address	string
phone_no	string
}
User
BorrowedBook
Book

![image](https://github.com/Samkingworld/Library-Management-System/assets/84603880/f38d880a-603e-4d2b-ba91-2055525c8b0c)
