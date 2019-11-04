# simple-shop
Serves as a base for a simpler application emulating a web shop.

The _web shop_ is divided into four parts
* Basket - Contains items that a customer is to purchase
* Main  - The start point for the shop
* Product - Represents a single product (e.g. a soap or a radio)
* Shop - Is the shop which has a number of products

## Basket
It must be possible to add, remove, list items in the basket.

## Main
At instantiation it creates the `Shop` and adds a number of `Product`s to the shop.   
Has the command line menu to perform purchases.

The menu is to look like this:

### Top menu:
```
1. Shop
2. Basket
3. Cache out
0. Exit application
```

When the user caches out the basket is emptied and the quantity of products are permanently removed from the store.

### Shop menu:
```
1. List products in basket and their total price
2. Add product to basket
0. Back to top menu
```

When adding a product the user must be prompted for the identity of the product and the quantity.
Products added to the basket must be deducted from the shop quantity.

### Basket menu:
```
1. List basket
2. Remove product from basket
3. Empty basket
0. Back to top menu
```

When the user removes a product from the basket the user must be prompted for the identity and the quantity to remove.
Removed items must be returned back to the shop.

# Run the shop
Run the command `sbt run` in a terminal