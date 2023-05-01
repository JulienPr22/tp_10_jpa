package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.dto.CreateTicketDTO;
import fr.istic.taa.jaxrs.dto.DetailTicketDTO;
import fr.istic.taa.jaxrs.dto.SummaryTicketDTO;
import fr.istic.taa.jaxrs.mappers.TicketMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/ticket")
@Produces({"application/json"})
public class TicketResource {

    TicketDao ticketDao = new TicketDao();
    UserDao userDao = new UserDao();

    @GET
    public List<Ticket> getAllTickets() {
        // return ticket
        return ticketDao.findAll();
    }

    @GET
    @Path("/summaryTickets")
    @Produces({"application/json"})
    public List<SummaryTicketDTO> getAllSummaryTicketsDTO() {
        return TicketMapper.ticketListToListSummaryTicketDTO(ticketDao.findAll());
    }

    @GET
    @Path("/summaryTickets/{ticketId}")
    @Produces({"application/json"})
    public SummaryTicketDTO getSummaryTicketsDTOById(@PathParam("ticketId") Long ticketId) {
        return TicketMapper.ticketToSummaryTicketDTO(ticketDao.findOne(ticketId));
    }

    @GET
    @Path("/{ticketId}")
    public DetailTicketDTO getDetailTicketById(@PathParam("ticketId") Long ticketId) {
        // return ticket
        return TicketMapper.ticketToDetailTicketDTO(ticketDao.findOne(ticketId));
    }

    @POST
    @Consumes("application/json")
    public void addTicket(@RequestBody @Valid CreateTicketDTO t) {
        ticketDao.save(TicketMapper.createTicketDtoToTicket(t));
    }

    @PUT
    @Path("{ticketId}")
    @Consumes("application/json")
    public void updateTicket(@PathParam("ticketId") Long ticketId, @RequestBody CreateTicketDTO createTicket) {
        Ticket ticket = ticketDao.findOne(ticketId);
        ticket.setTitle(createTicket.getTitle());
        ticket.setDescription(createTicket.getDescription());
        ticket.setReporter(userDao.findOne(createTicket.getReporter_id()));
        ticket.setAssignee(userDao.findOne(createTicket.getAssignee_id()));
        ticket.setTags(createTicket.getTags());
        ticketDao.save(ticket);
    }

    @DELETE
    @Path("delete/{ticketId}")
    public void deleteTicket(@PathParam("ticketId") Long ticketId) {
        ticketDao.deleteById(ticketId);
    }


}