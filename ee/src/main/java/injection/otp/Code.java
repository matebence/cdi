package injection.otp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Code {

    Type type();

    enum Type{
        EAN1, EAN2, EAN3
    }
}
