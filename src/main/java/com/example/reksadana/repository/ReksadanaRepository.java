package com.example.reksadana.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reksadana.model.Reksadana;
import java.util.List;
import java.util.Date;

public interface ReksadanaRepository extends JpaRepository<Reksadana, Long> {
    List<Reksadana> findAllByDate(Date date);
}

