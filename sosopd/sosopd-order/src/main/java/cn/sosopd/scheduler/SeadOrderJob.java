package cn.sosopd.scheduler;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SeadOrderJob {

    Logger log = LoggerFactory.getLogger(getClass());

    //@Scheduled(cron = "0/2 * * * * ? ")
    public void execute() {
        log.info("send order Job run,data" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }

}
