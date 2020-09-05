package com.health.enroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.health.enroll.dto.EnrollmentDto;
import com.health.enroll.service.EnrollService;

import java.util.List;

@RestController
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    @GetMapping("/enrolls")
    public List<EnrollmentDto> getAllEnrolls() {
        return enrollService.getAllEnrollees();
    }

    @GetMapping("/enrolls/{enrollId}")
    public EnrollmentDto getBook(@PathVariable Integer enrollId) {
        return enrollService.getEnrollee(enrollId);
    }

    @PostMapping("/enrolls")
    public void addBook(@RequestBody EnrollmentDto enrollmentDto) {
    	enrollService.addEnrollee(enrollmentDto);
    }

    @PutMapping("/enrolls")
    public void updateEnroll(@RequestBody EnrollmentDto enrollmentDto) {
    	enrollService.updateEnrollee(enrollmentDto);
    }

    @DeleteMapping("/enrolls/{enrollId}")
    public void deleteEnroll(@PathVariable Integer enrollId) {
    	enrollService.deleteEnrollee(enrollId);
    }
}
