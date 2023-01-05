# study_spring_basic
인프런 김영한 '스프링 핵심 원리 기본편' 라이브 코딩 및 필기

스프링 이야기
- 스프링 이전엔 EJB(Enterprise Java Beans)가 있었음,, 근데 한대당 수천만원 급으로 비쌌음
    - ORM도 지원하고, 분산기술등으로 이론적으론 좋았음
        - 실질적으론 어렵고 복잡하고 느림
        - 여기서 POJO(PlainOldJavaObject)가 나옴
    - Hibernate의 등장,, >> Java에서 공식적으로 JPA(실용성 + 안정성) 채택
- 표준 인터페이스 : JPA 
    - 구현체들 : Hibernate(80%이상 선점), EclipseLink 등등,, 
- 스프링의 탄생
    - 로드존슨이 예제 코드 작성함 
        - EJB의 문제점 지적,,
        - 여기서 스프링 핵심 개념 기반의 내용이 나옴
    - 유겐 휠러 ~~ 오픈소스 프로젝트 제안,, J2EE(EJB)라는 겨울을 넘은 스프링이라는 이름 나옴

스프링이란?
- 필수 
    - 스프링 프레임워크 
        - 핵심 기술 : 스프링 DI 컨테이너, AOP , 이벤트., 등등
    - 스프링 부트
        - 스프링을 편리하게 사용 할 수 있도록 지원(dependency 설정 등) 최근에는 기본적으로 사용
        - 톰캣같은 웹 서버를 내장해서 단독으로 실행 할 수 있는 스프링 애플리케이션 쉽게 생성
        - 손쉬운 빌드 구성을 위한 starter 종속성 제공
        - 스프링과 3rd parth 라이브러리 자동 구성 (버전을 자동 맞춤)
        - 관례에 의한 간결한 설정 _ 필요한 경우 커스터마이징 가능
- 선택
    - 스프링 데이터
        - DB를 편하게 연동해주는
        - 제일 많이 쓰는건 스프링 데이터 JPA
    - 스프링 세션 : 세션 응용 기술
    - 스프링 시큐리티 : 보안 관련 기술
    - 스피링 Rest Docs : 문서 지원 기술
    - 스프링 배치 : 배치처리에 특화된 기술
    - 스프링 클라우드 : 클라우드 기술
    - 등등등
스프링 단어
- 스프링이라는 단어는 문맥에 따라 다르게 사용
    - 스프링 DI 컨테이너 기술
    - 스프링 프레임워크
    - 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계,,
- 스프링의 핵심 컨셉
    - 좋은 객체 지향 애플리케이션을 개발 할 수 있게 도와주는 프레임워크

좋은 객체지향 프로그래밍 : 유연하고 변경이 용이한 프로그래밍
- 캡슐화
- 상속
- 추상화
- 다형성 : 클라이언트를 변경하지않고, 서버의 구현 기능을 유연하게 변경 할 수 있다.
    - 역할에 대해서만 의존을 하고, 구현에는 의존을 하지 않는다.
        - 유연해지고 변경도 편리해진다.
        - 클라이언트는 구현 대상의 내부 구조를 몰라도 되고, 변경되어도 영향을 받지 않는다.
        - 역할 : 인터페이스 추상 클래스 , 구현 : 인터페이스를 구현한 클래스나 구현 객체
    - 자바 언어에서의 다형성은 오버라이딩, 오버로딩
    - 인터페이스를 안정적으로 잘 설계하는것이 중요하다.

스프링과 객체 지향
- 다형성이 가장 중요하다.
- 스프링은 다형성을 극대화 해서 이용 하도록 도와준다.
- 제어의 역전, 의존관계 주입은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.

좋은 객체지향 설계의 5가지 원칙. SOLID
- SRP : 단일 책임 원칙
    - 하나의 클래스는 하나의 책임만 가져야 한다.
    - 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것.
- OCP : 개방-폐쇄 원칙 ,, 스프링에서 가장 중요!
    - 소프트웨어 요소는 확장에는 열려 있으나, 변경에는 닫혀 있어야 한다.
    - 다형성을 활용해보면
        - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 구현한다
        - 구현 객체를 변경 하려면 클라이언트 코드를 변경해야 한다.
            - OCP 원칙을 지킬 수 없음
        - 문제 해결을 위해서 객체를 생성하고 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다.
- LSP : 리스코프 치환 원칙
    - 프로그램 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
        - 기능적으로 보장을 해야함, 인터페이스에서 규약을 걸어주는것. (지키지 않을시 컴파일 불가)
- ISP : 인터페이스 분리 원칙
    - 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다.
    - 인터페이스 자체가 변해도 다른 클라이언트에게 영향을 주지 않도록 독립적인 기능으로 분리를 시켜야 한다.
    - 인터페이스가 명확해지고 대체 가능성이 높아진다.
