FROM openjdk:11-jdk
VOLUME /tmp
COPY accounts-payable.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
