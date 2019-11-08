package org.dmonix.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a shopping cart containing products to be purchased
 * @author Peter Nerg
 */
public class Basket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product copy) {
        products.add(copy);
    }

    public void removeProduct(Product copy) {
        products.remove(copy);
    }

    public List<Product> getCopy() {
        return products;
    }

    public Product findProductInBasket(String name) {
        Product match = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.equals(name)) {
                match = products.get(i);
                break;
            }
        }
        return match;
    }

    public int totalPrice() {
        int total = 0;

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            total = total + p.getQuantity() * p.getPrice();
        }

        return total;
    }

}

    /**
   * TODO it must be possible to add/remove/view items in the cart
   */
