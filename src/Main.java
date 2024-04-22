interface PurchaseFunctionality {
    void makePurchase(String storeName, double purchaseCost, String sellerName, String buyerName, String itemName, int buyerAge, boolean honestSeller, boolean hasDiscountCard);
}

class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public void purchase(PurchaseFunctionality purchaseFunctionality, double purchaseCost, String sellerName, String buyerName, String itemName, int buyerAge, boolean honestSeller, boolean hasDiscountCard) {
        purchaseFunctionality.makePurchase(this.name, purchaseCost, sellerName, buyerName, itemName, buyerAge, honestSeller, hasDiscountCard);
    }

    public double calculatePurchaseCost(double purchaseCost, boolean hasDiscountCard) {
        if (hasDiscountCard) {
            return purchaseCost * 0.9;
        } else {
            return purchaseCost;
        }
    }

    public void returnCost(String sellerName, String buyerName, String itemName, int buyerAge, double purchaseCost, boolean hasDiscountCard, boolean honestSeller) {
        double finalCost = calculatePurchaseCost(purchaseCost, hasDiscountCard);
        if (buyerAge < 18 && honestSeller) {
            System.out.println("Шановний " + buyerName + ", на жаль, продавець " + sellerName + " нашого магазину \"" + name + "\" чесний і не може продати вам цей товар \"" + itemName + "\", оскільки ви не досягли 18-річного віку. Вартість вашої покупки дорівнює " + finalCost + ".");
        } else if (buyerAge < 18 && !honestSeller) {
            System.out.println("Шановний " + buyerName + ", продавець " + sellerName + " нашого магазину \"" + name + "\" нечесний і продасть вам цей товар \"" + itemName + "\", хоч ви і не досягли 18 років. Вартість вашої покупки дорівнює " + finalCost + ".");
        } else {
            System.out.println("Шановний " + buyerName + ", продавець " + sellerName + " нашого магазину \"" + name + "\" продасть вам цей товар \"" + itemName + "\". Вартість вашої покупки дорівнює " + finalCost + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Сільпо");

        PurchaseFunctionality purchaseFunctionality = (storeName, purchaseCost, sellerName, buyerName, itemName, buyerAge, honestSeller, hasDiscountCard) -> {
            shop.returnCost(sellerName, buyerName, itemName, buyerAge, purchaseCost, hasDiscountCard, honestSeller);
        };

        shop.purchase(purchaseFunctionality, 100.0, "Хуан", "Василь", "Горілка", 61, false, true);

    }
}
