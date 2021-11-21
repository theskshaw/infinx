package com.infinix.hackerbills.repos;

import com.infinix.hackerbills.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<BillEntity, Integer> {
    Optional<List<BillEntity>> findByBillDate(Date billDate);
}
