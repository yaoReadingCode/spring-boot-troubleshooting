package com.example.bitbythecron.springboottroubleshooting

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties('flimflam')
class FlimFlamProperties {
    DataMode dataMode
    String dataDir
}
