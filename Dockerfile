FROM openjdk:17-oracle
EXPOSE 8080
COPY build/libs/WebSocket.jar WebSocket.jar
ENTRYPOINT ["java","-jar","/WebSocket.jar"]
