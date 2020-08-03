package com.tts.weatherapp.service;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCode;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FiveDayService {
    @Value("${api_key}")
    private String apiKey;

    public Response getForecast(String zipCode) {

        ZipCode zip = new ZipCode(zipCode);

        // code to check if zip is already in database
        String url = "api.openweathermap.org/data/2.5/forecast?zip=" + zipCode + ",us&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        try {
            // System.out.println("Result of findByZip: " +
            // zipCodeRepository.findByZip(zipCode));
            return restTemplate.getForObject(url, Response.class);
        } catch (HttpClientErrorException | ConstraintViolationException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }

    }

}