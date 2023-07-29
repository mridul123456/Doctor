package com.example.demo.service.serviceimp;

import com.example.demo.model.Doctor;
import com.example.demo.model.Slot;
import com.example.demo.repository.DoctorRepo;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImplementation implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;


    @Override
    public Slot createSlot(int doctorId, Slot slot) throws Exception {
        Optional<Doctor> doctor = doctorRepo.findById(doctorId);
        if(!doctor.isPresent()) throw new Exception("Doctor with doctorID : " + doctorId + " is not present");

        doctor.get().getAvailability().add(slot);
        return slot;
    }


}
