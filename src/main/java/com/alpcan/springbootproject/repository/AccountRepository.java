package com.alpcan.springbootproject.repository;

import com.alpcan.springbootproject.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<BankAccountEntity,Long> {


    List<BankAccountEntity> findByDateGreaterThanAndFromId (ZonedDateTime date, String fromId);


}
