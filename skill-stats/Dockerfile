FROM openjdk:8-alpine
MAINTAINER tf.pack@gmail.com

RUN adduser -S skill-app
USER skill-app

WORKDIR /app
COPY ./build/libs/*.jar /app/skill-app.jar

EXPOSE 8080

CMD ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "./skill-app.jar", "-XX:+ExitOnOutOfMemoryError"]
