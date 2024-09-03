package Adapter;

public class EnglishLocalizedMessage implements LocalizedMessage {


    @Override
    public void sayHello() {
        System.out.println("Hello in English");
    }
}