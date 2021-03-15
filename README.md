# Getting Started with URLShortner App

To build single app jar;
From the projects's root directory run:
gradle build 

Running jar:
java -jar build/libs/URLShortner-0.0.1-SNAPSHOT.jar

Default port:
The app runs on port 8080
If there is any process on this port please kill that process while running the app

API Test:
I have a directory with the outputs of the APIs implemented
This directory has screenshots taken from swagger ui
It shows both API requests and responses

Dependency
***NB***
Please download and run Redis locally on default port 6379
Redis was used as a cache mechanism since the requirements
strictly requested that I must use in-memory db
