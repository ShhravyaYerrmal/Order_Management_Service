FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/OrderService-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8803
ENV JAVA_OPTS=""
RUN sh -c "touch OrderService-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "java", "-jar", "OrderService-0.0.1-SNAPSHOT.jar" ]