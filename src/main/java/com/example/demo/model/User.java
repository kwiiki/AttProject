package com.example.demo.model;//package com.example.demo.model;
//
//import jakarta.persistence.*;
import com.example.demo.model.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "student")
    private List<Attendance_Record> attendanceRecords;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User_property userProperty;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Lesson_Students> lessonStudents;

    // other fields, constructors, getters, setters
}

