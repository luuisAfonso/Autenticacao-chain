package view.login;

import java.util.Scanner;

import filter.Chain;
import model.LoginRequest;
import view.BaseOption;

public class LoginOption extends BaseOption{
    Scanner scanner = new Scanner(System.in);
    public LoginOption() {
        super("Fazer login.");
    }

    @Override
    public void action() {
        System.out.println("Digite seu e-mail: ");
        String email = scanner.next();
        System.out.println("Digite sua senha: ");
        String password = scanner.next();
        LoginRequest request = new LoginRequest(email, password);
        boolean success = Chain.getInstance().authenticate(request);
        if(success){
            System.out.println("Você está logado!");
        }
    }
}