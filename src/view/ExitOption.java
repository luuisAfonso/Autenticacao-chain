package view;

public class ExitOption extends BaseOption{

    public ExitOption() {
        super("Sair");
    }

    @Override
    public void action() {
        this.getMenu().stop();
    }

}