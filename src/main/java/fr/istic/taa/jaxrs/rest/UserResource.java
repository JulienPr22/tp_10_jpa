package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.UserDTO;
import fr.istic.taa.jaxrs.mappers.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import java.util.List;

@Path("/api/user")
@Produces({"application/json"})
public class UserResource {

    UserDao userDao = new UserDao();
    @GET
    @Produces({"application/json"})
    public List<UserDTO> getAllMessagesByTicketId() {
        return UserMapper.userListToUserDtoList(userDao.findAll());
    }
}