- DIP : 의존관계 역전 원칙 얘도 스프링에서 가장 중요
    - 프로그래머는 추상화에 의존해야지, 구체화에 의존하면 안된다.
        - 역할에 의존해야지 구현에 의존하면 안됨
- 다형성 만으로는 OCP,DIP를 지킬 수 없고, 뭔가 더 필요하다.
    - 스프링은 OCP,DIP를 가능하도록 DI, DI 컨테이너를 제공해준다.
- 인터페이스 도입시 추상화라는 비용이 발생한다.
- 기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용 후 필요 할 때 리팩터링해서 인터페이스를 도입하는것도 방법이다.

프로젝트 생성
- 스프링 부트 생성
- 컴파일 인텔리제이로 실행 설정
    - Preference > Gradle > Build and runusing: gradle
    - Preference > Gradle > run tests using: gradle 
- 구현체가 하나면 관례상 구현체를 ServiceImpl 이라고 많이 씀..
- Enum 타입 비교는 ==으로 함
- 테스트 파일 만드는 단축키 : 클래스 레벨에 커서 두고 command + shift+ t
- 기존 코드에는 인터페이스와 클래스 둘 다 의존하고 있었음,
    - 인터페이스만 의존하게 설정하면 NPE 발생,, 구현체를 지정해줘야함 ,,

관심사의 분리
- 객체마다 책임을 확실히 분리해야 함,
- AppConfig 등장 : 애플리케이션 전체 동작 방식을 구성(config)하기위해 구현 객체를 생성하고, 연결하는 책임을 갖는 별도의 설정 클래스를 만든다.
    - 애플리케이션의 실제 동작에 필요한 구현 객체를 생성 함 !
    - 생성한 객체 인터페이스의 참조를 생성자를 통해 주입(연결)해준다 .
    - 설계 변경으로 Impl은 구현한 Repo 클래스를 의존하지 않음,
        - 단지 Repo 인터페이스에 의존한다.
        - 의존관계에 대한 고민은 외부에 맡기고, 실행에만 집중하면 된다…!!
        - AppConfig가 구현체들에대한 객체를 생성해줌 >> DIP 완성
    - 관심사의 분리가 되었음,, 객체를 생성하고 연결하는 역할 / 실행하는 역할
        - memberServiceImpl 입장에서는 의존 관계를 마치 외부에서 주입해주는 것 같다고 해서 DI,, 의존성 주입이라고 함.
        - AppConfig를 통해 관심사를 확실히 분리 했음, 구체 클래스를 선택해줌,,
        - Impl은 기능을 실행하는 책임만 진다.
    - AppConfig 리팩터링
        - 구현체의 중복을 제거해서 다른 구현체로 변경시 하나만 변경하면 되도록 리팩토링 처리 
        - 사용 영역의 어떤 코드도 변경 할 필요가 없음, 구성 영역은 변경시켜야함.

프로젝트내에서의 SOLID
- SRP 단일 책임 원칙을 따르며 관심사를 분리함
    - 구현 객체를 생성하고 연결하는 책임은 AppConfig 담당
    - 클라이언트 객체는 실행하는 책임만 담당
- DIP 의존관계 역전 원칙 / 추상화에 의존해야지, 구체화에 의존하면 안된다.
    - 기존 서비스는 추상화에 의존하면서도 동시에 구체화 구현 클래스에도 함께 의존했음
    - AppConfig를 통해 객체 인스턴스를 클라이언트 코드 대신 생성해서 클라이언트 코드에 의존관계를 주입.
- OCP 개방 폐쇄의 원칙 / 확장에는 열려있고 변경에는 닫혀있어야 한다.
    - 애플리케이션을 사용영역과 구성 영역으로 나눴음
    - AppConfig가 의존관계를 클라이언트 코드에 주입(구현체 생성자를 통해)
    - 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다.

프레임워크 vs 라이브러리
- 프레임워크는 내가 작성한 코드를 제어하고,. 대신 실행
- 라이브러리는 내가 작성한 코드를 직접 제어의 흐름을 담당

IOC , DI, 컨테이너
- IOC 제어의 역전 : 프로그램의 제어 흐름을 직접 제어하는것이 아니라 외부에서 관리하는 것
    - 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 객체를 생성하고, 연결하고, 실행했다.
    - AppConfig 등장 이후, 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 AppConfig가 가져감  프로그램의 제어 흐름을 모두 AppConfig가 생성 및 제어
