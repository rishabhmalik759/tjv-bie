
FROM openjdk:8-jdk-alpine
FROM maven:alpine
##Saves dependencies => do not reinstall them
WORKDIR /application
ADD pom.xml /application
RUN mvn verify clean --fail-never

COPY . /application
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application/target/npsr.jar"]
