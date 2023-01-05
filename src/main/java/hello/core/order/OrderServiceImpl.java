package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor // final 필드에 해당하는 생성자를 만들어주는 라이브러리(Lombok)
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy; // 인터페이스만 의존한다, 하지만 이렇게만 실행할경우 구현체가 없기 때문에 NPE 발생 >> 구현 객체를 주입해줘야 함

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 주석처리가 되었음, 클라이언트인 서비스 임플을 변경,,OSP 위반
                                                                            // 실질적으로는 class에도 함께 의존,, DIP 위반
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; // AppConfig를 통해 생성자를 통해 객체에 할당을 시킴
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); // 단일 책임 원칙

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
