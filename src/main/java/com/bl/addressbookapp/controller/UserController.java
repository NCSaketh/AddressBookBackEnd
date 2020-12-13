package com.bl.addressbookapp.controller;

import com.bl.addressbookapp.dto.AddressBookDto;
import com.bl.addressbookapp.dto.ResponseDto;
import com.bl.addressbookapp.exceptions.RecordNotFound;
import com.bl.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody AddressBookDto user){
        ResponseDto responseDto = new ResponseDto("Contact Created Successfully", addressBookService.CreateContact(user));
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody AddressBookDto user){
        ResponseDto responseDto = new ResponseDto("Contact Updated Successfully", addressBookService.UpdateContact(user));
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Long id){
        ResponseDto responseDto = new ResponseDto("Contact Deleted Successfully", addressBookService.deleteContact(id));
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllUser(){
        ResponseDto responseDto = new ResponseDto("Displaying Records From DB", addressBookService.getAllContacts());
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
