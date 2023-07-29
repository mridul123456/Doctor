package com.example.demo.controller;

import com.example.demo.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/{id}/book")
    public String bookSlot(@PathVariable int id) throws Exception {
       return slotService.bookSLot(id);
    }


}
