package lifecycle;

import net.bytebuddy.description.annotation.AnnotationDescription;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest(){
        //close 사용하려면 ApplciationContext 하위인 ConfigurableApplica~를 타입으로 가져야 함
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        ac.close();;
    }
    @Configuration
    static class LifeCycleConfig{

        @Bean//(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://pines.ml"); // 객체 생성 후 url을 지정시켜서 생성자 호출시 url 값이 null로 세팅
            return networkClient;
        }
    }
}
