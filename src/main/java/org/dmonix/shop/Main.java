package org.dmonix.shop;

import java.util.Scanner;

/**
 * Entry point to start the "web shop"
 * @author Peter Nerg
 */
public class Main {
  
  public static void main(String[] args) {
    topMenu();
  }

  private static void topMenu () {
    do {
      System.out.println("1. Display Store Products");
      System.out.println("2. Display Cart");
      System.out.println("0. Exit");
      switch (getUserInput()) {
        case 1:
          //TODO print all products in the store and let the user choose to add one or more products
          break;
        case 2:
          //TODO list all items in the shopping cart and let the user to remove one or more items
          break;
        case 0:
          System.exit(0);
          break;
        default:
          break;
      }
    } while (true);
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
}
