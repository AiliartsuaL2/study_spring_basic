package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); // 자기 자신을 내부에 private static으로 가짐,, class에 1개만 생성 가능

    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService() { //생성자를 private로 만들어서 호출 못하게 지정
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
