# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11:jre

# Add Maintainer Info
LABEL maintainer="ucbabu@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080


ARG JAR_FILE=target/swaggerTest-1.2.jar

ADD ${JAR_FILE} /.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/swaggerTest-1.2.jar"]

