package filter;

import model.LoginRequest;
import model.User;
import repository.UserRepository;

public class EmailExistsAuthenticationHandler extends BaseAuthenticationHandler{

    @Override
    public boolean authenticate(LoginRequest request) {
        User user = UserRepository.getInstance().getUserByEmail(request.getEmail());
        if(user == null){
            System.out.println("Email não registrado.");
            return false;
        }
        return authenticateNext(request);
    }
}