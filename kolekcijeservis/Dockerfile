FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
ADD target/kolekcijeservis-0.0.1-SNAPSHOT.jar kolekcije.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kolekcije.jar"]