- DI 의존관계 주입 
    -  정적인 클래스 의존관계
        - import 코드만 보고도 의존관계 쉽게 판단 가능 / 정적인 클래스 의존관계는 코드를 실행하지 않아도 분석이 가능
        - 정적인 클래스 의존관계만으로는 실제 어떤 객체가 올 지는 알 수가 없다.
    - 실행 시점에 결정되는 동적인 객체 인스턴스 의존관계
        - 실행시점에 외부(AppConfig)에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는것을 의존관계 주입이라고 한다.
    - 의존관계 주입을 사용하면 클라이언트 코드를 변경하지않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경 할 수 있다.
    - 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 관계를 변경 할 수 있다.
- IoC 컨테이너, DI 컨테이너, 둘이 같은 말 ,, 최근에는 DI 컨테이너라고 함 
    - AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는 것 

스프링으로 전환하기
- 스프링 컨테이너
    - 스프링 컨테이너는 BeanFactory와 ApplicationContext로 구분해서 이야기 하는데, BeanFactory를 직접 사용 하는 경우는 거의 없으므로, 일반적으로 ApplicationContext가 스프링 컨텍스트라고 한다.
    - 기존에는 개발자가 AppConfig를 사용해서 직접 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너로 사용
    - @Configuration이 붙은 클래스를 설정정보로 사용하고, @Bean인 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
        - 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 함
        - 스프링 빈은 @Bean이 붙은 이름(default : 메서드 이름, name속성으로 설정 가능)을 스프링 빈 이름으로 사용한다.
            - 빈 이름은 항상 다른 이름을 부여해야함 
        - 이전에는 AppConfig를 직접 조회했지만, 이제는 스프링 컨테이너를 통해 필요한 스프링 빈을 찾아야 함
        - applicationContext.getBean(이름,타입)으로 스프링 빈을 찾을 수 있다.
        - 스프링 컨테이너에서 스프링 빈을 찾아서 사용해야한다.
        - 빈들간 동적인 의존관계를 설정해준다. 
        - 스프링은 빈을 생성하고 의존관계를 주입하는 단계가 나누어져있다, 그런데 자바코드로 스프링 빈을 등록하면 생성자 호출하며 의존관계 주입도 한 번에 처리한다.
    - 스프링 컨테이너의 장점 : ??? 어마어마 함,,
    - 컨테이너 생성 과정 
        - 스프링 컨테이너는 XML 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스를 만들 수 있다.
        - ApplicationContext : 스프링 컨테이너, 인터페이스
        - AnnotationConfigApplicationContext : 애노테이션 기반 구현체
    - 스프링 빈 조회 - getBean을 하면 되는데,, 잘 쓸일이 없음,,
        - 컨테이너에 등록된 모든 빈 조회
            - ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회
            - ac.getBean(빈이름,타입) or ac.getBean(타입) : 빈 이름 혹은 타입 으로 빈 객체를 조회한다.
                - 없는 빈 조회시 NoSuchBeanException 발생
        - 동일한 타입이 둘 이상인 경우 : 
            - NoUniqueBeanDefinitionException 발생
            - 해결 방법 : 빈의 이름을 설정해준다.
            - ac.getBeansOfType() 사용 시 해당 타입의 모든 빈 조회 가능
        - 상속관계
            - 부모타입으로 조회하면 자식 타입도 함께 조회한다.
    - BeanFactory와 ApplicationContext
        - ApplicationContext는 BeanFactory를 상속받은 인터페이스.
        - BeanFactory는 스프링 컨테이너의 최상위 인터페이스
            - 스프링 빈을 관리하고 조회하는 역할을 담당한다.
            - getBean()등을 제공
        - ApplicationContext : BeanFactory의 모든 기능을 상속받아서 제공,
            - 메세지소스를 활용한 국제화 기능
                - 웹사이트 내 국제화 파일등을 분리해놓음..
            - 환경 변수
                - 로컬, 개발(테스트서버), 운영등을 구분해서 처리
            - 애플리케이션 이벤트
                - 이벤트를 발행하고, 구독하는 모델을 편리하게 지원
            - 편리한 리소스 조회
                - 파일, 클래스패스, 외부등에서 리소스를 추상화시켜 편리하게 조회하는 기능
        - 다양한 설정 형식 지원,, : 요즘엔 거의 자바파일, 예전엔 XML,, Groovy도 지원
            - 자바코드
                - new AnnotationConfigApplicationContext(AppConfig.class)
            - XML
                - 요즘엔 거의 안쓰지만, 아직 많은 레거시 프로젝트들이 XML로 되어있음,,
        - 스프링 빈 설정 메타 정보 - BeanDefinition
            - BeanDefinition으로 추상화시켜서 @Bean, <bean>당 하나씩 메타 정보를 생성함,,
                - 스프링 컨테이너는 이 메타 정보를 기반으로 스프링 빈을 생성한다!
                - AnnotateBeanDefinitionReader를 통해서 @Configuration을 읽어 @Bean에 해당하는 빈의 메타정보를 생성한다.
                - 직접 생성해서 스프링 컨테이너에 등록 할 수 있지만 직접 정의할 일은 거의 없음
                - 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용한다 정도만 이해

