package com.schedule.Lv1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//db에 들어갈 내용
@Getter
@Entity
@RequiredArgsConstructor
public class Schedule extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 설정 및 DB가 자동으로 1씩 증가
    private Long id;

    private String title;
    private String content;
    private String name;
    private String password;

    public Schedule(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }
    public void updateSchedule(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
