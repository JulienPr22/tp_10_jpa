package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.enumeration.Status;
import fr.istic.taa.jaxrs.domain.enumeration.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
@Data
public class SummaryTicketDTO {
    private Long id;
    private String title;
    private LocalDateTime creationDate;
    private String assignee;
    private Status status;
    private Set<Tag> tags;

}
