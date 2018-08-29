import java.util.HashMap;
import java.util.Map;

/*
 * FixedOrderPromotion class contains Promotion Interface methods
 * gives discount offer on products depending on quantity
 */
class FixedProductPromotion implements Promotion{

	enum PromotionEnum {
	    MONSOON,
	    SUNDAYSALE,
	    DISCOUNT20;
	    
	}
	
	public Map<String, Integer> promoCodesDiscount= new HashMap<String, Integer>(); //Hash map containing promocodes and discount to be offered
	private double minimumPrice;
    private double fixedDiscount;
    public void setPromocodes()
    {
    	promoCodesDiscount.put("MONSOON", 10);
    	promoCodesDiscount.put("DISCOUNT20",20);
    	promoCodesDiscount.put("SUNDAYSALE",15);
    }
    
    //method to set Minimum amount of the item purchased
	@Override
	public void setMinimumPrice(double price) {
		minimumPrice=price;
	}
	
	//method returing minimum price upto which offer can be availed
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

	//method to set a fixed amount of discount to be offered
	@Override
	public void setFixedDiscount(double discount) {
		fixedDiscount=discount;
	}

	//method returning amount to be deducted from price of items
	@Override
	public double getFixedDiscount(double amount) {
		
		double amountLess = (fixedDiscount / 100) * amount; //@retrun price that is to be less over total item price
        System.out.println("amountLess:::::::"+amountLess);
		return amountLess;
	}
	
	//method to check whether the promocode is valid or not
	@Override
	public boolean isPromotionApplicable(String promoCode, double price) {
		
		 boolean flag = false;
	        boolean isCodeValid = false;
	        promoCode=promoCode.toUpperCase();
	        for (PromotionEnum codes: PromotionEnum.values()) {
	            if (codes.name().equals(promoCode)) {
	                isCodeValid = true;
	                break;
	            }
	        }
	        
	        if (price > getMinimumPrice() && isCodeValid) {
	        	setPromocodes();
	        	int discountPercent=0;
	        	try
	        	{
	        		discountPercent=promoCodesDiscount.get(promoCode);
	        	}
	        	catch(Exception e)	
	        	{
	        		e.printStackTrace();
	        	}
	        	
	        	setFixedDiscount(discountPercent);
	            flag = true;
	        } else {
	            flag = false;

	        }
	        return flag;
	    }
	
}