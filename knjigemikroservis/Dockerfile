FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
ADD target/knjigemikroservis-0.0.1-SNAPSHOT.jar knjige.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/knjige.jar"]
