import java.util.HashMap;
import java.util.Map;

//enum having promocodes
enum PromotionEnum {
    MONSOON,
    SUNDAYSALE,
    DISCOUNT20;
    
}

/*
 * class FixedOrderPromotion has methods to offer
 * discount on order price of the cart
 */
class FixedOrderPromotion implements Promotion {
    private double minimumPrice;
    private double fixedDiscount;
    public Map<String, Integer> promoCodesDiscount= new HashMap<String, Integer>();
    
   //method to set promocode in map
    public void setPromocodes()
    {
    	promoCodesDiscount.put("MONSOON", 10);
    	promoCodesDiscount.put("DISCOUNT20",20);
    	promoCodesDiscount.put("SUNDAYSALE",15);
    }
    
    //mrthod to set minimum order price
    @Override
    public void setMinimumPrice(double price) { //to set minimum order amount
        minimumPrice = price;
    }
    
    //method to get minimum oreder price
    @Override
    public double getMinimumPrice() {
        return minimumPrice;
    }
    
    //method to set fixed discount to be offered
    @Override
    public void setFixedDiscount(double discount) { //to set discount at the cart price
        fixedDiscount = discount;

    }
    
    //method to get fixed discount on the amount
    @Override
    public double getFixedDiscount(double amount) {
        double amountLess = (fixedDiscount / 100) * amount; //@retrun price that is to be less over total order price
        return amountLess;
    }
    
    //method to check whether a promocode is valid or not
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
        		System.out.println("\nCart Discount offered= "+discountPercent+" %");
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