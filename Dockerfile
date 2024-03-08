FROM openjdk:17-oracle
ADD build/libs/*.jar WebSocket.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","WebSocket.jar"]
