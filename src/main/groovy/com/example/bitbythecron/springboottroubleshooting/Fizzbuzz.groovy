package com.example.bitbythecron.springboottroubleshooting

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@Canonical
@TupleConstructor(includeFields = true, includeSuperFields = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class Fizzbuzz {
    @JsonProperty('foo')
    Boolean foo

    @JsonProperty('bar')
    Integer bar

    @JsonProperty('whistlefeather')
    String whistlefeather
}
