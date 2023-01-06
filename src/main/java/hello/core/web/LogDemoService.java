package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger; // 프록시 객체로 받기
    //private final ObjectProvider<MyLogger> myLoggerObjectProvider; // 프로바이더 처리

    public void logic(String id) {
        //MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = "+ id);
    }
}
