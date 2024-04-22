import java.util.HashMap;

enum ProductType {
    APPLE,
    POTATO,
    MILK,
    BEER,
    TOBACCO
}

class Product {
    private ProductType type;
    private double price;

    public Product(ProductType type, double price) {
        this.type = type;
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class Father {
    private String name;
    private double money;

    public Father(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void goShopping(Product product1, int quantity1, Product product2, int quantity2) throws Exception {
        double totalCost = product1.getPrice() * quantity1 + product2.getPrice() * quantity2;

        if (totalCost > money) {
            throw new Exception("Покупка перевищує суму наявних грошей");
        }

        if (product1.getType() == ProductType.BEER || product1.getType() == ProductType.TOBACCO ||
                product2.getType() == ProductType.BEER || product2.getType() == ProductType.TOBACCO) {
            throw new Exception("Пиво чи тютюн не можна придбати");
        }

        if (quantity1 % 3 != 0 || quantity2 % 3 != 0) {
            throw new Exception("Кількість продуктів не ділиться на три");
        }

        money -= totalCost;
        System.out.println("Шановний " + name + ", вартість ваших покупок " + totalCost +
                ". Ви придбали " + product1.getType() + " у кількості " + quantity1 +
                ", та " + product2.getType() + " у кількості " + quantity2 + ".");
    }
}

public class Main3 {
    public static void main(String[] args) {

        HashMap<ProductType, Product> products = new HashMap<>();
        products.put(ProductType.APPLE, new Product(ProductType.APPLE, 5));
        products.put(ProductType.POTATO, new Product(ProductType.POTATO, 5));
        products.put(ProductType.MILK, new Product(ProductType.MILK, 20));
        products.put(ProductType.BEER, new Product(ProductType.BEER, 20));
        products.put(ProductType.TOBACCO, new Product(ProductType.TOBACCO, 45));


        Father father = new Father("Валентин", 220);

        try {

            father.goShopping(products.get(ProductType.APPLE), 3,
                    products.get(ProductType.MILK), 6);
        } catch (Exception e) {
            System.out.println("Неприємна ситуація: " + e.getMessage());
        }
    }
}
