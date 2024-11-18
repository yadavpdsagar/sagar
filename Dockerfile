FROM openjdk:17
EXPOSE 8080
ADD target/spring-boot-sagar-docker.jar /spring-boot-sagar-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-sagar-docker.jar"]
