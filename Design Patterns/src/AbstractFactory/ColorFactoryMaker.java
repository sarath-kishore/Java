package AbstractFactory;

import java.util.HashMap;
import java.util.function.Supplier;

public class ColorFactoryMaker {
    private static final HashMap<String, Supplier<ColorFactory>> supplier = new HashMap<>();

    static{
        supplier.put("BLUE", BlueFactory::new);
        supplier.put("RED", RedFactory::new);
    }

    static ColorFactory getColorFactory(String factoryColor){
        if(supplier.get(factoryColor) != null){
            return supplier.get(factoryColor).get();
        }else{
            throw new IllegalArgumentException("Unknown color provided!");
        }
    }

}
