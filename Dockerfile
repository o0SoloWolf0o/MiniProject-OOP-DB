# Use the OpenJDK 19 image as the base image
FROM openjdk:19-jdk-alpine


# Set the working directory within the container
WORKDIR /app

# Copy the JAR file and application.properties file from your build context into the container
COPY target/miniproject-0.0.1-SNAPSHOT.jar /app/miniproject.jar
COPY src/main/resources/application.properties /app/application.properties

# Expose the port your application will run on
EXPOSE 3307

# Set environment variables for your application's database connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/miniproject \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=password

# Specify the command to run when the container starts
CMD ["java", "-jar", "miniproject.jar"]
