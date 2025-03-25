package org.javaguru.travel.insurance.core;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIEachFieldTest {
    private final TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    public void testCalculatePremium_personFirstName() {
        String firstName = "John";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(firstName, "Doe", "01/01/2024", "10/01/2024");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(firstName, response.getPersonFirstName());
    }

    @Test
    public void testCalculatePremium_personLastName() {
        String lastName = "Doe";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", lastName, "01/01/2024", "10/01/2024");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(lastName, response.getPersonLastName());
    }

    @Test
    public void testCalculatePremium_agreementDateFrom() {
        String dateFromStr = "01/01/2024";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Doe", dateFromStr, "10/01/2024");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(dateFromStr, response.getAgreementDateFrom());
    }

    @Test
    public void testCalculatePremium_agreementDateTo() {
        String dateToStr = "10/01/2024";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Doe", "01/01/2024", dateToStr);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(dateToStr, response.getAgreementDateTo());
    }
}
