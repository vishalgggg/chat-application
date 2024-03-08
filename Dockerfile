FROM java-17
EXPOSE 8080
ADD build/WebSocket.jar WebSocket.jar
ENTRYPOINT ["java","-jar","/WebSocket.jar"]