* test
    * Assertion
        * junit
            * assertThrow
        * assertj
            * assertThat
                * isEqualTo : 값을 비교하는 메서드이지만, 객체를 비교하는경우 참조를 비교하게 된다.
                * isSameAs : 참조가 같은지 비교한다.

싱글톤 컨테이너
- 스프링은 기업용 온라인 서비스 기술 지원을 위해 탄생,
    - 대부분은 웹 어플리케이션이고, 웹이 아닌 개발도 얼마든지 개발 가능,, 
    - 웹 애플리케이션은 보통 여러 고객이 동시에 요청을 한다.
        - 싱글톤이 아닌 요청은 객체를 계속 생성을 한다. >> 트래픽 초당 100이면 초당 객체가 100개 이상으로 생성되고 소멸됨,,
        - 해결 방안은 해당 객체가 딱 1개만 생성되고 공유하도록,, >> 싱글톤 패턴
- 싱글톤 패턴 : 클래스의 인스턴스가 딱 1개만 생성되는것을 보장하는 디자인 패턴 
    - 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야 함
        - private 생성자를 사용, 외부에서 생성하지 못하도록 막아야 함 
        - 구현 방법은 여러가지가 있음
    - 고객의 요청이 올 때 마다 객체를 생성하는것이 아닌, 이미 만들어진 객체를 사용함,,
    - 단점
        - 구현 코드가 많이 들어감
        - 의존관계상 클라이언트가 구체 클래스에 의존 -> DIP 위반, OCP 원칙 위반 할 가능성이 높음
        - 유연하게 테스트하기 어려움
        - private 생성자를 사용하기 때문에 자식 클래스를 만들기 어려움
        - 안티패턴으로 불리기도 한다.

스프링의 싱글톤 컨테이너 : 싱글톤의 문제점을 다 해결하면서 인스턴스를 싱글톤으로 관리한다 !!
- 싱글톤 객체를 생성하고 관리하는 기능을 싱글톤 레지스트리라고 한다.
- 지저분한 코드가 들어가지 않아도 되고, DIP,OCP, 테스트의 유연성, private 생성자로부터 자유롭게 싱글톤을 사용 할 수 있다.
- 기본적으로는 싱글톤 사용하지만, 요청 할 떄마다 새로운 객체를 생성해서 반환하는 기능도 제공을 한다. (99.9%는 싱글톤사용)

싱글톤 방식의 주의점
- 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에, 상태를 유지하게 설계하면 안된다.
    - 항상 ! 무상태(stateless) 설계해야한다.
        - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
        - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
        - 가급적 읽기만 가능해야 한다.
        - 필드 대신 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야한다.
    - 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생 할 수 있다.

@Configuration과 싱글톤
- Configuration이 붙은 클래스도 빈에 등록이 된다. 근데
    - CGLIB라는 바이트코드 조작 라이브러리를  사용해서 AppConfig 클래스를 상속받은 다른 클래스를 만들고, 그 클래스를 스프링 빈으로 등록 한 것
        - @Bean이 붙은 메서드마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환하고, 없으면 만들었던 로직을 호출해주는 동적 코드가 생성됨.
        - AppConfig를 상속하고있기 빈 조회시 해당 빈이 호출 된 것
- @Configuration은 싱글톤을 위해서 존재함
    - @Configuration을 붙이지않으면 마찬가지로 빈이 등록이 되지만, 싱글톤이 보장되지않게 빈이 등록이 됨, (객체가 호출 할 때마다 다중 생성 됨)
- 스프링 설정 정보에는 항상 @Configuration을 한다.

컴포넌트 스캔과 의존관계 자동 주입
- 빈이 수백개가 넘어가면서 누락 할 수 있고, 굉장히 번거로워짐.. 따라서 설정정보 없이 자동으로 스프링 빈을 등록하는 컴포넌트 스캔을 지원
- @Autowired : 의존관계를 자동 주입해주는 애노테이션
    - 생성자에 붙여주면 해당 생성자의 타입에 맞는 빈을 찾아서 의존관계 주입을 자동으로 연결해서 주입한다.
        - 기본 조회 전략 : 스프링 빈 저장소에서 해당 빈을 타입에 맞추어 찾고, 등록한다.
        - 생성자에 파라미터가 많아도 다 찾아서 자동으로 주입을 해준다.

