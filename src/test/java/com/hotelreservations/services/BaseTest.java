package com.hotelreservations.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseTest {


    RequestSpecification spec;


    public BaseTest(){
    spec = new RequestSpecBuilder()
            .setBaseUri("https://restful-booker.herokuapp.com")
            .addFilters(Arrays.asList(new RequestLoggingFilter(), new RequestLoggingFilter()))
            .build();
    }

}
