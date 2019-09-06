package object4;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
//				new AmountDiscountPolicy(Money.wons(800),
//						new SequenceCondition(1),
//						new SequenceCondition(10),
//						new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,  0), LocalTime.of(11, 59)),
//						new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,  0), LocalTime.of(20, 59))));
		
//		Movie titanic = new Movie("타이타닉", Duration.ofMinutes(180), Money.wons(11000),
//				new PercentDiscountPolicy(0.1,
//						new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,  0), LocalTime.of(16, 59)),
//						new SequenceCondition(2),
//						new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,  0), LocalTime.of(13, 59))));
		
//		avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1,
//				new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,  0), LocalTime.of(16, 59)),
//				new SequenceCondition(2),
//				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,  0), LocalTime.of(13, 59))));
		
//		Movie starwars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000), new NoneDiscountPolicy());
		
		Movie avatar = new Movie();
		avatar.setTitle("아바타");
		avatar.setRunningTime(Duration.ofMinutes(120));
		avatar.setFee(Money.wons(10000));
		avatar.setMovieType(MovieType.AMOUNT_DISCOUNT);
		
		DiscountCondition condition1 = new DiscountCondition();
		condition1.setType(DiscountConditionType.PERIOD);
		condition1.setDayOfWeek(DayOfWeek.MONDAY);
		condition1.setStartTime(LocalTime.of(10,  0));
		condition1.setEndTime(LocalTime.of(11, 59));
		
		ArrayList<DiscountCondition> al = new ArrayList<>();
		al.add(condition1);
		
		avatar.setDiscountConditions(al);
		avatar.setDiscountAmount(Money.wons(800));
		
		System.out.println(avatar.toString());
		
		Screening screening = new Screening();
		screening.setMovie(avatar);
		screening.setSequence(1);
		screening.setWhenScreened(LocalDateTime.of(2019, 9, 2, 11, 0));
		
		ReservationAgency ra = new ReservationAgency();
		
		Customer customer1 = new Customer("손님1", "customer1");
		
		System.out.println(ra.reserve(screening, customer1, 1));
		System.out.println(ra.reserve(screening, customer1, 1).getFee());
		
//		System.out.println(titanic.toString());
//		System.out.println(starwars.toString());
	}

}
