# Sample AngularJS Spark application for testing purpose
sample spark angularjs app


## Installation

Install [Git](http://git-scm.com), [node.js](http://nodejs.org), [JDK 8](https://www.java.com), and [Maven 3](http://maven.apache.org/).

Compile the service:

    mvn compile

Run the service:

    mvn exec:exec

Your service will run at [http://localhost:8080](http://localhost:8080).

A client-side AngularJS application will now be available by running

    grunt server

The Grunt server will run at [http://localhost:9000](http://localhost:9000).  It will proxy REST requests to the Spark service running at [http://localhost:8080](http://localhost:8080).


API Endpoints
-----------

**Get list of all companies [GET]**

    sample/companies

**Get details about company [GET]**

    sample/companies/:id

**Create new Company [POST]**

    sample/companies

**Update company [PUT]**

    sample/companies/:id

**Delete company [DELETE]**

    sample/companies/:id