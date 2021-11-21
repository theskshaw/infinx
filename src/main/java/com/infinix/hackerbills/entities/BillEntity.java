package com.infinix.hackerbills.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "Bill")
public class BillEntity {
    @Id
    @GeneratedValue
    private Integer billNo;
    private String billedTo;
    private Date billDate;
    private BigDecimal billAmount;
    private BigDecimal tax;
    private BigDecimal totalAmount;
}
