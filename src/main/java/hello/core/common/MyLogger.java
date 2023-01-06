package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 프록시 객체를 생성함(가짜 객체로 속이기)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("["+uuid+"]"+"["+requestURL+"] "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); // 자바에서 제공하는 UUID 라이브러리
        System.out.println("["+uuid+"] request scope bean create: "+this);
    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope bean close" +
                ": "+this);
    }
}
