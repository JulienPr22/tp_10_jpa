package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.enumeration.Status;
import fr.istic.taa.jaxrs.dto.CreateTicketDTO;
import fr.istic.taa.jaxrs.dto.DetailTicketDTO;
import fr.istic.taa.jaxrs.dto.SummaryTicketDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TicketMapper {
    public static SummaryTicketDTO ticketToSummaryTicketDTO(Ticket t) {
        SummaryTicketDTO summaryTicketDTO = new SummaryTicketDTO();
        summaryTicketDTO.setId(t.getId());
        summaryTicketDTO.setTitle(t.getTitle());
        summaryTicketDTO.setCreationDate(t.getCreationDate());
        summaryTicketDTO.setAssignee(t.getAssignee().getFirstname() + " " + t.getAssignee().getLastname());
        summaryTicketDTO.setStatus(t.getStatus());
        summaryTicketDTO.setTags(t.getTags());
        return summaryTicketDTO;
    }

    public static Ticket createTicketDtoToTicket(CreateTicketDTO t) {
        UserDao userDao = new UserDao();
        User assignee = userDao.findOne(t.getAssignee_id());
        User reporter = userDao.findOne(t.getReporter_id());
        Ticket ticket = new Ticket();
        ticket.setTitle(t.getTitle());
        ticket.setDescription(t.getDescription());
        ticket.setCreationDate(LocalDateTime.now());
        ticket.setReporter(reporter);
        ticket.setAssignee(assignee);
        ticket.setStatus(Status.TO_DO);
        ticket.setTags(t.getTags());
        return ticket;
    }


    public static DetailTicketDTO ticketToDetailTicketDTO(Ticket t) {
        DetailTicketDTO detailTicketDTO = new DetailTicketDTO();
        detailTicketDTO.setId(t.getId());
        detailTicketDTO.setTitle(t.getTitle());
        detailTicketDTO.setDescription(t.getDescription());
        detailTicketDTO.setCreationDate(t.getCreationDate());
        detailTicketDTO.setClosingDate(t.getClosingDate());
        detailTicketDTO.setReporter(t.getReporter().getFirstname() + " " + t.getReporter().getLastname());
        detailTicketDTO.setAssignee(t.getAssignee().getFirstname() + " " + t.getAssignee().getLastname());
        detailTicketDTO.setAssignee_id(t.getAssignee().getId());
        detailTicketDTO.setReporter_id(t.getReporter().getId());
        detailTicketDTO.setStatus(t.getStatus());
        detailTicketDTO.setTags(t.getTags());
        return detailTicketDTO;
    }

    public static List<SummaryTicketDTO> ticketListToListSummaryTicketDTO(List<Ticket> ticketList) {
        return ticketList.stream().map(TicketMapper::ticketToSummaryTicketDTO).collect(Collectors.toList());
    }
}

