package com.vinbigdata.callbilling.model.mapper;

import com.vinbigdata.callbilling.model.entity.CallLog;
import com.vinbigdata.callbilling.model.request.CallLogRequest;
import org.mapstruct.Mapper;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Mapper
public interface CallLogMapper {

    CallLog toEntity(CallLogRequest request);
}
