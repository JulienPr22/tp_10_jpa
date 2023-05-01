package fr.istic.taa.jaxrs.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    LocalDate registrationDate;
    @OneToMany(mappedBy = "assignee")
    private List<Ticket> assigneeTickets;
    @OneToMany(mappedBy = "reporter")
    private List<Ticket> reporterTickets;
    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.registrationDate = LocalDate.now();
    }

}
