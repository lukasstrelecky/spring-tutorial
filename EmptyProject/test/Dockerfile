FROM openjdk:11.0-jdk-slim


ADD impl/target/test-impl.jar  /test-impl.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/test-impl.jar" ]

