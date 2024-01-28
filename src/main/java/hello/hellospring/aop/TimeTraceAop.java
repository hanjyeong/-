package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // aop 적용을 위해 필요한 어노테이션
@Component // 객체로 만들어 주기 위해 빈으로 설정하기 (springconfig)
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // aop를 적용할 곳을 타켓팅 해주는 역할
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        // 메소드의 실행시간을 측정하는 로직 만들기
        long start= System.currentTimeMillis();
        System.out.println("SATART: "+joinPoint.toString());
        try{
            // 다음 메소드로 진행
            return joinPoint.proceed();
        }finally {
            long finish= System.currentTimeMillis();
            long timeMs= finish-start;

            System.out.println("END: "+joinPoint.toString()+ " "+timeMs+"ms");
        }



    }
}
