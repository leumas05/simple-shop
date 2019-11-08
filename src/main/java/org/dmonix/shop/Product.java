package org.dmonix.shop;

/**
 * Represents one single product item
 * @author Peter Nerg
 */
public class Product {
  private int price;
  public final String name;
  private String id;
  private int quantity;

//-------------------------------------------------------------------------------
  public void setPrice(int newPrice){
    this.price = newPrice;
  }
  public void setId(String newId){
    this.id = newId;
  }
//------------------------------------------------------------------------------
  //TODO implement attributes for ID, name, price and quantity/stock

  public Product(String id, String name, int quantity,int price) {
    //TODO store all constructor arguments in own fields
    this.name = name;
    this.id = id;
    this.quantity = quantity;
    this.price = price;
//-------------------------------------------------------------------------------

//---------------------------------------------------------------------------------

  }
  public String toString() {
    return name +" : "+price +"kr"+" - "+quantity;
  }
  public Product copy(int q) {
    return new Product(id,name, q, price);
  }

  public void decreaseQuantity(int q) {
    quantity = quantity - q;
  }

  public void addQuantity(int q) {
    quantity = quantity + q;
  }
public int getQuantity(){
    return quantity;
}

  public int getPrice() {
    return price;
  }
}

