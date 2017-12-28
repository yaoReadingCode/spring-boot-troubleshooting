package com.example.bitbythecron.springboottroubleshooting

import com.codahale.metrics.Meter
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

@Slf4j
@RestController
@RequestMapping('/fizzbuzz')
@ApiVersion(1)
class FizzbuzzResource implements InjectionConstants {
    static Map<Integer,Fizzbuzz> fizzbuzzMap

    static {
        fizzbuzzMap = [:]

        fizzbuzzMap[12345] = new Fizzbuzz(true,12345,'Well hello!')
    }

    @Autowired
    FlimFlamProperties flimFlamProperties

    @Autowired
    @Qualifier(value = InjectionConstants.MetricNames.FIZZBUZZ_CALLS)
    Meter fizzbuzzCallsMeter

    @RequestMapping(method = RequestMethod.GET, path = '/{id}')
    Fizzbuzz getFizzbuzzById(@PathVariable('id') Integer id) {
        log.info("Hit the controller! And dataMode = ${flimFlamProperties.dataMode}")
        fizzbuzzCallsMeter.mark()

        fizzbuzzMap.get(id)
    }
}
