import java.util.*;

class Product{
	int productId;
	String productName;
	double productPrice;
	Scanner sc=new Scanner(System.in);
	Product(){
		setProducts();
	}
	Product(int productId, String productName, double productPrice){
		this.productId=productId;
		this.productName=productName;
		this.productPrice=productPrice;
	}
	
	HashMap<Integer,Product> productList=new HashMap<Integer,Product>();
	List<Product> cartItems=new LinkedList<Product>();
	List<Integer> productQuantity=new ArrayList<Integer>();
	
	public void setProducts(){
		
		productList.put(1,new Product(1,"item1",10));
		productList.put(2,new Product(2,"item2",20));
		productList.put(3,new Product(3,"item3",50));
		productList.put(4,new Product(4,"item4",60));
		productList.put(5,new Product(5,"item5",90));
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
		System.out.println("Enter your choice\n1. remove any item  2.update quantity  3. proceed to bill");
		int furtherChoice=sc.nextInt();
		switch(furtherChoice){
			case 1:
				removeFromCart();
				break;
			case 2:
				updateProductQuantity();
				break;
			case 3:
				generateBill();
				break;
			default:
				System.out.println("Incorrect choice...");
		}
	}
	
	public void removeFromCart(){
		char choice='y';
		while(choice=='y'){
			System.out.println("Enter the item no. to remove it: ");
			int removeIndex=sc.nextInt();
			cartItems.remove(removeIndex-1);
			System.out.println("Do you want to remove more items ?(y/n)");
			choice=sc.next().charAt(0);
			}
		showCartItems();
		System.out.println("Enter your choice\n1. add any item  2.update quantity  3. proceed to bill");
		int furtherChoice=sc.nextInt();
		switch(furtherChoice){
			case 1:
				addToCart();
				break;
			case 2:
				updateProductQuantity();
				break;
			case 3:
				generateBill();
				break;
			default:
				System.out.println("Incorrect choice...");
			}
		
		}
	
	
	public void generateBill(){
		double totalAmount=0;
		int index=0;
		for(Product item:cartItems){
			totalAmount+=(item.productPrice*productQuantity.get(index++));
		}
		System.out.println("Total Price = "+totalAmount+" /- only\nThanks for shopping.");
	}
	
	public void updateProductQuantity(){
		System.out.println("Enter the product no.: ");
		int productNumber=sc.nextInt();
		System.out.println("updated quantity: ");
		int productQuantity=sc.nextInt();
		 this.productQuantity.add((productNumber-1), productQuantity);
		showCartItems();
		System.out.println("Enter your choice\n1. remove any item  2.update quantity  3. proceed to bill");
		int furtherChoice=sc.nextInt();
		switch(furtherChoice){
			case 1:
				removeFromCart();
				break;
			case 2:
				updateProductQuantity();
				break;
			case 3:
				generateBill();
				break;
			default:
				System.out.println("Incorrect choice...");
		}
	}
	
	public void showCartItems(){
		System.out.println("Items in cart:");
		int index=0;
		for(Product items:cartItems){
			System.out.println(items.productName+"\t"+productQuantity.get(index++)+"\t"+items.productPrice);
		}
	}
	
	public void showProducts(){
		System.out.println("PRODUCTS AVAILABLE\n");
		for(Product items:productList.values()){
			System.out.println(items.productId+"\t\t"+items.productName+"\t\t"+items.productPrice);
		}
	}
		
}

public class ShoppingCart {
	public static void main(String args[]){
		Product obj=new Product();
		obj.showProducts();
		obj.addToCart();
	}
}
