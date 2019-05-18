FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
ADD target/korisnicimikroservis-0.0.1-SNAPSHOT.jar korisnici.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/korisnici.jar"]
