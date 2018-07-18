

enum PromotionEnum
{
	MONSOON, DISCOUNT50;
}

class FixedOrderPromotion implements Promotion{
	private double minimumPrice;
	private double fixedDiscount;
	
	@Override
	public void setMinimumPrice(double price){//to set minimum order amount
		minimumPrice=price;
	}
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}
	@Override
	public void setFixedDiscount(double discount) {//to set discount at the cart price
		fixedDiscount=discount;
		
	}
	@Override
	public double getFixedDiscount(double amount) {
		double amountAfterDiscount=amount-((fixedDiscount/100)*amount); //final amount is total-discount % available
		return amountAfterDiscount;
	}
	@Override
	public boolean isPromotionApplicable(String promoCode,double price) {
		boolean flag=false;
		boolean isCodeValid=false;
	
		for(PromotionEnum codes:PromotionEnum.values()){
			if(codes.name().equalsIgnoreCase(promoCode)){
				isCodeValid=true;
				break;
			}
			
		}
		if(price>getMinimumPrice() && isCodeValid){
			flag=true;
		}
		else{
			flag=false;

		}
		return flag;
	}
	
}