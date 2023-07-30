package com.example.demo.service;

import com.example.demo.model.Slot;

public interface DoctorService {
    Slot createSlot(int doctorId, Slot slot) throws Exception;

    String deleteSlotBySlotId(int doctorId, Slot slot, int slotId) throws Exception;

    Slot updateSlotBySlotId(int doctorId, Slot slot, int slotId) throws Exception;
}
