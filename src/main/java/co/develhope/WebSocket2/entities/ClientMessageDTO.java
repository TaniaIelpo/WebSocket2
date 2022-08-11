package co.develhope.WebSocket2.entities;

import lombok.Data;

/**
 * @author Tania Ielpo
 */

@Data

public class ClientMessageDTO {

    /**
     * MessageDTO that has 2 properties:
     * String sender
     * String type
     * String message
     */

    private String clientName;
    private String clientAlert;
    private String clientMsg;
}
