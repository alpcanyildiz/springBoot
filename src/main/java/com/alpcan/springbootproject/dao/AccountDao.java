package com.alpcan.springbootproject.dao;

import com.alpcan.springbootproject.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<BankAccount,Long> {

    //BankAccount findByFromIDAndDate

    List<BankAccount> findByDateGreaterThanAndFromID (Date date, String fromID);


}

