package com.example.reksadana.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.reksadana.repository.ReksadanaRepository;
import com.example.response.ReksadanaResponse;
import com.example.reksadana.model.Reksadana;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class ReksadanaController {
    @Autowired
    private ReksadanaRepository reksadanaRepository;

    @GetMapping("/reksadana")
    public List<Reksadana> getAllReksaDana() {
        return reksadanaRepository.findAll();
    }

    @PostMapping("/reksadana/create")
    public Reksadana addReksaDana(@RequestBody Reksadana reksaDana) {
        return reksadanaRepository.save(reksaDana);
    }

    @GetMapping("/reksadana/today")
    public ResponseEntity<ReksadanaResponse> getReksaDanaToday() {
        String message = "";
        try {
            Date today = new Date();
            List<Reksadana> reksadana =  reksadanaRepository.findAllByDate(today);
            message = "Get Reksadana Success";
            return ResponseEntity.status(HttpStatus.OK).body(new ReksadanaResponse(HttpStatus.OK.value(), message, reksadana));
        } catch (Exception e) {
            message = "Get Reksadana Failed : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReksadanaResponse(HttpStatus.BAD_REQUEST.value(), message, null));
        }
    }
}

