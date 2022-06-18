# Discovery Service

## Maven
### Build
mvn clean install
### Run
####
cd target
####
java -jar discovery-service-1.0.0.jar
####
java -jar discovery-service-1.0.0.jar --spring.profiles.active=localhost
####
java -jar discovery-service-1.0.0.jar --spring.profiles.active=development
####
java -jar discovery-service-1.0.0.jar --spring.profiles.active=production

## Docker
### Build
docker build -t discovery-service:1.0.0 -f Dockerfile .

### Run
docker run -it --restart always --name discovery-service -p 1001:1001 -e SPRING_PROFILES_ACTIVE=localhost discovery-service:1.0.0
####
docker run -it --restart always --name discovery-service -p 1001:1001 -e SPRING_PROFILES_ACTIVE=development discovery-service:1.0.0
####
docker run -it --restart always --name discovery-service -p 1001:1001 -e SPRING_PROFILES_ACTIVE=production discovery-service:1.0.0

#### SPRING_PROFILES_ACTIVE (env)
localhost, development, production