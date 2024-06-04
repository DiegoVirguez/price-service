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
Data test:

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|---------------------|---------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4          | 35455      | 1        | 38.95 | EUR  |

### How to run the app

#### Run the app using maven and java:

* Clone the git repository (using ssh command).
* Navigate to the project directory.
* Run the command mvn package to compile the project and generate the target folder.
* Run the command java -jar target/price-api-spec-1.0-SNAPSHOT.jar to launch the application.

Here are the commands in order:
    
    git git@github.com:DiegoVirguez/price-service.git
    mvn package
    java -jar price-api-impl/target/price-api-impl-1.0-SNAPSHOT.jar
You can run a Spring Boot application from your IDE as a simple Java application, however, first you will need to import your project. Import steps will vary depending on your IDE and build system.

#### Use docker to run the application:

    git git@github.com:DiegoVirguez/price-service.git
    cd price-api-impl
    mvn spring-boot:build-image
    docker run -p 8080:8080 davirguezc/inditexprice/price-api-impl:1.0-SNAPSHOT

### Notes

Regardin the swagger documentation, you can access to the following URL:

*  You can go to this page https://editor.swagger.io/ and put the content of the file price-api-spec.yaml to see the documentation.
* `http://localhost:8080/swagger-ui/index.html`
