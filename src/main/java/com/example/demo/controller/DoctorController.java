package com.example.demo.controller;

import com.example.demo.model.Slot;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/{doctorId}/slots")
    public Slot addSlot(@PathVariable("doctorId") int doctorId, @RequestBody Slot slot) throws Exception {
        return doctorService.createSlot(doctorId, slot);
    }

    @DeleteMapping("/{doctorId}/slots/{slotId}")
    public String deleteSlot(@PathVariable int doctorId, @RequestBody Slot slot, @PathVariable int slotId) throws Exception {
        return doctorService.deleteSlotBySlotId(doctorId, slot, slotId);
    }

//    @PutMapping("/{doctorId}/slots/{slotId}")
//    public ResponseEntity<Slot> updateSlot(@PathVariable int doctorId, @RequestBody Slot slot, @PathVariable int slotId) throws Exception {
//       return new ResponseEntity<Slot>(doctorService.updateSlotBySlotId(doctorId, slot, slotId), HttpStatus.OK);
//    }

    @PutMapping("/{doctorId}/slots/{slotId}")
    public Slot updateSlot(@PathVariable int doctorId, @RequestBody Slot slot, @PathVariable int slotId) throws Exception {
       return doctorService.updateSlotBySlotId(doctorId, slot, slotId);
    }

}
