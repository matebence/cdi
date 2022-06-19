package interceptor;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.annotation.Priority;

import javax.interceptor.InvocationContext;
import java.util.stream.Stream;
import java.io.Serializable;

/* it will be executed after PLATFORM_BEFORE and LIBRARY_BEFORE */

@Logged
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
public class LoggerInterceptor implements Serializable {

    @AroundInvoke
    private Object doMethodLogging(InvocationContext ic) throws Exception {
        System.out.println("Method name: " + ic.getMethod().getName());
        System.out.println("Parameters: ");
        Stream.of(ic.getParameters())
                .map(Object::toString)
                .forEach(System.out::println);
        return ic.proceed();
    }

    @AroundConstruct
    private Object doClassLogging(InvocationContext ic) throws Exception {
        long start = System.currentTimeMillis();
        Object rtn = ic.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Construction time: " + (end - start));
        return rtn;
    }
}
