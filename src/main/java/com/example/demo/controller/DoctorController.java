package com.example.demo.controller;

import com.example.demo.model.Slot;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/{id}/slots")
    public Slot addSlot(@PathVariable("id") int id, @RequestBody Slot slot) throws Exception {
        return doctorService.createSlot(id, slot);
    }

}
