package org.dmonix.shop;

import java.util.List;
import java.util.ArrayList;


/**
 * Represents a shop with a number of items
 * @author Peter Nerg
 */
public class Shop {
   private List<Product> lista = new ArrayList<>();
  /**
   * TODO it must be possible to add/list product in the shop
   */
  public void addProduct(Product product) {
  lista.add(product);


  }
public List<Product> getProducts(){

      return lista;
 //---------------------------------------------------------------------------------------
  }
  public void removeProduct(Product product){
    lista.remove(product);
  }

    public Product findProductInShop(String name) {
        Product match = null;
        for(int i = 0; i < lista.size(); i++ ){
            if(lista.get(i).name.equals(name)) {
                match = lista.get(i);
                break;
            }
        }
        return match;
    }
}

//-----------------------------------------------------------------------------------------