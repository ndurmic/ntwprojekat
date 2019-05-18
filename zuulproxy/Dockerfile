FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
ADD target/zuulproxy-0.0.1-SNAPSHOT.jar zuul.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul.jar"]
