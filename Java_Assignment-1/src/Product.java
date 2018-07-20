import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
class Product conains methods relating to
cart like add, remove, update item quantity etc.
*/
public class Product {
    int productId;
    String productName;
    double productPrice;
    Scanner sc = new Scanner(System.in);
    Product() {
        setProducts();
    }
    Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    HashMap < Integer, Product > productList = new HashMap < Integer, Product > ();//stores the product objects
    List < Product > cartItems = new LinkedList < Product > ();// linked list stores the cart items
    List < Integer > productQuantity = new ArrayList < Integer > ();//for storing items quantity

  //method to set products in the hashmap
    public void setProducts() {

        productList.put(1, new Product(1, "item1", 10));
        productList.put(2, new Product(2, "item2", 20));
        productList.put(3, new Product(3, "item3", 50));
        productList.put(4, new Product(4, "item4", 60));
        productList.put(5, new Product(5, "item5", 90));
    }

  //method to add items inside cart
    public void addToCart() {
        int quantity = 0;
        int productQuantityIndex = 0;
        char choice = 'y';
        System.out.println("Enter the item no. to add into the cart: ");
        while (choice == 'y') {
            cartItems.add(productList.get(sc.nextInt()));
            System.out.println("Quantity: ");
            quantity = sc.nextInt();
            productQuantity.add(productQuantityIndex++, quantity);

            System.out.println("Do you want to add more items ?(y/n)");
            choice = sc.next().charAt(0);
        }

        showCartItems();
        showChoiceMenu();
    }

  //method to remove items from cart
    public void removeFromCart() {
        char choice = 'y';
        while (choice == 'y') {
            System.out.println("Enter the item no. to remove it: ");
            int removeIndex = sc.nextInt();
            cartItems.remove(removeIndex - 1);
            System.out.println("Do you want to remove more items ?(y/n)");
            choice = sc.next().charAt(0);
        }
        showCartItems();
        showChoiceMenu();

    }

  //method to generate bill amount
    public void generateBill() {
        double totalAmount = 0;
        int index = 0;
        for (Product item: cartItems) {
            totalAmount += (item.productPrice * productQuantity.get(index++));
        }
        System.out.println("Total Price = " + totalAmount + " /- only\nThanks for shopping.");
    }

  //method to update product quantity in cart
    public void updateProductQuantity() {
        System.out.println("Enter the product no.: ");
        int productNumber = sc.nextInt();
        System.out.println("updated quantity: ");
        int productQuantity = sc.nextInt();
        this.productQuantity.add((productNumber - 1), productQuantity);
        showCartItems();
        showChoiceMenu();
    }

  //method to show cart items
    public void showCartItems() {
        System.out.println("Items in cart:");
        int index = 0;
        for (Product items: cartItems) {
            System.out.println(items.productName + "\t" + productQuantity.get(index++) + "\t" + items.productPrice);
        }
    }

    public void showProducts() {
        System.out.println("PRODUCTS AVAILABLE\n");
        for (Product items: productList.values()) {
            System.out.println(items.productId + "\t\t" + items.productName + "\t\t" + items.productPrice);
        }
    }
 
    //method to show choice menu
    private void showChoiceMenu() {
        System.out.println("Enter your choice\n1.Add item to cart  2.remove any item  3.update quantity  4. proceed to bill");
        int Choice = sc.nextInt();
        switch (Choice) {
            case 1:
                addToCart();
                break;
            case 2:
                removeFromCart();
                break;
            case 3:
                updateProductQuantity();
                break;
            case 4:
                generateBill();
                break;
            default:
                System.out.println("Incorrect choice...");
        }
    }

}