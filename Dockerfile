FROM openjdk:19
VOLUME /tmp
ARG JAR_FILE
COPY target/miniproject-0.0.1-SNAPSHOT.jar /app/miniproject.jar
ENTRYPOINT ["java","-jar","/app/miniproject.jar"]