package com.alpcan.springbootproject.model;

import java.util.Date;

public class BankAccountInfo {
    private Long id;
    private String fromID;
    private String toID;
    private double balance;
    private Date date;

    public BankAccountInfo() {

    }


    public BankAccountInfo(String fromID, String toID, double balance, Date date) {

        this.fromID = fromID;
        this.toID = toID;
        this.balance = balance;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
//   31-12-2018 23:00:15



}