package hu.idomsoft.timeouttest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/timeout")
    public String timeout(@RequestParam("seconds") Integer secondsToSleep) {
        logger.info("Waiting for " + secondsToSleep + " seconds");
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "All good after " + secondsToSleep + " seconds";
    }
}
