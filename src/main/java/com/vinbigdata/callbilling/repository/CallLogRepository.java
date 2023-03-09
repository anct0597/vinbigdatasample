package com.vinbigdata.callbilling.repository;

import com.vinbigdata.callbilling.model.entity.CallLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Repository
public interface CallLogRepository extends JpaRepository<CallLog, Long> {
    List<CallLog> findAllByUsername(String username);

    boolean existsByUsername(String username);
}
