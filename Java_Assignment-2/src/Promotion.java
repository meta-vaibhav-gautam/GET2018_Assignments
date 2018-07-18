interface Promotion {
	
		public void setMinimumPrice(double price);
		public double getMinimumPrice();
		public void setFixedDiscount(double discount);
		public double getFixedDiscount(double amount);
		public boolean isPromotionApplicable(String promoCode, double price);
	
}
