package com.example.bitbythecron.springboottroubleshooting

import com.codahale.metrics.ScheduledReporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

import java.util.concurrent.TimeUnit
import groovy.util.logging.Slf4j

@Slf4j
class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    ScheduledReporter metricReporter

    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {
        log.info('StartupListener is starting...')
        metricReporter.start(1, TimeUnit.SECONDS)
    }
}
