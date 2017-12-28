package com.example.bitbythecron.springboottroubleshooting

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
class DataModeFilter implements Filter {
    @Autowired
    FlimFlamProperties flimFlamProperties

    @Override
    void init(FilterConfig filterConfig) throws ServletException {
        log.trace("Initializing the ${this.class.name} filter...")
    }

    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(flimFlamProperties.dataMode == DataMode.Mock) {
            HttpServletResponse httpServletResponse = response as HttpServletResponse
            httpServletResponse.writer.write('{"woo" : "hoo"}')
        } else {
            chain.doFilter(request, response)
        }
    }

    @Override
    void destroy() {
        log.trace("Destroying the ${this.class.name} filter...")
    }
}
