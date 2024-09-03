package AbstractFactory;

public class RedFactory implements ColorFactory{

    @Override
    public Button getButton() {
        return new RedButton();
    }

    @Override
    public ScrollBar getScrollBar() {
        return new RedScrollBar();
    }
}
