package lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    // 서비스 시작시 호출하는 메서드
    public void connect(){
        System.out.println("connect : "+url);
    }
    public void call(String message){
        System.out.println("call : "+url+" message = "+message);
    }

    //서비스 종료 시 호출
    public void discconect(){
        System.out.println("close : "+url);
    }

    @PostConstruct // 의존관계 주입 후 실행시키는 어노테이션
    public void init() { // 의존관계 주입이 끝나면 호출해준다.

        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy // 종료 직전 실행시키는 어노테이션
    public void close() {
        discconect();
    }
}
