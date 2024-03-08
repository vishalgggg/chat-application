This is a chatapplication created using websocket,springboot .My application can used to send public message to all who are connected to local server running on port 8080. It can also send private message to user using unique identity generated by spring security principal object.
My application contains spring beans which name are given below
WebsocketConfig: This is used for configuring websocket to configure url so that server/client can send or receive message to each other.this class is using WebSocketMessageBrokerConfigurer interface to override function configureMessageBroker(final MessageBrokerRegistry registry) ,registerStompEndpoints(final StompEndpointRegistry registry) in which i have configured url /ws at this prefix server receive message ,url /topic at this server send back message to client and url /our-websocket at this server is running respectively.in this function registerStompEndpoints(final StompEndpointRegistry registry) i have also setting UserHandshakeHandler to create user id uniquely whenever he connect to localhost.
UserHandshakeHandler: This is inheriting DefaultHandshakeHandler I have created logger object in this to create logs. this is overriding determineUser to create user uniquely give unique id to user connected to localhost returning principal object.
MessageController: This class is used to send and receive message to/from client via @messagemapping,@send to.
Wscontroller: This is used to create post api and send message to specific user and all user using WSservice class. 
Wsservice : This is using SimpMessagingTemplate to send message.
Dto:
Message : To get message content.

thats all my complete backend.


FrontEnd:
In this I have used sockjs client,bootstrap,jquery,stomp,webjars.
i have made these files
Index.html : It is html page to send and receive message.
Script.js: I have made function to intereact with html button to send message through client . 


