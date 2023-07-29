package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    private String name;
    private String specialization;

    @OneToMany
    private List<Slot> availability;

}
