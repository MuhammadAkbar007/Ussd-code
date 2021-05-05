package uz.pdp.ussd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ussd.entity.ServiceCategory;
import uz.pdp.ussd.payload.ApiResponse;
import uz.pdp.ussd.payload.CategoryServiceDto;
import uz.pdp.ussd.service.CategoryServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/servicecategory")
public class ServiceCategoryController {

    @Autowired
    CategoryServiceService categoryServiceService;

    @GetMapping("/list")
    public HttpEntity<?> getList() {
        List<ServiceCategory> categoriesList = categoryServiceService.getCategoriesList();
        return ResponseEntity.status(201).body(categoriesList);
    }

    @GetMapping("/getById/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse serviceCategoryById = categoryServiceService.getCategoryById(id);
        return ResponseEntity.status(201).body(serviceCategoryById);
    }

    @PutMapping("/edit/{id}")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> editCategory(@PathVariable Integer id, @RequestBody CategoryServiceDto categoryServiceDto) {
        ApiResponse apiResponse = categoryServiceService.editCategory(categoryServiceDto, id);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PostMapping("/add")
    @Secured({"ROLE_MANAGER"})
    public HttpEntity<?> addCategory(@RequestBody CategoryServiceDto categoryServiceDto) {
        ApiResponse apiResponse = categoryServiceService.addCategory(categoryServiceDto);
        return ResponseEntity.status(201).body(apiResponse);
    }
}
