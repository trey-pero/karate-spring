package org.tpero;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.context.ApplicationContext;

/**
 * Provides Karate static access to the Spring application context.
 */
@UtilityClass
public class ApplicationContextHolder {
    @Setter
    @Getter
    private ApplicationContext applicationContext;
}
