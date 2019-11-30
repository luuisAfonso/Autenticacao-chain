package view;

public abstract class BaseOption implements Option{
    private String text;
    private Menu menu;
    public BaseOption(String text){
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println(this.text);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}