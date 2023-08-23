package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {
    ReservationService reservationService;
    String authkey;
    BookingResponse bookingResponse;

    @Given("Kullanici yeni bir rezervasyon oluşturuyor")
    public void cagriBaslangici(){
        reservationService = new ReservationService();
    }


    @Given("Kullanici rezervasyon için gereken bilgileri veriyor")
    public void createAuth(){
        authkey = reservationService.generateToken();
    }

    @When("Kullanici otel rezervasyonu yaratiyor")
    public void createReservation(){
        bookingResponse = reservationService.createBooking();

    }

    @Then("Rezervasyon basarili bir sekilde olusturuldu")
    public void reservationAssertions(){
        Assertions.assertEquals("Ayhan",bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Kömesöğütlü",bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(1000,bookingResponse.getBooking().getTotalprice());
        Assertions.assertFalse(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("Kopek yatagi",bookingResponse.getBooking().getAdditionalneeds());
    }

    @And("Kullanici olusturulan rezervasyonu iptal ediyor")
    public void cancelReservation(){
        reservationService.deleteReservation(authkey,bookingResponse.getBookingid());
    }

}
