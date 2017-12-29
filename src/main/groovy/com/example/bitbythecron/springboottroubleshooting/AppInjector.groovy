package com.example.bitbythecron.springboottroubleshooting

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.Meter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.ScheduledReporter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

import java.util.concurrent.TimeUnit

@EnableWebMvc
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

    @Bean
    ApiVersionRequestMappingHandlerMapping getApiMapping() {
        new ApiVersionRequestMappingHandlerMapping('v')
    }

    @Bean
    DelegatingWebMvcConfiguration delegatingWebMvcConfiguration() {
        new DelegatingWebMvcConfiguration() {
            @Override
            RequestMappingHandlerMapping requestMappingHandlerMapping() {
                getApiMapping()
            }

        }
    }
}
