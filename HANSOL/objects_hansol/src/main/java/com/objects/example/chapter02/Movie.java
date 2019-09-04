package com.objects.example.chapter02;

import java.time.Duration;

public class Movie
{
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy)
    {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee()
    {
        return fee;
    }

    /**
     * 간단해 보이지만 자그마치 세개의 기술이 합쳐진 컴비네이션 함수
     * 추상화(ABSTRACTION), 상속(Inheritance), 다형성(Polymorphism)
     * @param screening
     * @return
     */
    public Money calculateMovieFee(Screening screening)
    {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