- @ComponentScan : @Component 애노테이션이 붙은 모든것들을 스프링 빈으로 자동 등록
    - 순서
        - 1. 컴포넌트 스캔에 해당하는 AppicationContext 실행시, @Component 가 붙은 모든 클래스를 스프링 컨테이너에 빈을 등록한다.
        - 2. @Autowired을 이용해서 타입을 기준으로 의존관계를 주입한다.
    - 속성
        - 필터
            - excludeFilters라는 속성을 지정해서 읽지 않을 어노테이션을 지정 할 수 있음
            - includeFIlters라는 속성을 지정하면 추가로 읽을 어노테이션 지정 가능
            - FilterType 옵션
                - ANNOTATION : 기본값(default), 애노테이션을 인식해서 동작한다.
                - ASSIGNABLE_TYPE : 지정한 타입과, 자식 타입을 인식해서 동작한다
                - ASPECTJ :  AspectJ 패턴 사용
                - REGEX : 정규 표현식
                - CUSTOM : TypeFilter 라는 인터페이스를 구현해서 처리
            - 관례 : @Component면 충분하기 때문에 includeFilter는 거의 안쓰고, 간혹 excludeFilter는 사용 할 일이 있긴 하다. 최근 스프링 부트는 컴포넌트 스캔을 기본적으로 제공하기때문에 스프링의 기본 설정에 최대한 맞추어 사용하는것을 권장,

        - 탐색 위치
            - basePackages = “” 지정으로 해당 패키지 및 하위 패키지 모두 탐색 (스캔 시작 위치를 지정 할 수 있다.)
                - 이게 없으면 모든 자바 파일 및 라이브러리를 다 확인함,, 시간 오래소요
            - baseClasses = “” / 지정한 클래스의 패키지를 탐색 시작 위치로 지정
                - default로 해당 컴포넌트 스캔이 있는 패키지를 basePackage로 지정
            - 권장 방법 : 패키지 위치를 지정하지 않고 설정 정보 클래스의 위치를 프로젝트 최상단에 둔다.
                - 최상단에 AppConfig 같은 메인 설정 정보를 두고, @ComponentScan 애노테이션을 붙이고, basePackages 지정 생략,,
                    - 이러면 해당패키지 포함 하위 패키지들을 모두 스캔의 대상으로 둠
                - 관례 : @SpringBootApplication이 있는 클래스를 프로젝트 시작루트에 둠 (ComponentScan이 있기 때문에 AppConfig등 따로 쓸 필요가 없음)
    - @Component를 사용 할 구현체에 붙여준다.
        - 스캔 기본 대상, 모두 @Component가 들어있기때문
            - @Component : 컴포넌트 스캔에서 사용
            - @Controller : 스프링 MVC 컨트롤러로 인식
            - @Service : 스프링 비즈니스 로직에서 사용,, 특별한 기능은 없음(개발자들끼리 비즈니스 계층 인식하는데 도움)
            - @Repository : 스프링 데이터 접근 계층으로 인식시키고, 데이터 계층의 예외를 스프링 예외로 변환시켜준다.
            - @Configuration : 스프링 설정 정보에서 사용, 싱글톤 유지하도록 추가 처리
        - 애노테이션은 상속 관계가 없음, 애노테이션 상속은 자바가 지원하는게 아니라 스프링이 지원하는 기능
    - 스프링 빈 기본 이름은 클래스명을 사용하되, 맨 앞글자만 소문자를 사용한다.
        - 직접 지정하고싶으면 @Conponent(“memberService2”) 이런식으로 지정 가능,, 왠만하면 Default 사용 권장 
    - 중복 등록과 충돌
        - 자동 빈 등록 vs 자동 빈 등록
            - ConflictingBeanDefinitionException 예외 발생 (이름을 설정해준경우..)
        - 수동 빈 등록 vs 자동 빈 등록
            - 수동 빈 등록이 우선권을 가져감(오버라이딩 처리 )
            - 개발자가 의도적으로 이런 결과를 기대했다면 우선권을 갖는것이 좋지만, 현실적으로는 설정이 꼬이는 경우가 대부분,,
            - 따라서 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본값을 바꾸었다.
                - SpringBootApplication 을 실행시에 충돌내게끔 처리함. 오버라이딩을 원하면 application.properties 변경해줘야함

자바 빈 프로퍼티 규약
- 게터 
    - return asdf;
- 세터
    - this.sadf = sadf;

스프링 라이프 사이클
- 스프링 컨테이너 생성
- 스프링 빈 등록
- 스프링 빈 의존관계 설정

