package view;

import view.login.LoginOption;

public class MainMenu extends BaseMenu{
    public MainMenu(){
        addOption(new LoginOption());
        addOption(new ExitOption());
    }
}