package com.example.bitbythecron.springboottroubleshooting

import com.codahale.metrics.ScheduledReporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

import java.util.concurrent.TimeUnit

class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    ScheduledReporter metricReporter

    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {
        metricReporter.start(1, TimeUnit.SECONDS)
    }
}
