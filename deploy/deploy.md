docker run --restart always --name config-service -p 1000:1000 config-service:1.0.0

docker run --restart always --name discovery-service -p 1001:1001 -e SPRING_PROFILES_ACTIVE=development discovery-service:1.0.0

docker run --restart always --name internal-service -p 1003:1003 -e SPRING_PROFILES_ACTIVE=development internal-service:1.0.0

docker run --restart always --name gateway-service -p 1002:1002 -e SPRING_PROFILES_ACTIVE=development gateway-service:1.0.0

