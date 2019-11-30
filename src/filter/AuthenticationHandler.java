package filter;

import model.LoginRequest;

public interface AuthenticationHandler {
    
    public void setNextHandler(AuthenticationHandler handler);

    /**
     * @param request the request to be handled
     * the method that decides or not to pass the 
     * request to the next handle or process it.
     */
    public boolean authenticate(LoginRequest request);
    public boolean authenticateNext(LoginRequest request);
}