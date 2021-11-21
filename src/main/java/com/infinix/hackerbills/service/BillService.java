package com.infinix.hackerbills.service;

import com.infinix.hackerbills.entities.BillEntity;
import com.infinix.hackerbills.repos.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;
    public boolean createNewBill(BillEntity bill){
        try{
            billRepo.save(bill);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<BillEntity> getAllBills(){
        try{
            return billRepo.findAll();
        } catch (Exception e){
            return null;
        }
    }

    public Optional<BillEntity> getBill(Integer id){
        if(id==null){
            return null;
        } else{
            return billRepo.findById(id);
        }
    }

    public Optional<List<BillEntity>> getBillByDate(Date id) {
        Optional<List<BillEntity>> bills = billRepo.findByBillDate(id);
        return bills;
    }
}
