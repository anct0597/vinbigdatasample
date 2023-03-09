package com.vinbigdata.callbilling.model.mapper;

import com.vinbigdata.callbilling.model.entity.CallLog;
import com.vinbigdata.callbilling.model.request.CallLogRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Mapper
public interface CallLogMapper {
    @Mapping(source = "request.callDuration", target = "duration")
    CallLog toEntity(String username, CallLogRequest request);
}
