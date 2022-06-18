FROM maven:3.8.5-eclipse-temurin-11-alpine
WORKDIR /source
COPY pom.xml .
COPY settings.xml /root/.m2/
RUN mvn -Dmaven.artifact.threads=10 dependency:go-offline

RUN mkdir /application
COPY . .
RUN mvn clean -DskipTests=true package && \
    cp target/*.jar /application/application.jar

WORKDIR /application
EXPOSE 1000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/application/application.jar"]
