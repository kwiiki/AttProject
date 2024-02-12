package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Attendance_Record")
@AllArgsConstructor
@NoArgsConstructor
public class Attendance_Record {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToOne(mappedBy = "attendanceRecord", cascade = CascadeType.ALL)
    private Absence_Reason absenceReason;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @Enumerated(EnumType.STRING)
    private Attendance_status status;

    private LocalDateTime date;

    // other fields, constructors, getters, setters
}