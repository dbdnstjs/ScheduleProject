package com.schedule.Lv2.dto;

//요청하는 데이터 클라 -> 서버

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본생성자 생성
public class ScheduleRequestDto {
    private String title;
    private String content;
}
