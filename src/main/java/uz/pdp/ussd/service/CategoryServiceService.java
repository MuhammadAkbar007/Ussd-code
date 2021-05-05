package uz.pdp.ussd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ussd.entity.ServiceCategory;
import uz.pdp.ussd.payload.ApiResponse;
import uz.pdp.ussd.payload.CategoryServiceDto;
import uz.pdp.ussd.repository.ServiceCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceService {

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    public List<ServiceCategory> getCategoriesList() {
        return serviceCategoryRepository.findAll();
    }

    public ApiResponse getCategoryById(Integer id) {
        Optional<ServiceCategory> optional = serviceCategoryRepository.findById(id);
        return optional.map(serviceCategory -> new ApiResponse("Found !", true, serviceCategory)).orElseGet(() -> new ApiResponse("Category not found by this id !", false));
    }

    public ApiResponse addCategory(CategoryServiceDto serviceDto) {
        if (serviceCategoryRepository.existsByName(serviceDto.getName()))
            return new ApiResponse("ServiceCategory by this name already exists", false);
        ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setName(serviceDto.getName());
        ServiceCategory saved = serviceCategoryRepository.save(serviceCategory);
        return new ApiResponse("Saved", true, saved);
    }

    public ApiResponse editCategory(CategoryServiceDto serviceDto, Integer id) {
        Optional<ServiceCategory> optional = serviceCategoryRepository.findById(id);
        if (!optional.isPresent()) return new ApiResponse("ServiceCategory not found !", false);
        ServiceCategory serviceCategory = optional.get();
        serviceCategory.setName(serviceDto.getName());
        ServiceCategory saved = serviceCategoryRepository.save(serviceCategory);
        return new ApiResponse("Edited", true, saved);
    }
}
