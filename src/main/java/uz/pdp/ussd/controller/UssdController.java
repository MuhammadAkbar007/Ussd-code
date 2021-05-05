package uz.pdp.ussd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ussd.entity.UssdCode;
import uz.pdp.ussd.payload.ApiResponse;
import uz.pdp.ussd.service.UssdCodeService;

@RestController
@RequestMapping("/api/auth/ussd")
public class UssdController {

    @Autowired
    UssdCodeService service;

    @PostMapping
    public HttpEntity<?> add(@RequestBody UssdCode ussdCode) {
        ApiResponse apiResponse = service.add(ussdCode);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editByEmployeeToChangeTaskStatus
            (@RequestBody UssdCode ussdCode, @PathVariable Integer id) {
        ApiResponse apiResponse = service.edit(id, ussdCode);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Integer id) {
        ApiResponse response = service.getOne(id);
        return ResponseEntity.status(response.isSuccess() ? 202 : 409).body(response);
    }
}
