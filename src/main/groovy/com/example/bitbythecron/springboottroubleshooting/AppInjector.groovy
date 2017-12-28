package com.example.bitbythecron.springboottroubleshooting

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.Meter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.ScheduledReporter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.concurrent.TimeUnit

@Configuration
class AppInjector implements InjectionConstants {
    @Bean
    MetricRegistry metricRegistry() {
        new MetricRegistry()
    }

    @Bean
    @Qualifier(value = InjectionConstants.MetricNames.FIZZBUZZ_CALLS)
    Meter fizzbuzzCalls(MetricRegistry metricRegistry) {
        metricRegistry.meter(InjectionConstants.MetricNames.FIZZBUZZ_CALLS)
    }

    ScheduledReporter metricReporter(MetricRegistry metricRegistry) {
        ConsoleReporter.forRegistry(metricRegistry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build()
    }
}
