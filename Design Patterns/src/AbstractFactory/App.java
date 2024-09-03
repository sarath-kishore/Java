package AbstractFactory;

public class App {


    public static void main(String[] args) {
        UserInterface roadUserInterface = createUserInterface("RED");
        UserInterface mountainUserInterface = createUserInterface("BLUE");

        System.out.println(roadUserInterface);
        System.out.println(mountainUserInterface);

    }


    private static UserInterface createUserInterface(String color) {
        ColorFactory factory = ColorFactoryMaker.getColorFactory(color);
        Button button = factory.getButton();
        ScrollBar scrollBar= factory.getScrollBar();

        return new UserInterface(button, scrollBar);
    }

}
