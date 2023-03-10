package com.vinbigdata.callbilling.controllers;

import com.vinbigdata.callbilling.model.request.CallLogRequest;
import com.vinbigdata.callbilling.model.response.BillingResponse;
import com.vinbigdata.callbilling.services.CallBillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/{user_name}/call")
    @ResponseStatus(HttpStatus.OK)
    public void logCall(@PathVariable("user_name") String username,
                        @RequestBody CallLogRequest request) {
        service.callLog(username, request);
    }

    @GetMapping("/{user_name}/billing")
    public BillingResponse getBill(@PathVariable("user_name") String username) {
        return service.getBill(username);
    }
}
