package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TravelCalculatePremiumServiceImplAIOneTest {
    @Test
    public void testCalculatePremium() {
        // Arrange (Подготовка данных)
        TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
        String firstName = "John";
        String lastName = "Doe";
        Date dateFromStr =  new Date();
        Date dateToStr = new Date();

        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(firstName, lastName, dateFromStr, dateToStr);

        // Act (Выполнение действия)
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(firstName, response.getPersonFirstName());
        assertEquals(lastName, response.getPersonLastName());
        assertEquals(dateFromStr, response.getAgreementDateFrom()); //public CharSequence getAgreementDateTo () {}
        assertEquals(dateToStr, response.getAgreementDateTo());
    }
}
