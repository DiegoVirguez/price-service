# Price service

In order to test the app price-service, please follow the next:

### Set up the environment:

* Have installed Java 17 or higher.
* Have installed maven.

You should be able to test it with the following endPoint:

### Get price:
Request example: 
* `curl -X 'GET' \
  'http://localhost:8080/v1/prices?applicationDate=2020-12-31T23%3A59%3A59&productId=35455&brandId=1' \
  -H 'accept: application/json'`

Response example:
```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 35.5,
  "currency": "EUR"
}
```
### How to run the app

To run the app:

* Clone the git repository (using ssh command).
* Navigate to the project directory.
* Run the command mvn package to compile the project and generate the target folder.
* Run the command java -jar target/price-api-spec-1.0-SNAPSHOT.jar to launch the application.

Here are the commands in order:
    
    git git@github.com:DiegoVirguez/price-service.git
    cd price-service
    mvn package
    java -jar price-api-impl/target/price-api-impl-1.0-SNAPSHOT.jar
You can run a Spring Boot application from your IDE as a simple Java application, however, first you will need to import your project. Import steps will vary depending on your IDE and build system.

### Notes

Regardin the swagger documentation, you can access to the following URL:

*  You can go to this page https://editor.swagger.io/ and put the content of the file price-api-spec.yaml to see the documentation.
* `http://localhost:8080/swagger-ui/index.html`
