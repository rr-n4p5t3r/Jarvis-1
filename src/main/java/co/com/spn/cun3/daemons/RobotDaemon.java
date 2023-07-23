package co.com.spn.cun3.daemons;

import co.com.spn.cun3.controllers.TestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class RobotDaemon {

    private final TestController testController;

    public RobotDaemon(TestController testController) {
        this.testController = testController;
    }

    @Async
    @Scheduled(fixedDelay = 600000)
    public void checkEmail() throws Exception {
        testController.getEmailContents();
    }
}
