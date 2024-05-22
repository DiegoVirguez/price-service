# Advertising service

In order to test the app advertising-service, please follow the next:

### Set up the environment:

* Have installed Java 8 or higher.
* Have installed maven.
* Create new listing

You should be able to test with the following endPoints:

### Create a listing

* `http://localhost:8080/listings`

Json exampple:

``` json
{
    "dealer": {
        "guid": "87f4e335-4200-4ffb-8ec1-dd4e8416535d"
    },
    "vehicle": "vehicle",
    "price": 300000000
}
```

### Update a listing

* `http://localhost:8080/listings/a1e02688-588f-49f3-b498-43d88eb21747`

* ***a1e02688-588f-49f3-b498-43d88eb21747*** is the id of the listing.
* tierLimit is a mandatory header to decide if the client wants an exception or update when exceed the tier limit.

Json exampple: :

```json
{
    "dealer": {
        "guid": "87f4e335-4200-4ffb-8ec1-dd4e8416535d",
        "name": "John Doe"
    },
    "vehicle": "vehicle",
    "price": 300000000,
    "listingStatus": "PUBLISHED"
}
```

### Get all the listing for a specific Dealer and an specific status:

* `http://localhost:8080/listings/87f4e335-4200-4ffb-8ec1-dd4e8416535d/DRAFT`

* ***87f4e335-4200-4ffb-8ec1-dd4e8416535d*** is the id of the dealer
* ***DRAFT*** is the status if the listing

### How to run the app

To run the app:

* Clone the git project
* Inside the project's directory, run in the console the command mvn package
* Go to the directory target, the jar file will be advertising-service-0.0.1-SNAPSHOT.jar.
* Run java -jar target/advertising-service-0.0.1-SNAPSHOT.jar

You can run a Spring Boot application from your IDE as a simple Java application, however, first you will need to import your project. Import steps will vary depending on your IDE and build system.

### Notes

When the app is up and running, the following sql statements will be executed in order to have testable data.

```sql
INSERT INTO dealers (dealer_guid, name) VALUES('87f4e335-4200-4ffb-8ec1-dd4e8416535d', 'Andres');
INSERT INTO dealers (dealer_guid, name) VALUES('d974ba06-f6ea-46f9-ad3b-ddb7a69bd9b6', 'John');
```
The tier limit is defined in the application.properties file: ***advertising.tier.limit=3***

You can find the Swagger documentation of the API in the following link:

* `http://localhost:8080/swagger-ui/index.html`
