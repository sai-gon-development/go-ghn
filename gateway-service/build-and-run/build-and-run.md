# Gateway Service

## Maven
### Build
mvn clean install
### Run
####
cd target
####
java -jar gateway-service-1.0.0.jar
####
java -jar gateway-service-1.0.0.jar --spring.profiles.active=localhost
####
java -jar gateway-service-1.0.0.jar --spring.profiles.active=development
####
java -jar gateway-service-1.0.0.jar --spring.profiles.active=production

## Docker
### Build
docker build -t gateway-service:1.0.0 -f Dockerfile .

### Run
docker run -it --restart always --name gateway-service -p 1002:1002 -e SPRING_PROFILES_ACTIVE=localhost gateway-service:1.0.0
####
docker run -it --restart always --name gateway-service -p 1002:1002 -e SPRING_PROFILES_ACTIVE=development gateway-service:1.0.0
####
docker run -it --restart always --name gateway-service -p 1002:1002 -e SPRING_PROFILES_ACTIVE=production gateway-service:1.0.0

#### SPRING_PROFILES_ACTIVE (env)
localhost, development, production