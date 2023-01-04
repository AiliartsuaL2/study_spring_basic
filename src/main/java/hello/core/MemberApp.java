package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl(); // 기존에는 본인이 생성해서 뽑아줬음

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 객체들을(@Bean) 관리해주는 스프링 컨테이너 ,, 파라미터로 Configuration 클래스 받음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//이름은 메서드 이름, 타입은 반환타 입


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+ member.getName());
        System.out.println("find Member = "+ findMember.getName());

    }
}
