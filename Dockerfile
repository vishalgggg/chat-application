FROM openjdk:17-oracle
EXPOSE 8080
ADD build/WebSocket.jar WebSocket.jar
ENTRYPOINT ["java","-jar","/WebSocket.jar"]
