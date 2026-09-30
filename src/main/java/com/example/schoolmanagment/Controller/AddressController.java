package com.example.schoolmanagment.Controller;

import com.example.schoolmanagment.ApiResponse.ApiResponse;
import com.example.schoolmanagment.DTO.AddressDTO;
import com.example.schoolmanagment.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(addressService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid AddressDTO addressDTO){
        addressService.add(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid AddressDTO addressDTO){
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        addressService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}