의존관계 자동 주입 Autowired
- 주입할 대상이 없으면 오류 발생, 주입 대상이 없어도 동작하게 하려면 required 속성 false
- 의존관계 주입 방법
    - 생성자 주입
        - 생성자를 통해 의존관계를 주입 받는 방법 (생성자를 내부에서 생성하며 Autowired,)
        - 생성자 호출 시점에 딱 1번만 호출되는 것이 보장된다.
        - 불변, 필수 의존관계에 사용 ,, 외부에서 수정을 할 수 없음
            - private final가 있으면 생성자가 꼭 필요하기 때문에 필수이기때문에 필수값에 사용
        - 스프링 빈에 해당하는 클래스의 생성자가 딱 1개만 있는 경우, 자동으로 @Autowired가 세팅됨(Autowired 생략 가능)
        - 빈을 등록하면서 의존관계 주입이 같이 일어남 (최초 빈 등록을 하며 생성자를 호출해야하기 때문에 자동으로 설정)
    - 수정자(setter) 주입
        - setter를 만들고, @Autowired를 하면 연관관계가 주입됨
        - 선택적이고 변경 가능성 (거의 없음) 이 있는 경우 사용
    - 필드 주입 >> 쓰면 안됨
        - 필드 선언하고 해당 필드에 Autowired
        - DI 프레임워크가 없으면 아무것도 할 수 없음, 외부에서 변경이 불가능해서 테스트가 불가능 (setter 없이는 불가능,, )
        - 애플리케이션과 관계없는 테스트에서는 사용해도 됨
        - Configuration 클래스에서는 사용해도 됨 (DI 프레임워크에서만 클래스를 사용하니까),, 이것도 권장 안함
    - 일반 메서드 주입
        - 한번에 여러 필드를 주입 받을 수 있다
        - 잘 사용하지 않는다.
- 옵션 처리
    - 주입 할 스프링 빈이 없어도 동작해야하는경우, required 옵션이 기본 값이 true로 되어있어 자동 주입할 대상이 없으면 오류 발생,예외처리 방법
        - Autowired(required = false)
            - 호출 자체가 되지 않는다.
        - 파라미터에 @Nullable 설정
            - null이 설정 되어 반환
        - Optional<Member>, (java8 이상)
            - Optional.empty 반환
- 생성자 주입을 선택해야하는 이유
    - 불변
        - 대부분의 의존관계 주입은 한 번 일어나면 애플리케이션 종료시점까지 변경 할 일이 없다.아니 변해선 안된다
        - 수정자 주입시 setXxx를 public으로 열어둬야함 (누군가의 변경 할 수 있음), 변경하면 안되는 메서드를 열어두는건 좋은 설계 방법이 아님,,
        - final 선언을 가능,, 생성자에서만 값을 설정 할 수 있다.
    - 누락
        - 프레임 워크 없이 순수한 자바 코드 단위 테스트를 하는 경우(진짜 많음) 수정자 주입으로 설정하면 의존관계가 한눈에 보이지 않고, 코드를 들어가봐야 알 수 있음,, 생성자 주입의 경우, 한 눈에 알아 볼 수 있음(컴파일 오류가 나기 때문에)
        - final 선언을 통해 누락된 정보를 컴파일 오류단에서 잡아 줄 수 있다. 
    - 정리
        - 컴파일 오류는 세상에서 가장 빠르고 좋은 오류다
        - 생성자 주입 방식은 프레임워크에 의존적이지않고, 순수한 자바 언어의 특징을 잘 살리는 방법
        - 기본으로 생성자 주입을 사용, 필수값이 아닌경우에는 수정자 주입방식을 옵션으로 부여하자. 동시에 사용 가능. 
- 롬복과 최신 트렌드
    - 개발을 해보면 99% 불변이다, 그래서 생성자에 final 키워드를 사용해야함,
        - 해당 클래스단에 @RequiredArgsConstructor 을 사용하면 final 필드에 대한 생성자를 생성해줌
    - 최신 트렌드 : Autowired 생략 후, 생성자 하나만 만들고, RequiredArgsConstrouctor을 사용해서 좋은 기능은 다 추가하고 생략해버림

