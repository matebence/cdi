package scope.stereo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Named;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Named
@Documented
@Stereotype
@Transactional
@ApplicationScoped
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Action {}
