class FixedProductPromotion implements Promotion{

	@Override
	public void setMinimumPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMinimumPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFixedDiscount(double discount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getFixedDiscount(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPromotionApplicable(String promoCode, double price) {
		// TODO Auto-generated method stub
		return false;
	}
	
}