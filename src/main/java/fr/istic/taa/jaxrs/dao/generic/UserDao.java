package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.User;

public class UserDao extends  AbstractJpaDao<Long, User>{
    public  User user;
    public UserDao() {
        super(User.class);
    }

    public User createUser(String name){
        User user = new User(name);
            this.save(user);
            return user;
    }


}
