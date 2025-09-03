package com.fees.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fees.demo.model.Studentdetailmodel;

public interface Studentdetailrepo extends JpaRepository<Studentdetailmodel,Long> {
	 List<Studentdetailmodel> findByStatus(String status);
}
