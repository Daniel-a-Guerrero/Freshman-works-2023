// ***************************************************************
// ShoppingCart.java
//
// Represents a shopping cart as an array of items
// ***************************************************************
import java.text.NumberFormat;
public class ShoppingCart
{
private int itemCount; // total number of items in the cart
private double totalPrice; // total price of items in the cart
private int capacity; // current cart capacity
private Item[] cart;
// ---------------------------------------------------------
// Creates an empty shopping cart with a capacity of 5 items.
// ---------------------------------------------------------
public ShoppingCart()
{
capacity = 5;
itemCount = 0;
totalPrice = 0.0;
cart=new Item[capacity];
}
// -----------------------------------------------------
// Adds an item to the shopping cart.
// -----------------------------------------------------
public void addToCart(String itemName, double price, int quantity)
{
cart.add(new Item(itemName, price, quantity));
totalPrice+=(price*quantity);
}
// -----------------------------------------------------
// Returns the contents of the cart together with
// summary information.
// -----------------------------------------------------
public String toString()
{
NumberFormat fmt = NumberFormat.getCurrencyInstance();
String contents = "\nShopping Cart\n";
contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
for (int i = 0; i < itemCount; i++)
contents += cart[i].toString() + "\n";
contents += "\nTotal Price: " + fmt.format(totalPrice);
contents += "\n";
return contents;
}
// -----------------------------------------------------
// Increases the capacity of the shopping cart by 3
// -----------------------------------------------------
private void increaseSize()
{
Item[] newCart=new Item[(cart.length())+3];
for (int i=0;i<cart.length();i++)
{newCart[i]=cart[i];}
cart=newCart;
}
} 