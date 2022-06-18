# GHN Service

## Maven
### Build
mvn clean install
### Run
cd target
####
java -jar ghn-service-1.0.0.jar
####
java -jar ghn-service-1.0.0.jar --spring.profiles.active=localhost
####
java -jar ghn-service-1.0.0.jar --spring.profiles.active=development
####
java -jar ghn-service-1.0.0.jar --spring.profiles.active=production

## Docker
### Build
docker build -t ghn-service:1.0.0 -f Dockerfile .

### Run
docker run -it --restart always --name ghn-service -p 1003:1003 -e SPRING_PROFILES_ACTIVE=localhost ghn-service:1.0.0
####
docker run -it --restart always --name ghn-service -p 1003:1003 -e SPRING_PROFILES_ACTIVE=development ghn-service:1.0.0
####
docker run -it --restart always --name ghn-service -p 1003:1003 -e SPRING_PROFILES_ACTIVE=production ghn-service:1.0.0

#### SPRING_PROFILES_ACTIVE (env)
localhost, development, production