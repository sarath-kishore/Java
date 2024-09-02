package Factory;

import java.util.HashMap;
import java.util.function.Supplier;

public class VendingMachine {
private static HashMap<String, Supplier<Snack>> supplier = new HashMap<>();
static{
    supplier.put("ChocolateBar", ChocolateBar::new);
    supplier.put("Drink", Drink::new);
    supplier.put("Chips", Chips::new);
}

    Snack getSnack(String snackType) {
        return supplier.get(snackType).get();
    }


}