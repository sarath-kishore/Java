package AbstractFactory;

public class BlueFactory implements ColorFactory {

    @Override
    public Button getButton() {
        return new BlueButton();
    }

    @Override
    public ScrollBar getScrollBar() {
        return new BlueScrollBar();
    }
}
