package filter;

import model.LoginRequest;

public abstract class BaseAuthenticationHandler implements AuthenticationHandler {
    private AuthenticationHandler nextHandler;

    /**
     * @param nextHandler the nextHandler to set
     */
    public void setNextHandler(AuthenticationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * @param request the request to be handled.
     * the handler method.
     */
    @Override
    public abstract boolean authenticate(LoginRequest request);

    /**
     * @param request the request to be handled.
     * calls the next handler in the chain.
     */
    @Override
    public boolean authenticateNext(LoginRequest request) {
        if(nextHandler == null){
            return true;
        }
        return nextHandler.authenticate(request);
    }
}