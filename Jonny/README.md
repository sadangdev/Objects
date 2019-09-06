# 4장 데이터 중심 설계의 문제점

* 객체의 행동보다는 상태에 초점을 맞춘다
* 객체를 고립시킨다
* 캡슐화 위반
* 높은 결합도
* 낮은 응집도로 인해 코드 변경 어려움

## version1

## 데이터를 준비하자

* Q. Movie를 구현하는 데 필요한 데이터는? (우클릭 - 새 탭으로 링크 열기 해서 보시는게 편합니다)
    * [Movie.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-79f437f91bdfd34485d06cb2b5fcc132)

    * [MovieType.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-fa7182e2b3e87d3e8082750085bbe8c0)

* Q. 할인 조건을 구현하는 데 필요한 데이터는?
    * [DiscountCondition.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-2339d80eedf995edb44c68d702e5c6d1)

    * [DiscountCondition.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-cd30f898629348c2e55f435dced76a20)

...

* p.106 참고

## 영화를 예매하자

* [ReservationAgency.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-a12b51722e35c03bf401d8b52426cb03)

### reserve 메서드 파악하기

1. 여러개의 할인 조건에 대해 루프를 돌면서 할인 가능 여부를 확인하는 for문
2. discountable 변수 값 체크하고 할인 정책에 따라 예매 요금을 계산하는 if문

### 그래서 문제점이 뭐냐

1. 캡슐화 위반(p.113)
    * Movie클래스 - 오직 메서드를 통해서만 객체 내부 상태에 접근할 수 있다 (Getter, Setter)
    * Getter, Setter메서드는 객체 내부의 상태에 대한 어떤 정보도 캡슐화하지 못한다.
    * getFee, setFee메서드는 Movie 내부에 Money타입의 fee라는 이름의 인스턴스 변수가 존재한다는 사실을 퍼블릭 인터페이스에 노골적으로 드러낸다.
    * 근본적인 원인 - 객체가 수행할 책임이 아니라 내부에 저장할 데이터에 초점을 맞췄기 때문!!
    * Getter, Setter에 과하게 의존하는 설계 방식 - 추측에 의한 설계 전략(design-by-guessing strategy, Allen Holub)

2. 높은 결합도(p.115)
    * ReservationAgency - 한 명의 예매 요금을 계산하기 위해 Movie의 getFee메서드를 호출하고, 계산된 결과를 Money 타입의 fee에 저장한다.
    * 만약 fee의 타입을 변경해야 한다면? - 수정 폭탄
    * 이처럼 데이터 중심 설계는 객체의 캡슐화를 약화시키기 때문에 클라이언트가 객체의 구현에 강하게 결합된다.
    * ReservationAgency - 모든 의존성이 모이는 결합도의 집결지다. 시스템 안에서 뭐 하나 바꾸면 ReservationAgency는 반드시 바뀌어야 한다.

3. 낮은 응집도
    * ReservationAgency를 수정해야 하는경우?
        1. 할인 정책 추가
        2. 할인 요금을 계산법 변경
        3. 할인 조건 추가
        4. 할인 여부 판단법 변경
        5. 예매 요금 계산법 변경

    * 할인 정책 선택 코드와 할인 조건 판단 코드가 함께 존재
        * 새로운 할인 정책을 추가하는 게 할인 조건에도 영향을 미칠 수 있다.
        * 모듈의 응집도가 낮을 때 -> 아무런 상관도 없던 코드에 문제가 발생

    * 새로운 할인 정책을 추가해야 한다면?
        1. MovieType에 enum 추가
        2. ReservationAgency의 reserve 메서드의 switch구문에 case절 추가
        3. Movie에 데이터 추가

* 단일 책임 원칙(p.117)
    * 클래스는 단 한가지의 변경 이유만 가져야 한다.
    * 주의 - 여기에서 책임은 '변경의 이유'라는 의미로 사용된다. 역할, 책임, 협력에서의 책임의 의미와 다르다.

## 설계 트레이드 오프

## version2 - ReservationAgency 다이어트

* ReservationAgency의 reserve메서드에서 할인조건을 구하는 부분과 할인 요금을 구하는 부분을 나누고 적절한 객체로 이동(자율성 부여)

* [ReservationAgency.java](https://github.com/sadangdev/Objects/commit/c6d8078a9a8b43c4dc0aca843254bbef8323db00#diff-a12b51722e35c03bf401d8b52426cb03)

* [Movie.java](https://github.com/sadangdev/Objects/commit/c6d8078a9a8b43c4dc0aca843254bbef8323db00#diff-79f437f91bdfd34485d06cb2b5fcc132)

* [Screening.java](https://github.com/sadangdev/Objects/commit/96ffa51c62ae1c6ed5a1cdc070391eeeca941b9d#diff-cdd5e90cb565a48e02f6ebf3fd02febb)

## 하지만 여전히 부족하다

* 캡슐화 위반(p.126)
    * isDiscountable(DayOfWeek dayOfWeek, LocalTime time)
    * 요일정보와 시간정보가 파라미터라는 것을 외부에 노출
    * isDiscountable(int sequence)메서드도 마찬가지
    * DiscountCondition의 속성을 변경해야 한다면? 두 메서드의 파라미터 수정, 해당 메서드를 사용하는 모든 클라이언트도 함께 수정해야 한다.
    * 내부 구현의 변경이 외부로 퍼져나가는 파급 효과(ripple effect)는 캡슐화가 부족하다는 명백한 증거다.
    * 변경 후의 설계는 자기 자신을 스스로 처리한다는 점에서는 개선됐지만 여전히 내부의 구현을 캡슐화하는 데는 실패한 것

* 높은 결합도(p.128)
    * Movie와 DiscountCondition 사이의 결합도는 높을 수 밖에 없다.
    * 결합도가 높을 경우 한 객체의 구현을 변경하면?

* 낮은 응집도
    * Screening
    * DiscountCondition이 할인 여부를 판단하는 데 필요한 정보가 변경된다면?
    * Movie의 isDiscountable 메서드로 전달하는 파라미터의 종류 변경
    * isDiscountable를 호출하는 부분 함께 변경


# 4장의 코드를 통해서 배운 것

1. 설계방법론이 잘못 되었다면 리팩토링 아무리 해도 근본적인 문제 해결은 불가능하다.
2. Getter와 Setter를 남발하고 있다면 데이터 중심으로 설계하고 있는 것은 아닌지 의심해보자.
3. 데이터 중심 설계의 문제점은 다음과 같다
    1. 객체의 행동보다는 상태에 초점을 맞춘다
    2. 객체를 고립시킨다
    3. 캡슐화 위반
    4. 높은 결합도
    5. 낮은 응집도로 인해 코드 변경 어려움


