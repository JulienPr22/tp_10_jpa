package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Message;

import javax.persistence.Query;
import java.util.List;

public class MessageDao extends AbstractJpaDao<Long, Message> {

    public MessageDao() {
        this.setClazz(Message.class);
    }

    public List<Message> getMessagesByTicketId(Long ticketId) {
        Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.relatedTicket.id = :ticketId");
        query.setParameter("ticketId", ticketId);
        return query.getResultList();

    }
}
