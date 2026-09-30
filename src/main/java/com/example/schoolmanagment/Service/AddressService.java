package com.example.schoolmanagment.Service;

import com.example.schoolmanagment.ApiResponse.ApiException;
import com.example.schoolmanagment.DTO.AddressDTO;
import com.example.schoolmanagment.Model.Address;
import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Repository.AddressRepository;
import com.example.schoolmanagment.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> get() {
        List<Address> addresses = addressRepository.findAll();

        if (addresses.isEmpty()) {
            throw new ApiException("There is no addresses");
        }

        return addresses;
    }

    public void add(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public void update(AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());

        if (oldAddress == null) {
            throw new ApiException("Address not found");
        }

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(oldAddress);
    }

    public void delete(Integer id) {
        Address address = addressRepository.findAddressById(id);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        addressRepository.delete(address);
    }
}