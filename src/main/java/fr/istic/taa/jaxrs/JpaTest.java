package fr.istic.taa.jaxrs;

import fr.istic.taa.jaxrs.dao.generic.MessageDao;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Message;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.enumeration.Status;
import fr.istic.taa.jaxrs.domain.enumeration.Tag;

public class JpaTest {


    public static void main(String[] args) {
        TicketDao ticketDao = new TicketDao();
        UserDao userDao = new UserDao();
        MessageDao messageDao = new MessageDao();

        System.out.println(ticketDao.findAll().size());
        System.out.println(userDao.findAll().size());
        System.out.println(messageDao.findAll().size());


        if (ticketDao.findAll().isEmpty()) {
            User user1 = new User("Tristan", "Le Saux");
            User user2 = new User("Julien", "Perrier");

            Ticket ticket1 = new Ticket("Ticket 1", "Description Ticket 1", user1);
            ticket1.setAssignee(user2);
            ticket1.addTag(Tag.TECH);

            Ticket ticket2 = new Ticket("Ticket 2", "Description Ticket 2", user1);
            ticket2.setAssignee(user2);
            ticket2.addTag(Tag.BUG);

            Ticket ticket3 = new Ticket("Ticket 3", "Description Ticket 3", user1);
            ticket3.setAssignee(user2);
            ticket3.setStatus(Status.DOING);
            ticket3.addTag(Tag.FEATURE);

            Ticket ticket4 = new Ticket("Ticket 3", "Description Ticket 3", user1);
            ticket4.setAssignee(user2);
            ticket4.setStatus(Status.CLOSE);
            ticket4.addTag(Tag.FEATURE);

            Message message1 = new Message(user2, ticket1, "Salut ça va ?");
            Message message2 = new Message(user1, ticket1, "Oui, et toi ?");
            Message message3 = new Message(user2, ticket1, "Super !");

            userDao.save(user1);
            userDao.save(user2);

            ticketDao.save(ticket1);
            ticketDao.save(ticket2);
            ticketDao.save(ticket3);
            ticketDao.save(ticket4);

            messageDao.save(message1);
            messageDao.save(message2);
            messageDao.save(message3);
        }
    }
}
