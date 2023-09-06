
# Multiverse Backend Final Project
## Overview of Expedia Project & Supplementary Snippr app

#### Projects:
---

   - ### Expedia Project: a new RESTful API to remove unecessary manual labor
   - ### Author: Victoria McCrady
   - ### Date: 7/1/2023-9/6/2023

   - ### Introduction
Expedia group has two methods hotel owners can use to recieve their payment. As of today, we have a team processing upwards of 200 request a week to change from one method of payment, to another. This system is being rolled out to new markets, and the requests have been growing with the system's rollout. I was tasked with creating a REST api that can change the setting, which will be added to the front-end UI of necessary apps. This will allow for self service, and give time back to the agents currently carrying out this manual process. 
   - ### Requirements
     - API needs to have a gate that:
       -  Denies certain markets from accessing this feature
       -  Denies hotels that are part of certain chains
     - API needs to integrate EG's authorization
     - API needs to ensure input is correct, and that the hotel is even eligible for either payment method
     - API needs a testing suite that ensures all errors and use cases are covered
     - API needs to log all errors for future debug use  
   - ### Design
     - The allow and deny lists of this feature would be constantly changing, due to new rollouts, or parent chains wanting to remove privileges to child hotels,
    & our team does not actively participate in these rollouts and changes.
      - We could either hard code the lists, and maintain them ourselves, with a new PR for every change
      - Or, find something more dynamic and accesible to share with the team that requested this feature
      I went with the latter, and used an internal tool that allows dynamic changes to be relfected on the live sites. This tool has a UI and website I will share with the requesting team, which will give them total control over who can access this feature and who cannot. This will avoid long wait times between changes, and parse down unucessary communication for both teams
   - ### Implementation
     - This project was done in Java 11 with springboot. I used the mockito library for my tests, and integrated multiple internal tools & libraries to satisfy the needs of this project.  
   - ### Testing
     - The testing was done as junit tests with the mockito library. I tested a variety of use cases, however there was no requirement for smoke tests, as the parent app takes care of that.
     - I also learned how to simulate HTTPservelet requests and responses
   - ### Deployment & Learning
     - This api was sucessfully deployed twice, and will be availabe to the front end when work starts on the feature's ui.
     - There were some issues with the authorization strategy I used- I actually set up two different types, replacing the first with a newer kind of interceptor. However, this created issues with other dependenices, which I am currently fixing.
     - I also had challenges testing the dynamic gating, and discovered my gate is not test-able in the local envoirment with the app's setup. This meant checking in the test envoirment, where I verified my work.
     - Intellij's debug tools, Postman and Swagger UI were two tools I learned quite a bit about while working on this project.
   - ### Maintenance
     - Some maintence was already completed when I updated the Authroization injector that this API uses, and it was designed to support the current app, which is planned for eventual replacement. It will most likely be decomissioned sometime next year.
   - ### References (sites I used often/for reference)
     - https://www.baeldung.com/
     - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html 


---

   - ### Snipper App
   - ### Author: Victoria McCrady
   - ### Date: 7/1/2023-9/6/2023

   - ### Introduction
Snipper was created as a learning tool for the backend course. It's a backend API designed to store 'snippets' of code that belong to users. I continued to work on it after the initial learning phase, and used it to understand Docker, and how Backend JAVA API's interact with databases. 
   - ### Requirements
These were set personally:
  - [X] View one, or all Snippets
  - [X] View one, or all Users (with snippets)
  - [X] Create a snippet(and update user)
  - [X] Create a user
  - [ ] Update a snippet or user
  - [ ] Delete users and snippets
  - [X] Docker Database
  - [X] seed database for testing
  - [ ] protected rotues and AUTH
  - [X] custom/descriptive error handling
  - [ ] test suites 
   - ### Design
I used Java Springboot for this project because I wanted to understand the tech stack. I learned quite a bit from this project, as it taught me quite a few Java fundamentals.
   - ### Implementation
This repository has the finer details, but I used model, service, dto, client, and controller layers.
   - ### Testing
Junit and Mockito unit tests
   - ### Maintenance
I plan to continue tinkering with Authorization and tests, as I want to deepen my knoweldge of how to handle protected routes with vanilla springboot. 
   - ### References
My multiverse instructor, Jonathan Jacka was instrumental in understanding how to use this tech stack and carry out CRUD functions on a database
