package com.vinbigdata.callbilling.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallLogRequest {

    @JsonProperty("call_duration")
    private long callDuration;
}