- 조회 빈이 2개이상의 문제
    - Autowired는 스프링 빈을 타입으로 조회한다. >> 동일한 타입 2개의 구현체를 @Component 설정을 해주면 빈이 충돌함(NoUniqueBeanDefinitionException)
        - 하위타입으로 지정하면 DIP를 위배하고, 유연성이 떨어짐.
        - 스프링 빈을 수동으로 등록해서 해결 가능하지만, 의존관계 자동 주입으로도 해결 가능
    - 조회 대상 빈이 2개 이상일 때 해결 방법 
        -  @Autowired 필드 명 매칭
            - 처음에는 타입으로 확인하고, 해당 타입의 빈이 여러개 있으면 필드 이름이나 파라미터 이름으로 빈 이름을 추가 매핑한다.
                - 따라서 필드 명 혹은 파라미터 이름을 빈 이름으로 변경시켜서 해결.
                    - ex) DiscountPolicy타입의 구현체 RateDiscountPolicy와 FixDiscountPolicy인 경우  생성자의 파라미터나 필드의 이름!을 변경  OrderServiceImpl(DisocuntPolicy disocuntpolicy) > OrderServiceImpl(DiscountPolicy rateDiscountPolicy)
        - @Qualifier (추가 구분자를 붙여주는 방법)
            - 주입 시 추가적인 방법을 제공하는 것이지, 빈 이름을 변경하는것은 아님
            - 생성자와 Component단에 @Qualifier(“구분자”)를 두고서 선택을 하게 함
            - 이것도 못찾으면 해당하는 구분자에 해당하는 이름으로 찾음,, Qualifier은 Qualifier을 찾는 용도로만 사용하는게 명확하고 좋다.
            - 이것도 못찾으면 NoSuchBeanDefinitionException
            - 애노테이션 직접 만들기
                - @Qualify(“구분자”) 처럼 하는 경우에는 컴파일 시 오류체크가 안됨, 따라서 어노테이션을 생성해서 그 어노테이션을 적용시키는 방법을 사용한다.
                - cmd + O 통해서 Qualifier 검색해서 해당 애노테이션 다 긁어서 붙여줌.
                - 직접 애노테이션을 붙여주고, 생성자 파라미터에도 붙여준다
        - @Primary 사용 : 우선순위를 지정하는 법
            - @Primary가 붙어있는 빈이 우선권을 가진다.
            - 지저분하게 다른걸 안붙여도 되고, 단순하게 @Primary만 붙이면 되기 때문, 
            - 보조를 사용하는 경우 메인에는 Primary 보조에만 Qualifier만 잡고 사용 (상세하게 사용하기 위해, 디테일한게 더 우선권을 가지기 때문)

- 조회한 빈이 모두 필요 할 때 List, Map
    - 의도적으로 해당 타입의 스프링 빈이 다 필요한 경우도 있다. (할인 정책시 정률 할인과 고정 할인 둘 다 뿌려주고 선택하게끔 하는)
    - Map은 키에 스프링 빈의 이름을 넣어주고, 그 값으로 해당 타입의 스프링 빈을 넣어준다. (스프링이 자동으로 할당해주는 것)
    - List는 타입으로 조회한 모든 스프링 빈을 넣어준다.

- 자동, 수동의 올바른 실무 운영 기준
    - 편리한 자동 기능을 기본으로 사용한다.
        - 시간이 갈 수록 점점 자동을 선호하는 추세이다.
        - 설정 정보를 기반으로 애플리케이션 구성 부분과 실제 동작 부분을 명확하게 나누는건 이상적이지만, 현실적으로는 상당히 번거로움,
        - 결정적으로 자동 빈등록을 사용해도 OCP,DIP를 지킬 수 있다.
    - 수동 빈 등록은 언제 사용하면 좋은가?
        - 애플리케이션은 업무(비즈니스) 로직과 기술 지원 로직으로 나눌 수 있음
            - 업무 로직 빈 : 웹을 지원하는 컨트롤러, 핵심 비즈니스 로직이 있는 서비스, 데이터 계층 로직의 레포지토리 등,, 보통 비즈니스 요구사항 개발시 추가되거나 변경 됨
                - 숫자가 굉장히 많고, 한 번 개발하면 어느정도 유사한 패턴이 있기 때문에 자동 기능을 적극 사용하는것이 좋음.. >> 문제가 발생해도 명확하게 파악하기 쉬움 (업무 로직은 분담이 되어있기 때문에) 
            - 기술 지원 빈 : 기술적인 문제나 공통 관심사(AOP) 처리 시 주로 사용,, DB 연결이나 공통 로그처리 등,, 
                - 업무 로직에 비해 그 수가 매우 적고, 어플리케이션 전반에 걸쳐 광범위하게 영향을 미친다… > 에러 찾기 어려움,,
                - 가급적 수동 빈 등록 (설정 정보에 바로 나타나게)을 사용해서 명확하게 들어내는것이 (유지보수하기에) 좋다!
                - 스프링 부트가 자동으로 등록하는 수 많은 빈들은 예외! (데이터베이스 연결에 사용하는 DataSource같은..)
                    - 이런 부분은 메뉴얼을 잘 참고해서 스프링 부트가 의도한 대로 편리하게 사용하면 된다
            - 비즈니스 로직 중 다형성을 적극 활용 할 때,,  (유지보수가 힘듬)
                - 조회한 빈이 모두 필요 할 때 List,Map을 보면,, 어떤 빈들이 주입될지, 빈의 이름은 무엇인지 알 수 없음,, 따라서 유지보수가 매우 힘듬
                - 이럴 경우 따로 Config파일을 만들어 수동으로 빈을 등록한다,, 자동으로 할 경우 특정 패키지에 같이 묶어주는것이 좋다


빈 생명주기 콜백 : 빈이 생성될 때 메서드를 호출해주고, 죽기전에 메서드를 호출해주는 ,, 

