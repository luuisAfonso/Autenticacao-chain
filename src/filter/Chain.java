package filter;

import model.LoginRequest;

public class Chain{
    private static Chain singleton;
    private static AuthenticationHandler h1 = new CharactersFilterHandler();
    private static AuthenticationHandler h3 = new EmailExistsAuthenticationHandler();
    private static AuthenticationHandler h2 = new CheckAuthenticationHandler();

    public Chain(){
        h1.setNextHandler(h3);
        h3.setNextHandler(h2);
    }

    public boolean authenticate(LoginRequest request){
        return h1.authenticate(request);
    }

    public static Chain getInstance(){
        if(singleton == null){
            singleton = new Chain();
        }
        return singleton;
    }

}