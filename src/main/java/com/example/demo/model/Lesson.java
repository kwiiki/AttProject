package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Lesson")
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private User teacher;

    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    private Attendance_Record attendanceRecord;

    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Lesson_Students> lessonStudents;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    // other fields, constructors, getters, setters

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +

                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}