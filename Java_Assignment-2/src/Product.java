import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
 class Product conains methods relating to
 cart like add, remove, update item quantity etc.
*/

class Product{
	int productId;
	String productName;
	double productPrice;
	double discount;
	Scanner sc=new Scanner(System.in);
	Product(){
		setProducts();
	}
	Product(int productId, String productName, double productPrice, double discount){
		this.productId=productId;
		this.productName=productName;
		this.productPrice=productPrice;
		this.discount=discount;
	}
	
	HashMap<Integer,Product> productList=new HashMap<Integer,Product>(); //stores the product objects
	List<Product> cartItems=new LinkedList<Product>();  // linked list stores the cart items
	List<Integer> productQuantity=new ArrayList<Integer>();  //for storing items quantity
	
	private void setProducts(){
		
		productList.put(1,new Product(1,"bottle",100,10));
		productList.put(2,new Product(2,"bag",2000,20));
		productList.put(3,new Product(3,"shirt",5000,20));
		productList.put(4,new Product(4,"jeans",6000,10));
		productList.put(5,new Product(5,"TV",9000,15));
	}
	
	
	public void addToCart(){
		int quantity=0;
		int productQuantityIndex=0;
		char choice='y';
		System.out.println("Enter the item no. to add into the cart: ");
		while(choice=='y'){
			cartItems.add(productList.get(sc.nextInt()));
			System.out.println("Quantity: ");
			quantity=sc.nextInt();
			productQuantity.add(productQuantityIndex++, quantity);
			
			System.out.println("Do you want to add more items ?(y/n)");
			choice=sc.next().charAt(0);
		}
		
		showCartItems();
		showChoiceMenu();
	}
	
	private void removeFromCart(){
		char choice='y';
		while(choice=='y'){
			System.out.println("Enter the item no. to remove it: ");
			int removeIndex=sc.nextInt();
			cartItems.remove(removeIndex-1);
			System.out.println("Do you want to remove more items ?(y/n)");
			choice=sc.next().charAt(0);
			}
		showCartItems();
		showChoiceMenu();
		}
	
	private void updateProductQuantity(){
		System.out.println("Enter the product no.: ");
		int productNumber=sc.nextInt();
		System.out.println("updated quantity: ");
		int productQuantity=sc.nextInt();
		this.productQuantity.remove(productNumber-1);
		this.productQuantity.add((productNumber-1), productQuantity);
		showCartItems();
		showChoiceMenu();
	}
	
	private void showCartItems(){
		System.out.println("Items in cart:");
		int index=0;
		for(Product items:cartItems){
			System.out.println(items.productName+"\t"+productQuantity.get(index++)+"\t"+items.productPrice);
		}
	}
	
	public void showProducts(){
		System.out.println("PRODUCTS AVAILABLE\n");
		System.out.println("number"+"\t\t"+"Products"+"\t"+"MRP"+"\t\t"+"discount");
		for(Product items:productList.values()){
			System.out.println(items.productId+"\t\t"+items.productName+"\t\t"+items.productPrice+"\t\t"+items.discount+" %");
		}
	}
	
	private void showChoiceMenu(){
		System.out.println("Enter your choice\n1.Add item to cart  2.remove any item  3.update quantity  4. proceed to bill");
		int Choice=sc.nextInt();
		switch(Choice){
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
	
	private void generateBill(){
		double totalAmount=0;
		int index=0;
		System.out.println("HAVING PROMOCODE ???(y/n)");
		char choice=sc.next().charAt(0);
		if(choice=='n'){
		for(Product item:cartItems){
			totalAmount+=(item.productPrice*productQuantity.get(index++));
		 }
		 System.out.println("Total Price = "+totalAmount+" /- only\nThanks for shopping.");
		}
		else{
			System.out.println("Enter the Promocode: ");
			String promocode=sc.next();
			for(Product item:cartItems){
				totalAmount+=(item.productPrice*productQuantity.get(index++));
			 }
				FixedOrderPromotion obj=new FixedOrderPromotion();
				obj.setMinimumPrice(10000);
				obj.setFixedDiscount(10);
				if(obj.isPromotionApplicable(promocode, totalAmount)){
				 System.out.println("Amount after discount: "+obj.getFixedDiscount(totalAmount));
			   }
				else{
					 System.out.println("Total Price after discount = "+totalAmount+" /- only\nThanks for shopping.");

				}
		}
		
	}
		
}
