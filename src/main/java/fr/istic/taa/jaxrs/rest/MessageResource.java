package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.MessageDao;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.dto.MessageDTO;
import fr.istic.taa.jaxrs.mappers.MessageMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/api/message")
@Produces({"application/json"})
public class MessageResource {

    MessageDao messageDao = new MessageDao();

    @GET
    @Path("/{ticketId}")
    @Produces({"application/json"})
    public List<MessageDTO> getAllMessagesByTicketId(@PathParam("ticketId") Long ticketId) {
        return MessageMapper.messageListToMessageDtoList(messageDao.getMessagesByTicketId((ticketId)));
    }


}