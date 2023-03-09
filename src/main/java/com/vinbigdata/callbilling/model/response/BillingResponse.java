package com.vinbigdata.callbilling.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class BillingResponse {

    @JsonProperty("call_count")
    private long callCount;

    @JsonProperty("block_count")
    private long blockCount;

}
