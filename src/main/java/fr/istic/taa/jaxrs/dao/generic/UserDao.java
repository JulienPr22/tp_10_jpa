package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends AbstractJpaDao<Long, User> {

    public UserDao() {
        this.setClazz(User.class);
    }

}
