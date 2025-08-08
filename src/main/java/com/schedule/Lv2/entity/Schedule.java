package com.schedule.Lv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//db에 들어갈 내용
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "schedule")
public class Schedule extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 설정 및 DB가 자동으로 1씩 증가
    private Long id;

    private String title;
    private String content;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public void updateSchedule(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
