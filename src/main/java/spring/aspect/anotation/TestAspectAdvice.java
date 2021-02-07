package spring.aspect.anotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspectAdvice {

    // join point（连接点）, 需要增强（advice）的点（Spring中主要指执行方法）
    // point cut（切点）, 主要用来定义 join point（连接点）
    // Advice (增强）, 对执行方法进行增强
    // Aspect （切面）

/*
    @Before("execution(* spring.service.SpringRelatedService.formatDate(..))")
    public void beforeFormatDate() {
        System.out.println("Before format date!");
    }

    @After("execution(* spring.service.SpringRelatedService.formatDate(..))")
    public void afterFormatDate() {
        System.out.println("After format date!");
    }

    @Around("execution(* spring.service.SpringRelatedService.formatDate(..))")
    public void aroundFormatDate() {
        System.out.println("Around format date!");
    }
*/


    @Pointcut("@annotation(spring.aspect.anotation.TestAspect)")
    public void testAspectPointcut(){};

    @Around("testAspectPointcut()")
    public void testAround(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for(Object o : args){
            sb.append(o + "; ");
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + sb.toString());

        // 继续执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(methodName + "方法执行结束");
    }
}
