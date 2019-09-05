# _*Tips to test Trip Planner*_

To add a user:  
POST: localhost:8080/add/user  
BODY:  
{  
	"firstName" : "Marianna",  
	"lastName" : "Nazar",  
	"email" : "marianna.nazarovna@com"  
}


To get a user by id:  
GET: localhost:8080/get/user/1  

To delete a user by id:  
DELETE: localhost:8080/delete/user/12  

To see a list of all plasces with comments:  
GET: localhost:8080/get/all/places  

To create an empty trip with a user with id=2:  
POST: localhost:8080/create/trip/2  

To add a place to a trip:  
POST: localhost:8080/add/place/to/trip?originalPlaceId=1&tripId=1  

To delete a place from a trip:  
DELETE: /delete/place/in/trip?placeId=1&tripId=1  

To see all trips by userId:  
GET: localhost:8080/get/all/trips/2  

To set a depature date and an end date depending on the place amount in the user trip:  
PUT: localhost:8080/departure  
BODY:  
{  
    "tripId" : "1",  
    "departureDate" : "2019-09-20"  
}  

To share a trip:  
PUT: localhost:8080/share  
BODY:  
{  
	"tripId" : "1",  
	"share" : "true"  
}  

To delete a trip by tripId:  
DELETE: localhost:8080/delete/trip/1  

To add a comment to a place:  
POST: localhost:8080/add/comment  
BODY:  
{  
	"comment" : "uysfdygssfdiysafsdiyg",  
	"originalPlaceId" : 1,  
	"userId" : 5  
}  

To delete a comment by comment id:  
DELETE: localhost:8080/delete/comment/11  
