package BuilderPattern;
public class StoreItem

{
    private final String name;
    private final Double price;
    private final String shortDescription;
    private final String longDescription;
    private final Integer stockAvailable;
    private final String packagingType;

    public StoreItem(ItemBuilder itemBuilder) {
        this.name = itemBuilder.name;
        this.price = itemBuilder.price;
        this.shortDescription = itemBuilder.shortDescription;
        this.longDescription = itemBuilder.longDescription;
        this.stockAvailable = itemBuilder.stockAvailable;
        this.packagingType = itemBuilder.packagingType;
        if (name == null || price == null) {
            throw new IllegalArgumentException("Name and price must not be null");
        }
    }

    @Override
    public String toString() {
        return "StoreItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", stockAvailable=" + stockAvailable +
                ", packagingType='" + packagingType + '\'' +
                '}' + "\n";
    }

    public static class ItemBuilder{
        private final String name;
        private final Double price;
        private String shortDescription;
        private String longDescription;
        private Integer stockAvailable;
        private String packagingType;

        ItemBuilder(String name, Double price){
            this.name = name;
            this.price = price;
        }

        public ItemBuilder setLongDescription(String longDescription) {
            this.longDescription = longDescription;
            return this;
        }

        public ItemBuilder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public ItemBuilder setStockAvailable(Integer stockAvailable) {
            this.stockAvailable = stockAvailable;
            return this;
        }

        public ItemBuilder setPackagingType(String packagingType) {
            this.packagingType = packagingType;
            return this;
        }

        public StoreItem build(){
            return new StoreItem(this);
        }
    }
}
