package repository;

import model.User;
import java.util.List;
import java.util.ArrayList;

public class UserRepository {
    private List<User> users;
    static UserRepository userRepository;

    public UserRepository() throws Exception{
        this.users = new ArrayList<>();
        if(getInstance() == null){
            userRepository = this;
        }else{
            throw new Exception("User repository already created");
        }
    }

    public User getUserByEmail(String email){
        for(User u : this.users){
            if(u.getEmail().equals(email))
                return u;
        }
        return null;
    }

    public User getUserById(int id){
        for(User u : this.users){
            if(u.getId() == id)
                return u;
        }
        return null;
    }

    public boolean registryUser(String email, String password){
        boolean canRegistry = true;
        if(email == null || email.equals("")){
            canRegistry = false;
        }

        if(password == null || password.equals("")){
            canRegistry = false;
        }

        if(canRegistry){
            User user = new User(email, password);
            users.add(user);
            return canRegistry;
        }

        return canRegistry;
    }

    /**
     * @return the userRepository
     */
    public static UserRepository getInstance() {
        return userRepository;
    }
}