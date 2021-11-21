package com.infinix.hackerbills.controllers;

import com.infinix.hackerbills.entities.BillEntity;
import com.infinix.hackerbills.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private BillService billService;

    @PostMapping(path = "/addBill", produces = "application/json", consumes = "application/json")
    private ResponseEntity<Object> addBill(@RequestBody BillEntity billRequest){
        if(billService.createNewBill(billRequest)){
            return new ResponseEntity<Object>("Bill Added Successfully", HttpStatus.CREATED);
        }

        return new ResponseEntity<Object>("Error Adding New Bill", HttpStatus.BAD_REQUEST);
    }
    @GetMapping(path = "/bills", produces = "application/json", consumes = "application/json")
    private ResponseEntity<List<BillEntity>> getAllBills(){
        List<BillEntity> allBills = billService.getAllBills();
        if(allBills!=null){
            return new ResponseEntity<List<BillEntity>>(allBills,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<List<BillEntity>>((List<BillEntity>) null,HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/bills/{id}", produces = "application/json", consumes = "application/json")
    private ResponseEntity<BillEntity> getBillsById(@PathVariable Integer id){
        Optional<BillEntity> bill = billService.getBill(id);
        if(bill.isPresent()){
            return new ResponseEntity<BillEntity>(bill.get(), HttpStatus.FOUND);
        } else{
            return new ResponseEntity<BillEntity>((BillEntity) null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(path = "/bills/due/{id}", produces = "application/json", consumes = "application/json")
    private ResponseEntity<List<BillEntity>> getBillsByDate(@PathVariable Date id){
        Optional<List<BillEntity>> bill = billService.getBillByDate(id);
        if(bill.isPresent()){
            return new ResponseEntity<List<BillEntity>>(bill.get(), HttpStatus.FOUND);
        } else{
            return new ResponseEntity<List<BillEntity>>((List<BillEntity>) null, HttpStatus.NOT_FOUND);
        }
    }
}
