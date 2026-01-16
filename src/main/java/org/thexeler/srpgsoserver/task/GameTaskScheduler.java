package org.thexeler.srpgsoserver.task;

import org.thexeler.srpgsoserver.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thexeler.srpgsoserver.SrpgsoServerApplication;

@Component
public class GameTaskScheduler {
    @Autowired
    @Qualifier("applicationTaskExecutor")
    private TaskExecutor taskExecutor;

    @Autowired
    private UserRepository userRepository;

    @Getter
    private static boolean isNextDayCalculating = false;

    @Scheduled(cron = "0 0 4 * * ?")
    public void nextDayCalculate() {
        SrpgsoServerApplication.logger.info("Next day calculating...");

        isNextDayCalculating = true;

        userRepository.findAll().forEach(user -> taskExecutor.execute(() -> {
            SrpgsoServerApplication.logger.info("Checking user {}...", user.getUsername());

            SrpgsoServerApplication.logger.info("User {} saved.", user.getUsername());
        }));

        isNextDayCalculating = false;

        SrpgsoServerApplication.logger.info("Next day calculated.");
    }
}
