package filter;

import model.LoginRequest;
import model.User;
import repository.UserRepository;

public class CheckAuthenticationHandler extends BaseAuthenticationHandler {

    @Override
    public void setNextHandler(AuthenticationHandler nextHandler) {
        super.setNextHandler(nextHandler);
    }

    @Override
    public boolean authenticate(LoginRequest request) {
        boolean authenticationSuccess = true;
        User user = UserRepository.getInstance().getUserByEmail(request.getEmail());

        if(!user.getEmail().equals(request.getEmail())) 
            authenticationSuccess = false;

        if(!user.getPassword().equals(request.getPassword())) 
            authenticationSuccess = false;

        if(!authenticationSuccess){
            System.out.println("Senha incorreta.");
            return false;
        }
        
        return authenticateNext(request);
            
    }

}