# Config Service

## Maven
### Build
mvn clean install
### Run
####
cd target
####
java -jar config-service-1.0.0.jar
####
java -jar config-service-1.0.0.jar --spring.profiles.active=localhost
####
java -jar config-service-1.0.0.jar --spring.profiles.active=development
####
java -jar config-service-1.0.0.jar --spring.profiles.active=production

## Docker
### Build
docker build -t config-service:1.0.0 -f Dockerfile .

### Run
docker run -it --restart always --name config-service -p 1000:1000 config-service:1.0.0
####
docker run -it --restart always --name config-service -p 1000:1000  config-service:1.0.0
####
docker run -it --restart always --name config-service -p 1000:1000 config-service:1.0.0

#### SPRING_PROFILES_ACTIVE (env)
localhost, development, production