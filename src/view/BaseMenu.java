package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private List<Option> options = new ArrayList<Option>();

    @Override
    public void renderOptions() {
        for(int i = 0; i < this.options.size(); i++){
            System.out.printf("%d. ", i+1);
            this.options.get(i).render();
        }
    }

    @Override
    public Menu addOption(Option option){
        this.options.add(option);
        option.setMenu(this);
        return this;
    }

    @Override
    public Menu removeOption(Option option){
        this.options.remove(option);
        return this;
    }

    @Override
    public int NumberOfOptions() {
        return this.options.size();
    }

    @Override
    public void handleInput() {
        String chosenOption = scanner.next();
        int optionNumber = 0;
        
        try {
            optionNumber = Integer.parseInt(chosenOption);
        } catch (Exception e) {
            System.out.println("A opção deve ser um número.");
            this.renderOptions();
            this.handleInput();
        }
        if(optionNumber > NumberOfOptions() || optionNumber <= 0){
            System.out.println("A opção não existe.");
            this.renderOptions();
            this.handleInput();
        }

        this.options.get(optionNumber-1).action();
    }

    @Override
    public void stop() {
    
    }
}