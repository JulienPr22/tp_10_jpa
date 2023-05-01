package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.enumeration.Status;
import fr.istic.taa.jaxrs.domain.enumeration.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MessageDTO {
    private Long id;
    private Long senderId;
    private Long relatedTicketId;
    private String content;
    private LocalDateTime date;


}
