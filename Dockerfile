FROM maven:3.8.5-openjdk-17-slim AS build


#BUILD THE PACKAGE
WORKDIR /app
COPY src ./src/
COPY pom.xml ./

RUN mvn clean package

#RUN THE PACKAGE
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar ./receipt-processor.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "receipt-processor.jar"]