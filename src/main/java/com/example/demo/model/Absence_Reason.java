package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Absence_Reason")
@AllArgsConstructor
@NoArgsConstructor
public class Absence_Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "record_id")
    private Attendance_Record attendanceRecord;

    private String description;

    private String status;

    // other fields, constructors, getters, setters
}