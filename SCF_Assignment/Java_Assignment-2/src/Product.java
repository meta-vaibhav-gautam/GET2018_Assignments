import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
 class Product conains methods relating to
 cart like add, remove, update item quantity etc.
*/

class Product {
    int productId;
    String productName;
    double productPrice;
    double discount;
    Scanner sc = new Scanner(System.in);
    Product() {
        setProducts();
    }
    Product(int productId, String productName, double productPrice, double discount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
    }

    HashMap < Integer, Product > productList = new HashMap < Integer, Product > (); //stores the product objects
    List < Product > cartItems = new LinkedList < Product > (); // linked list stores the cart items
    List < Integer > productQuantity = new ArrayList < Integer > (); //for storing items quantity
    
    //method to set products in the hashmap
    private void setProducts() {

        productList.put(1, new Product(1, "bottle", 1000, 10));
        productList.put(2, new Product(2, "bag", 2000, 20));
        productList.put(3, new Product(3, "shirt", 5000, 20));
        productList.put(4, new Product(4, "jeans", 6000, 10));
        productList.put(5, new Product(5, "TV", 9000, 15));
    }

    //method to add items inside cart
    public void addToCart() {
        int quantity = 0;
        int productQuantityIndex = 0;
        int indexOfProduct=0;
        int count=0;
        char choice = 'y';
        System.out.println("Enter the item no. to add into the cart: ");
        while (choice == 'y') {
        	int productNumber=sc.nextInt();
        	for(Product items:cartItems) //logic to check whether the entered product id already in cart
        	{
        		if(productNumber==items.productId)
        		{
        			indexOfProduct=count;
        			break;
        		}
        		count++;
        	}
            if(count==cartItems.size())
            {
            	cartItems.add(productList.get(productNumber));
            	System.out.println("Quantity: ");
                quantity = sc.nextInt();
                productQuantity.add(cartItems.size()-1, quantity);
            }
            else
            {
            	System.out.println("Quantity: ");
                quantity = sc.nextInt();
                int number=productQuantity.remove(count);
                productQuantity.add(count, quantity+number);
            }
            

            System.out.println("Do you want to add more items ?(y/n)");
            choice = sc.next().charAt(0);
            count=0;
        }

        showCartItems();
        showChoiceMenu();
    }

    //method to remove items from cart
    private void removeFromCart() {
        char choice = 'y';
        while (choice == 'y') {
            System.out.println("Enter the item no. to remove it: ");
            int removeIndex = sc.nextInt();
            System.out.println("Quantity you want to remove: ");
            int removeQuantity= sc.nextInt();
            if(removeQuantity==productQuantity.get(removeIndex-1))
            {
            	cartItems.remove(removeIndex - 1);
            	productQuantity.remove(removeIndex-1);
            }
            else
            {
            	int quantity=productQuantity.get(removeIndex-1);
            	productQuantity.remove(removeIndex-1);
            	productQuantity.add((removeIndex-1), (quantity-removeQuantity));
            }
            
            System.out.println("Do you want to remove more items ?(y/n)");
            choice = sc.next().charAt(0);
        }
        showCartItems();
        showChoiceMenu();
    }

    //method to update product quantity in cart
    private void updateProductQuantity() {
        System.out.println("Enter the product no.: ");
        int productNumber = sc.nextInt();
        System.out.println("updated quantity: ");
        int productQuantity = sc.nextInt();
        this.productQuantity.remove(productNumber - 1);
        this.productQuantity.add((productNumber - 1), productQuantity);
        showCartItems();
        showChoiceMenu();
    }

    //method to show cart items
    private void showCartItems() {
        System.out.println("Items in cart:");
        int index = 0;
        System.out.println("\nitem\tQty\tMRP");
        for (Product items: cartItems) {
            System.out.println(items.productName + "\t" + productQuantity.get(index++) + "\t" + items.productPrice);
        }
    }

    //method to show products
    public void showProducts() {
        System.out.println("PRODUCTS AVAILABLE\n");
        System.out.println("number" + "\t\t" + "Products" + "\t\t" + "MRP" + "\t\t" + "discount");
        for (Product items: productList.values()) {
            System.out.println(items.productId + "\t\t" + items.productName + "\t\t\t" + items.productPrice + "\t\t" + items.discount + " %");
        }
    }
    
    //method to show choice menu
    private void showChoiceMenu() {
        System.out.println("\nEnter your choice\n1.Add item to cart  2.remove any item  3.update quantity  4. proceed to bill");
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

    //method to generate bill amount after discount offered
    private void generateBill() {
        double totalAmount = 0;
        int index = 0;
        FixedProductPromotion obj1=new FixedProductPromotion();
        System.out.println("HAVING PROMOCODE ???(y/n)");
        char choice = sc.next().charAt(0);
        totalAmount=getTotalAmount();
        if (choice == 'n') {
            System.out.println("Total Price = " + totalAmount + " /- only\nThanks for shopping.");
        } else if(choice == 'y'){
            System.out.println("Enter the Promocode: ");
            String promocode = sc.next();
            FixedOrderPromotion orderObj = new FixedOrderPromotion();
            FixedProductPromotion productObj=new FixedProductPromotion();
            orderObj.setMinimumPrice(10000);
            productObj.setMinimumPrice(5000);
             
            for(Product item:cartItems)
            {
            	double totalItemPrice=item.productPrice*productQuantity.get(index);
            	System.out.println(item.productName+":::::"+totalItemPrice);
            	if(productObj.isPromotionApplicable(promocode, totalItemPrice))
            	{
            		System.out.println(item.productName+" has discount of Rs. "+productObj.getFixedDiscount(totalItemPrice));
            		item.productPrice=totalItemPrice-productObj.getFixedDiscount(totalItemPrice);
            	}
            	else
            	{
            		System.out.println("else part");
            		item.productPrice=totalItemPrice;
            	}
            	index++;
            }
            totalAmount=0;
            for(Product items: cartItems)
            {
            	totalAmount+=items.productPrice;
            }
            if (orderObj.isPromotionApplicable(promocode, totalAmount)) {
            	System.out.println("\nPromocode Apllied ! Bill deducted with Rs. "+orderObj.getFixedDiscount(totalAmount));
                System.out.println("\nTotal amount to be paid: "+(totalAmount-(orderObj.getFixedDiscount(totalAmount)))+" -/ only\nThanks for shopping.");
            } else {
                System.out.println("\nInvalid Promocode !");
            	System.out.println("\nTotal Price = " + totalAmount + " /- only\nThanks for shopping.");
            }
        }
        else 
        {
        	System.out.println("Invalid choice ! press either 'y' for yes or 'n' for no.");
        	generateBill();
        }

    }

    //method to get total amount of the products in cart
    public double getTotalAmount()
    {
    	int index=0;
    	double totalAmount=0;
    	for (Product item: cartItems) {
            totalAmount += (item.productPrice * productQuantity.get(index++));
        }
    	return totalAmount;
    }
}