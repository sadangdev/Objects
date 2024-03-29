package object5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public abstract class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;
	
	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;
	
	public Movie(String title, Duration runningTime, Money fee, DiscountCondition ... discountConditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = Arrays.asList(discountConditions);
	}

	abstract protected Money calculateDiscountAmount();
	
	public Money calculateMovieFee(Screening screening) {
		if(isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream()
				.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}
	
	protected Money getFee() {
		return fee;
	}

}
