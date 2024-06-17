# Project
The purpose of this project is to find a solution to process recipts and assign point totals based on the criteria provided. This is a simple API to fulfill the requirements for Fetch Rewards for the Receipt Processor Challenge. 

# Getting Started
Please ensure Docker is updated and running in the background for the following steps.
1. Clone this repo into the IDE and build the Docker container with this command `docker build -t receipt-processor:latest .`. It should take a few minutes as the maven package is being built. The tests will also run during this process.
2. Confirm that the Docker image was created by using this command `docker images`. The new Docker "receipt-processor" should be found within the list. 
3. To run the Docker container, follow these steps;
   Option 1. Run `docker run --name recipet-processor -p 8080:8080 -d receipt-processor` to run this container in detached mode. Detached mode will run this application in the background, freeing up space on your terminal.
      1. To verify that Docker is running, you can check on the Docker desktop
      2. To terminate the Docker container, use `docker stop receipt-processor` in the terminal or go to the Docker desktop
   Option 2. Run `docker run --name recipet-processor -p 8080:8080 receipt-processor` without the -d to run this container from the terminal
      3. To verify that Docker is running, the application will start on the terminal screen
      4. To terminate the Docker container, use `ctrl-c` in the terminal
4. The application should run on localhost 8080

# Usage
POST endpoint
* To make the POST request to the API, use a curl request to endpoint /receipts/process with the receipt information in the body in JSON. Here is an example: `curl -X POST http://localhost:8080/receipts/process -H "Content-Type: application/json" -d '{"retailer": "Target", "purchaseDate": "2022-01-01", "purchaseTime": "13:01", "items": [{"shortDescription": "Mountain Dew 12PK", "price": "6.49"}, {"shortDescription": "Emils Cheese Pizza", "price": "12.25"}, {"shortDescription": "Knorr Creamy Chicken", "price": "1.26"}, {"shortDescription": "Doritos Nacho Cheese", "price": "3.35"}, {"shortDescription": "   Klarbrunn 12-PK 12 FL OZ  ", "price": "12.00"}], "total": "35.35"}'`. The endpoint response should return a JSON Object containing an ID for the receipt like this {"id":"xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"}.

GET Request
* By taking the id from the previous POST request, make a curl request to endpoint /receipts/{id}/points to return the number of points a receipt will recieve. Here is an example:`curl -X GET http://localhost:8080/receipts/{id}/points`. The endpoint response should return a JSON object with the points for the particular id like this {"points": 28}.


# Resources
To learn more about Springboot: https://spring.io/projects/spring-boot 
To learn more about Docker: https://www.docker.com/get-started/