package org.tpero;

import com.intuit.karate.Runner;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
@SpringBootTest(classes = Main.class)
public class KarateTest {
    private final ApplicationContext applicationContext;

    @Test
    void test() {
        ApplicationContextHolder.setApplicationContext(this.applicationContext);

        // Since this one JUnit test runs all Karate tests,
        // fail the test if any underlying Karate tests fail
        assertEquals(0, Runner.path("classpath:org/tpero")
                .parallel(Optional.ofNullable(System.getProperty("karate.threads"))
                        .map(Integer::parseInt)
                        .orElse(5)
                ).getFailCount());
    }
}
