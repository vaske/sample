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

CURL example:

```
curl -X GET "http://localhost:8080/sample/companies"
```


**Get details about company [GET]**

    sample/companies/:id

CURL example:

```
curl -X GET "http://localhost:8080/sample/companies/:id"
```

**Create new Company [POST]**

    sample/companies

CURL example:

```
curl -XPOST "http://localhost:8080/sample/companies" --data '{"company_id": "1", "name": "Sample Name", "address": "sample address", "city": "sample city", "country": "sample country", "no_employees": "1"}'
```

**Update company [PUT]**

    sample/companies/:id

CURL example:

```
curl -XPUT "http://localhost:8080/sample/companies/:id" --data '{"id":":id", "company_id": "1", "name": "Sample Name", "address": "sample address", "city": "sample city", "country": "sample country", "no_employees": "1"}'
```

**Delete company [DELETE]**

    sample/companies/:id

CURL example:

```
curl -X DELETE "http://localhost:8080/sample/companies/:id"
```


**Add company owner [POST]**

    sample/company_owners

CURL example:

```
curl -XPOST "http://localhost:8080/sample/company_owners" --data '{"company_id": "1", "owner_name": "Sample Name"}'
```
