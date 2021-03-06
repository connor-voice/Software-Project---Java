Spring Software Application
====================================

Connor Voice

Google Slides Presentation link : https://docs.google.com/presentation/d/11gpLhwUi4nGrzhaadY_rVscWmHrqQDKwOPHsDrPFbSA/edit#slide=id.g1082f7b8190_0_37

Introduction:
-------------

The task was to create the front end and the back end for an application that can process data back and forth, using the technologies learned from the modules these past few weeks.

Project Management - This project required a full Jira board with version control integrated. I used Git and make sure auto commits were enabled

Databases - While creating this project I used a h2 database. On completion of the task I moved over to a real database so that the data is permanently stored.

Java SE & Spring Boot - OOP language with a supporting framework to make the creation of a CRUD application faster and function a lot easier.

Testing - To test this project I used JUnit and MockMVC

Front-End Development - Easy to use, functional website designed to control the data.

* * * * *

### Planning Resources:

To begin with, I created a Jira Scrum Board and populated it with two epics (one for front end, and one for back end). I populated these epics with issues so that I knew what I needed to do next. 
![image](https://user-images.githubusercontent.com/93252743/146170193-76c3b6d1-0413-4e9e-9308-4bdbadc39c9a.png)

Next I created two github repo’s. One for front end and one for back end. I commit the basics required for these, and also used the Jira Issue Keys in the commits to make sure that my Jira board was automatically following my git commits. 
![image](https://user-images.githubusercontent.com/93252743/146170265-07c21083-67e2-40b6-9838-3e1bf8d52c59.png)

I then created the branches that I would be needing so that I wasn’t working from the main branch.

![image](https://user-images.githubusercontent.com/93252743/146170467-69408e7f-64f6-4de4-995e-763cf58834d9.png)

I connected my Jira to GitHub and made sure that every time I made a commit about an issue I used to issue key and added a relevant comment. 

* * * * *

### Databases

In this project I used a **H2** database while creating the application, and used a real **MySQL** database once I felt I had finished the app. 

**H2:**

The h2 database was used while developing the application, and is also used when running the tests. They are created using two sql query files that will create a temporary database, and also populate it with data.

![image](https://user-images.githubusercontent.com/93252743/146171325-f60f20f9-e1ef-49d3-9d9b-c8107c7c5c08.png)

![image](https://user-images.githubusercontent.com/93252743/146171347-9b25fc5f-928f-4ab5-9140-14978e006bbf.png)


MySQL: ![image](https://user-images.githubusercontent.com/93252743/146219966-d5bf6a7b-7465-4c5a-8c63-17a7db29cd2e.png)

I used MySQL for this project once I felt I was finished with the functionality of the CRUD functionality. 


* * * * *

### Back-end

![image](https://user-images.githubusercontent.com/93252743/146220320-88f47690-0eb6-4dbb-bc01-a93e6cc6c8be.png)


#### Testing:

I tested this project using JUnit for independant tests as well as running a coverage test. 

**JUnit** -- I tested my application with integration tests from JUnit. I told my application tests to input and read data and expect certain results, then ran the tests to see if the results matched what they were expecting. 

![image](https://user-images.githubusercontent.com/93252743/146186697-3c654eea-b332-40b4-8b7e-7a516c841b2b.png)

**Coverage** -- I used JUnit to run a coverage test to see how much of my code is being used when the application runs. I got a decent coverage of 83.9%. 

![image](https://user-images.githubusercontent.com/93252743/146187804-d4b6a42f-5323-4223-9d53-d37c9d9947e2.png)



* * * * *

### Front-End:

![image](https://user-images.githubusercontent.com/93252743/146178449-f00f057a-c11c-4c98-9082-0fdd4948bd1f.png)


The front end of this project is built using HTML and CSS. There is JavaScript used to read objects from the database and display them as cards, as well as JavaScript used to create, update, and delete objects in the database. 

The CSS on the page is utilising Bootstrap, but also has some customizations from myself. 