- 스프링 빈의 이벤트 라이프 사이클
    - 스프링 컨테이너 생성 > 스프링 빈 생성 > 의존관계 주입(setter,field 인젝션) > 초기화 콜백 > 사용 > 소멸 전 콜백 > 스프링 종료 
- DB 커넥션은 서버를 올릴 때 미리 DB와 서버를 연결을 해놓고 커넥션 풀을 여러개를 잡고, 네트워크 소켓처럼 애플리케이션 시작 시점에 미리 연결을 하는 경우와 연결을 모두 종료하는 작업을 진행하려면 객체의 초기화와 종료 작업이 필요하다.
- 스프링 빈은 객체 생성 > 의존관계 주입 의 라이프 사이클을 가짐(생성자 주입은 예외,, )
    - 따라서 초기화 작업은 의존관계 주입이 모두 완료된 이후 호출해야함,, 개발자가 의존관계 주입이 모두 완료된 시점을 알 수 있는 방법은??
- 스프링은 의존관계 주입이 완료되면 스프링 빈에게 콜백 메서드를 통해 초기화, 종료 시점을 알려주는 다양한 기능 제공
    - 인터페이스(InitializingBean, DisposableBean)
        - InitializingBean
            - 해당 인터페이스 받고 구현 메서드에서 초기화 할 행위(메서드) 실행시킴
        - DisposableBean
            - 해당 인터페이스 받고 구현 메서드에서 종료 직전 해야 할 행위(메서드) 실행시킴
        - 초기화, 소멸 인터페이스 단점
            - 스프링 전용 인터페이스로 해당 코드가 스프링에 의존함
            - 초기화, 소멸 메서드의 이름 변경 불가
            - 내가 코드를 고칠 수 없는 외부 라이브러리에 적용 할 수 없다.
        - 스프링 초창기(2003년;;)에 나온 방법으로, 지금은 거어의 사용 안함
    - 설정 정보에 초기화 메서드, 종료 메서드 지정
        - 메서드 명을 설정 후 빈 등록시에 해당 메서드를 속성으로 추가한다.
        - @Bean(initMethod =“init”, destroyMethod = “destroy”)
        - 장점
            - 스프링 빈이 스프링 코드에 의존하지 않는다.
            - 메서드 명 자유롭게 부여 가능
            - 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용 할 수 있다.
        - @Bean의 destroyMethod 속성에는 아주 특별한 기능이 있음
            - 기본값이 (inffered) 추론.. 라고 써있음
            - 이 추론 기능은 close, shutdown 이라는 이름의 메서드를 자동으로 호출해준다(말 그대로 종료 메서드를 추론해서 호출함)
            - 추론 기능을 사용하기 싫으면 destroyMethod=“” 이런식으로 공백으로 설정하면 추론기능 동작 안함
    - @PostConstruct, @PreDestroy 애노테이션 지원
        - 최신 스프링에서 가장 권장하는 방법
        - javax로 시작하면 자바에서 공식 지원하는 어노테이션이다. (스프링이 아니더라도 적용이 됨)
        - 초기화 하고자 하는 메서드에 @PostConstruct 애노테이션 추가
        - 종료 직전 실행시키고자 하는 메서드에 @PreDestroy 애노테이션 추가
        - 유일한 단점은 외부 라이브러리에는 적용 불가,, 외부 라이브러리에 적용시 @Bean 사용! 

- 객체의 생성과 초기화를 분리하자
    - 생성자는 필수 파라미터를 받고, 메모리를 할당해 객체를 생성하는 책임을 가진다.
    - 반면 초기화는 이렇게 생성된 값들을 활용해 외부 커넥션을 연결하는 등 무거운 동작을 수행한다.
    - 따라서 생성자 안에서 무거운 초기화 작업을 함께 하는 것 보다는 , 객체 생성 부분과 초기화 하는 부분을 명확하게 나누는 것이 유지보수 관점에서 좋다.
    - 물론 초기화 작업이 내부 값들만 약간 변경하는 정도로 단순한 경우, 생성자에서 한 번에 다 처리하는게 더 나을 수 있다.

빈 스코프 : 스프링은 기본적으로 싱글톤 스코프(빈이 존재 할 수 있는 범위)로 생성되기 때문에 스프링 빈이 컨테이너의 시작과 함께 생성되며 스프링 컨테이너가 종료될 때까지 유지되는데, 다양한 스코프를 지원 한다.
- 싱글톤 : 기본 스코프로 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
- 프로토타입 : 스프링 컨테이너는 프로토타입 빈의 생성과 의존관계 주입까지만 관여 후 더는 관리하지 않는 매우 짧은 범위의 스코프이다.
- 웹 관련 스코프 
    - request : 웹 요청이 들어오고 나갈때 까지 유지되는 스코프이다.
    - session : 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프이다.
    - application : 웹의 서블릿 컨텍스트와 같은 범위로 유지되는 스코프이다.


