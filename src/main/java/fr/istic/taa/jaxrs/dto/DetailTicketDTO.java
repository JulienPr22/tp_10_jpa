package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.enumeration.Status;
import fr.istic.taa.jaxrs.domain.enumeration.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class DetailTicketDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime closingDate;
    private String reporter;
    private String assignee;
    private Long assignee_id;
    private Long reporter_id;
    private Status status;
    private Set<Tag> tags;

}
