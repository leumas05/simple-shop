package org.dmonix.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Entry point to start the "web shop"
 * @author Peter Nerg
 */
public class Main {
  private static Shop shop = new Shop();
    private static Basket basket = new Basket();
    public static final String GRON_FARG = "\u001B[42m";

    public static void main(String[] args) {
    createShopWithProducts();
    topMenu();
  }

  private static void createShopWithProducts() {
    //TODO
    Product mat = new Product("Mat1", "Mat",5000, 21 );
    Product mobil = new Product("Mobil1", "Mobil", 1, 19999);
    Product bil = new Product("bil1","Bil", 400, 500000);
    Product Dator = new Product("Dator1", "Dator", 10000, 15000);
    shop.addProduct(mat);
    shop.addProduct(mobil);
    shop.addProduct(bil);
    shop.addProduct(Dator);
  }
//--------------------------------------------------------------------------------------------------
  private static void topMenu () {
    do {
      System.out.println("1. Shop");
      System.out.println("2. Basket");
      System.out.println("3. Cache Out");
      System.out.println("0. Exit");
      switch (getUserInput()) {
          case 1:
                shopMenu();
                break;
//-----------------------------------------------------------------------------------------------------
//TODO print all products in the store and let the user choose to add one or more product
//-----------------------------------------------------------------------------------------------------
          case 2:
                basketMenu();
                break;
//------------------------------------------------------------------------------------------------------
          case 3:
              checkOut();
              break;
//------------------------------------------------------------------------------------------------------
        case 0:
          System.exit(0);
          break;
          default:
          break;

//------------------------------------------------------------------------------------------------------
      }
    }while(true);
  }

//------------------------------------------------------------------------------------------------------

   private static void basketMenu() {
    do {
        System.out.println("Your Basket:");
        List<Product> products = basket.getCopy();
        products.forEach(p-> System.out.println(p));
        System.out.println("1.Remove Product");
        System.out.println("2.Empty basket");
        System.out.println("0.Back to menu");
        switch (getUserInput()) {
            case 1:
                System.out.println("Choose product");
                String name =getUserStringInput();

                Product productInBasket = basket.findProductInBasket(name);
                Product productInShop = shop.findProductInShop(name);

                if(productInBasket == null) {
                    System.out.println("Du har inte råd med en sådan...");
                    break;
                }
                System.out.println("Choose quantity");
                int quantity = getUserInput();

                if(quantity > productInBasket.getQuantity()) {
                    System.out.println("Du har inte så många i din korg!");
                    break;
                }
                if(quantity < 0) {
                    System.out.println("Så kan du inte göra!");
                }

                //Product match = basket.findProductInBasket(name);
                //match.decreaseQuantity(quantity);

                productInBasket.decreaseQuantity(quantity);
                productInShop.addQuantity(quantity);
                break;
            case 2:

                break;
            case 0:
                return;
        }
    }while (true);
       //TODO list all items in the shopping cart and let the user to remove one or more items
   }

   private static void shopMenu() {
       do {
           System.out.println("Shop:");
           System.out.println("1.Buy");
           System.out.println("0.back to menu");
           switch (getUserInput()) {
               case 1:
                   List<Product> products = shop.getProducts();
                   products.forEach(p -> System.out.println(p));
                   System.out.println("Choose product");

                   String name = getUserStringInput();
                   Product match = shop.findProductInShop(name);

                   if(match == null) {
                       System.out.println("Kan du inte stava elle...Vi har ingen sådan!");
                       break;
                   }

                   System.out.println("Choose quantity");
                   int quantity = getUserInput();

                   if(quantity > match.getQuantity()) {
                       System.out.println("Det finns inte så många i lager...");
                       break;
                   }
                   if(quantity < 0) {
                       System.out.println("Inte ok asså!");
                       break;
                   }

                   match.decreaseQuantity(quantity);
                   Product copy = match.copy(quantity);
                   basket.addProduct(copy);
                   break;
               case 0:
                   return;
           }

       } while(true);
   }


   private static void checkOut() {
        do {
            System.out.println("That will be:" + basket.totalPrice()+"kr");
            System.out.println("1.Pay");
            System.out.println("0.back to menu");

            switch (getUserInput()) {
                case 1:
                    System.out.println("Thank you for your purchase");
                    System.out.println("You payed"+ basket.totalPrice()+"kr");
                    break;
                case 0:
                    return;
            }
        }while (true);
   }


    /**
   * Reads the input from the console and tries to parse it into a string
   * @return
   * @throws NumberFormatException
   */
  private static int getUserInput() throws NumberFormatException {
    //TODO wrap all code in this method in a Try/catch statement and return the value 666 in case any exception happens
    Scanner in = new Scanner(System.in);
    return Integer.parseInt(in.nextLine());
  }

  private static String getUserStringInput() {
      Scanner in = new Scanner(System.in);
      return new Scanner(System.in).nextLine();
  }
  private static void emptyBasket() {

  }
}
