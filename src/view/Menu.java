package view;

public interface Menu {
    
    public void renderOptions();

    public Menu addOption(Option option);

    public Menu removeOption(Option option);

    public void handleInput();

    public int NumberOfOptions();

	public void stop();
}