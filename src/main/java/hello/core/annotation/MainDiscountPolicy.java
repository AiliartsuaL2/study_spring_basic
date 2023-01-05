package hello.core.annotation;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
