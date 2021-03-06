package uz.pdp.ussd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ussd.entity.EntertainingService;
import uz.pdp.ussd.payload.ApiResponse;
import uz.pdp.ussd.payload.ServiceDto;
import uz.pdp.ussd.payload.SimcardEntertainingDto;
import uz.pdp.ussd.service.ServiceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entertainingService")
public class EntertainingServiceController {

    @Autowired
    ServiceService service;

    @GetMapping("/list")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> getEntertainingList() {
        List<EntertainingService> list = service.getServiceList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/list/{id}")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> getById(@PathVariable UUID id) {
        ApiResponse serviceById = service.getServiceById(id);
        return ResponseEntity.status(201).body(serviceById);
    }

    @PostMapping("/add")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> addEntertaining(@RequestBody ServiceDto serviceDto) {
        ApiResponse entertainingService = service.addEntertainingService(serviceDto);
        return ResponseEntity.status(201).body(entertainingService);
    }

    @PutMapping("/edit/{id}")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> editEntertaining(@PathVariable UUID id, @RequestBody ServiceDto serviceDto) {
        ApiResponse apiResponse = service.editEntertainingService(id, serviceDto);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @Secured({"ROLE_MANAGER"})
    @GetMapping("/famous")
    public HttpEntity<?> getFamousEntertainingList() {
        List<EntertainingService> serviceList = service.getServiceList();
        return ResponseEntity.ok(serviceList);
    }

    @PostMapping("/addEntertaining")
    public HttpEntity<?> addEntertainingforClient(@RequestBody SimcardEntertainingDto simcardEntertainingDto) {
        ApiResponse apiResponse = service.addEntertainingServiceForClient(simcardEntertainingDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete")
    public HttpEntity<?> deleteEntertainingforClient(@RequestBody SimcardEntertainingDto simcardEntertainingDto) {
        ApiResponse apiResponse = service.addEntertainingServiceForClient(simcardEntertainingDto);
        return ResponseEntity.ok(apiResponse);
    }
}
