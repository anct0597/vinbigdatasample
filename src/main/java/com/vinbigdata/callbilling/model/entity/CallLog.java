package com.vinbigdata.callbilling.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Getter
@Setter
public class CallLog extends AbstractAuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private long duration;
}
