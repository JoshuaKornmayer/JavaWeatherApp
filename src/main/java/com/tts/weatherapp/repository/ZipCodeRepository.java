package com.tts.weatherapp.repository;

// import java.util.List;

import com.tts.weatherapp.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
    public ZipCode findByZip(String zipcode);
}