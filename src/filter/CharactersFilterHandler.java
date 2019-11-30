package filter;

import model.LoginRequest;

public class CharactersFilterHandler extends BaseAuthenticationHandler {

    String[] notAllowedChars = { ";", "<", ">", "{",  "}", "[", "]", "+", "=", "?", "&", ",", ":", "'", "`" };

    @Override
    public boolean authenticate(LoginRequest request) {

        boolean canAuthenticate = true;
        String password = request.getPassword();

        for(String s : notAllowedChars){
            if(password.contains(s)){
                canAuthenticate = false;
            }
        }

        if(!canAuthenticate){
            System.out.println("Caractéres não permitidos: ; < > { } [ ] + = ? & , : ' ` ");
            return false;
        }

        return authenticateNext(request);
    }

}