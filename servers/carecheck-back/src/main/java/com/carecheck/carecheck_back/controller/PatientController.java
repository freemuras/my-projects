package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.dto.request.ReqPatientRegDto;
import com.carecheck.carecheck_back.entity.Patient;
import com.carecheck.carecheck_back.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(summary = "환자등록추가", description = "환자등록")
    @PostMapping("")
    public ResponseEntity<?> registerPatient(@RequestBody ReqPatientRegDto reqPatientRegDto) {
        Patient patient = Patient.builder()
                .patientName(reqPatientRegDto.getPatientName())
                .regidentNum(reqPatientRegDto.getRegidentNum())
                .phoneNum(reqPatientRegDto.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(patientService.addPatient(patient));
    }

    @Operation(summary = "환자 번호 조회", description = "환자 번호 조회")
    @GetMapping("/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable("patientId") int patientId) {
        Optional<Patient> patient = patientService.getPatientId(patientId);

        if (patient.isPresent()) {
            return ResponseEntity.ok().body(patient.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 환자 ID가 존재하지 않습니다.");
        }
    }
}


// ========> PatientController <========
//url: /patients, method: post
