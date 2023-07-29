package com.example.demo.service.serviceimp;

import com.example.demo.model.Slot;
import com.example.demo.repository.SlotRepo;
import com.example.demo.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SlotServiceImplementation implements SlotService {

    @Autowired
    private SlotRepo slotRepo;

    @Override
    public String bookSLot(int id) throws Exception {
        Optional<Slot> slot = slotRepo.findById(id);

        if(!slot.isPresent()) {
            throw new Exception("Slot not found");
        }

        if(!slot.get().getIsBooked()) {
            slot.get().setIsBooked(true);
            slotRepo.save(slot.get());
            return "Slot Booked Successfully";
        }

        return "Slot is already booked";

    }
}
