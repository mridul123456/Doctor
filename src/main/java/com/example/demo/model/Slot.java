package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Builder
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int slotId;

    private String day;
    private String startTime;
    private String endTime;
    private Boolean isBooked;


}
