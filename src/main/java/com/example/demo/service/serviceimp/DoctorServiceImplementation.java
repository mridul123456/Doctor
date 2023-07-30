package com.example.demo.service.serviceimp;

import com.example.demo.model.Doctor;
import com.example.demo.model.Slot;
import com.example.demo.repository.DoctorRepo;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
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

    @Override
    public String deleteSlotBySlotId(int doctorId, Slot slot, int slotId) throws Exception {

        Doctor doctor = doctorRepo.findById(doctorId).get();

        if(doctor == null) throw new Exception("Invalid Doctor Id");

        List<Slot> availableSlots = doctor.getAvailability();

        Iterator<Slot> it = availableSlots.iterator();
        int flag = 0;

        while(it.hasNext()) {
            Slot s = it.next();
            if(s.getSlotId() == slotId) {
                flag = 1;
                it.remove();
                break;
            }
        }

        if(flag == 0) {
            return "No slots found with slotId : " + slotId ;
        }

        doctorRepo.save(doctor);

        return "Slot deleted successfully";
    }

    @Override
    public Slot updateSlotBySlotId(int doctorId, Slot slot, int slotId) throws Exception {
        Doctor doctor = doctorRepo.findById(doctorId).get();

        if(doctor == null) throw new Exception("DoctorId is not valid");

        List<Slot> availableSlots = doctor.getAvailability();
        Iterator<Slot> it = availableSlots.iterator();

        while(it.hasNext()) {
            Slot s = it.next();
            if(s.getSlotId() == slotId) {
                s.setIsBooked(slot.getIsBooked());
                s.setDay(slot.getDay());
                s.setEndTime(slot.getEndTime());
                s.setStartTime(slot.getStartTime());
                return s;
            }
        }

        throw new Exception("Slot not found");

    }


}
