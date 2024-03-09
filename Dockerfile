FROM openjdk:17-oracle
ADD build/libs/*.jar WebSocket.jar
EXPOSE 8080 8000
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["sh","/entrypoint.sh"]
