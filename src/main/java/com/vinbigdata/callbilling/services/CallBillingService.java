package com.vinbigdata.callbilling.services;

import com.vinbigdata.callbilling.model.mapper.CallLogMapper;
import com.vinbigdata.callbilling.model.request.CallLogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Service
@RequiredArgsConstructor
public class CallBillingService {

    private final CallLogMapper mapper;

    public void logCall(CallLogRequest request) {

    }
}
