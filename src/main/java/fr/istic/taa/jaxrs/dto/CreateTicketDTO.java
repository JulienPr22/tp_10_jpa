package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.enumeration.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class CreateTicketDTO {
    private String title;
    private String description;
    private Long reporter_id ;
    private Long assignee_id;
    private Set<Tag> tags;

}
