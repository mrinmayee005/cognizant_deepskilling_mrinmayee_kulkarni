package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);
        testGetAttempt();
    }

    private static void testGetAttempt() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}", attempt.getUser().getName());
        LOGGER.debug("Attempted Date: {}", attempt.getDate());

        for (AttemptQuestion attemptQuestion : attempt.getAttemptQuestionList()) {
            LOGGER.debug("");
            LOGGER.debug("{}", attemptQuestion.getQuestion().getText());
            int optionNumber = 1;
            for (AttemptOption attemptOption : attemptQuestion.getAttemptOptionList()) {
                LOGGER.debug("{} ) {}    {}    {}",
                        optionNumber,
                        attemptOption.getOption().getText(),
                        attemptOption.getOption().getScore(),
                        attemptOption.isSelected());
                optionNumber++;
            }
        }
        LOGGER.info("End");
    }
}

