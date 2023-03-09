package com.vinbigdata.callbilling.controllers;

import com.vinbigdata.callbilling.model.request.CallLogRequest;
import com.vinbigdata.callbilling.services.CallBillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@RestController
@RequestMapping("/mobile")
@RequiredArgsConstructor
public class MobileCallBillingController {

    private final CallBillingService service;

    @ResponseStatus(HttpStatus.OK)
    public String logCall(CallLogRequest request) {
        return "";
    }
}
