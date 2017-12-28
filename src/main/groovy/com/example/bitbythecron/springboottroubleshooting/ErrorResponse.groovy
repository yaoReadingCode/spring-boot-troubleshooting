package com.example.bitbythecron.springboottroubleshooting

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@Canonical
@TupleConstructor(includeFields = true, includeSuperProperties = true)
class ErrorResponse {
    String receipt
    String details
}
