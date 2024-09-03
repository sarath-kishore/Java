package Adapter;

//public class FrenchLanguageAdapter extends FrenchLocalizedMessage implements LocalizedMessage{
//    public void sayHello() {
//        System.out.print("Class method: ");
//        sayBonjour();
//    }
//}

public class FrenchLanguageAdapter implements LocalizedMessage{
    private static final FrenchLocalizedMessage frenchLocalizedMessage = new FrenchLocalizedMessage();
    public void sayHello() {
        System.out.print("Object method: ");
        frenchLocalizedMessage.sayBonjour();
    }
}