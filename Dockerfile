FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/miniproject-0.0.1-SNAPSHOT.jar /app/myproject.jar
COPY src/main/resources/application.properties /app/application.properties
EXPOSE 8080
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/myproject \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=password
CMD ["java", "-jar", "miniproject.jar"]
