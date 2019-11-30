package main;

import repository.UserRepository;
import view.MainMenu;
import view.Menu;

public class Program {
    public static void main(String[] args) {
        UserRepository userRepository = null;
        try {
            userRepository = new UserRepository();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        userRepository.registryUser("luisafonso2000@hotmail.com", "123");
        userRepository.registryUser("jo@email.com", "123");
        userRepository.registryUser("duda@email.com", "123");
        userRepository.registryUser("gaby@email.com", "123");
        userRepository.registryUser("viviane@email.com", "123");
        userRepository.registryUser("jose@email.com", "pikachu_fly");

        Menu menu = new MainMenu();
        menu.renderOptions();
        menu.handleInput();

    }
}