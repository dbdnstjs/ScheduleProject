package com.schedule.Lv2.entity;

//시간 세팅

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //JPA기능 활성화
public class Base {
    @CreatedDate // 처음 저장되면 자동으로 현재 시간을 저장
    @Column(updatable = false) // 저장후 수정 불가능
    @Temporal(TemporalType.TIMESTAMP) // 날자 시간 형태로 저장
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정되면 자동으로 현재 시간 저장
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
