package com.example.demo.service;

import com.example.demo.model.Slot;

public interface DoctorService {
    Slot createSlot(int id, Slot slot) throws Exception;
}
