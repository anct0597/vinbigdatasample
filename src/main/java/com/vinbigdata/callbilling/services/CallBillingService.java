package com.vinbigdata.callbilling.services;

import com.vinbigdata.callbilling.model.mapper.CallLogMapper;
import com.vinbigdata.callbilling.model.request.CallLogRequest;
import com.vinbigdata.callbilling.model.response.AppErrorCode;
import com.vinbigdata.callbilling.model.response.BillingResponse;
import com.vinbigdata.callbilling.model.response.ErrorCodeException;
import com.vinbigdata.callbilling.repository.CallLogRepository;
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
    private final CallLogRepository callLogRepository;

    public void callLog(String username, CallLogRequest request) {
        var callLog = mapper.toEntity(username, request);
        callLogRepository.save(callLog);
    }

    public BillingResponse getBill(String username) {
        if (!callLogRepository.existsByUsername(username)) {
            throw new ErrorCodeException(AppErrorCode.NOT_FOUND_USERNAME);
        }

        var callLogs = callLogRepository.findAllByUsername(username);
        var blockCount = callLogs.parallelStream().reduce(0L,
                (total, callLog) -> total + callLog.getDuration() / 30 + (callLog.getDuration() % 30 > 0 ? 1 : 0),
                Long::sum);
        return new BillingResponse(callLogs.size(), blockCount);
    }
}
