package com.schedule.Lv5.dto;

//요청하는 데이터 클라 -> 서버

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본생성자 생성
public class ScheduleRequestDto {
    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 10,message = "제목은 최대 10글자까지 가능합니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}
