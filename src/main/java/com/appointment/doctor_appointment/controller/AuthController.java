package com.appointment.doctor_appointment.controller;

import com.appointment.doctor_appointment.dto.ReqRest;
import com.appointment.doctor_appointment.service.OurUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final OurUserService ourUserService;
    @Autowired
    public AuthController(OurUserService ourUserService) {
        this.ourUserService = ourUserService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<ReqRest> regeister(@RequestBody ReqRest reg) {
        return ResponseEntity.ok(ourUserService.RegisterUser(reg));
    }

    @PostMapping("auth/login")
    public ResponseEntity<ReqRest> login(@RequestBody ReqRest login) {
        return ResponseEntity.ok(ourUserService.LoginUser(login));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRest> refreshToken(@RequestBody ReqRest req) {
        return ResponseEntity.ok(ourUserService.refreshToken(req));
    }


}
