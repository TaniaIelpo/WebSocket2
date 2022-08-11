package co.develhope.WebSocket2.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tania Ielpo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDTO {

    /**
     * ClientMessageDTO has the following properties:
     * clientName
     * clientAlert
     * clientMsg
     */

    private String sender;
    private String type;
    private String message;
}
