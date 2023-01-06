package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    //private final ObjectProvider<MyLogger> myLoggerProvider; // 프로바이더로 받고
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody // 뷰없이 json 반환
    public String logDemo(HttpServletRequest request) throws InterruptedException {// request : 자바 규약에 의한 요청정보를 받음
        //MyLogger myLogger = myLoggerProvider.getObject(); // 요청이 있는 순간 호출을 해줌.,
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass()); // 확인해보면 CGLIB에서 MyLogger을 상속받은 프록시 객체를 생성해서 임의로 넣어놓음
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        Thread.sleep(1000); // 요청 들어오고 1초 쉼
        logDemoService.logic("testId");
        return "OK";
    }


}
