package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 컴포넌트 스캔을 하지 않을 대상 선택
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),

        // 컴포넌트 스캔의 시작 위치 지정
        basePackages = "hello.core"

        // 해당 클래스의 패키지를 시작 위치로 지정
        //basePackageClasses = AutoAppConfig.class
)
public class AutoAppConfig {

    /* 이미 MemoryMemberRepository에 @Component를 통해 빈 등록이 되어있는데 추가로 등록하면 Bean이 충돌이 일어남,
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    */

}
