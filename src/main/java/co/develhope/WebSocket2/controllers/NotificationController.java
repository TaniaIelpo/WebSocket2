package co.develhope.WebSocket2.controllers;


import co.develhope.WebSocket2.entities.ClientMessageDTO;
import co.develhope.WebSocket2.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Tania Ielpo
 */

@Controller
public class NotificationController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * exposes the endpoint for sending the message on broadcast-message that:
     * accepts a payload of MessageDTO
     * @param messageDTO
     * @return a Response Entity
     */

    @PostMapping("/broadcast-message")
    public ResponseEntity<String> sendNotificationToClient(@RequestBody MessageDTO messageDTO){
        simpMessagingTemplate.convertAndSend("/topic/broadcast", messageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * exposes an endpoint (client-message) for the client that can send ClientMessageDTO:
     * @param message ClientMessageDTO
     * @return a MessageDTO
     */

    @MessageMapping("/client-message") // /app/hello
    @SendTo("/topic/broadcast")
    public MessageDTO handleMessageFromWS(ClientMessageDTO message){
        System.out.println("Arrived something on /app/client-message: --- ");
        return new MessageDTO(message.getClientName(),message.getClientAlert(), message.getClientMsg());

    }
}
