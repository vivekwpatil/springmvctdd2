Problem 2: Create a Spring Service to consume a REST endpoint.
Develop a Spring Boot Microservice which has the following endpoints:

-	/cf
-	/cf/{provider}

The endpoint /cf  will return an array of objects with the following information:

[{
description: xx
api_version: yy
},
{
Description: xx1
api_version: yy1
} ]

To provide the information, connect with the following Cloud Foundry endpoints:

•	https://api.run.pivotal.io/v2/info  
•	https://api.ng.bluemix.net/v2/info 

The Endopoint /cf/{provider} will accept the following values: PWC/BLU




In case of an internal error, the endpoints will return an ErrorResponse:

{
ERROR: “ERROR”,
DECRIPTION”: “Something goes wrong” 
}

The scenarios to test are:

•	Ok case for /cf
•	Ok case for /cf/{Provider}
•	Problem with bad Provider alternative
•	Internal error
•	Problem with one request failing
•	Timeout
