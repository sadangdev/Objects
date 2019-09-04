package object2;

public class NoneDiscountPolicy extends DiscountPolicy{

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.Zero;
	}

	@Override
	public String toString() {
		return "NoneDiscountPolicy [amount=0]";
	}
	
}
