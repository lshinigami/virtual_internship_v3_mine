package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TravelCalculatePremiumServiceImplTest {
    TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
    TravelCalculatePremiumRequest request;
    TravelCalculatePremiumResponse expectedResponse;
    TravelCalculatePremiumResponse actualResponse;

    @BeforeEach
    private void setUp() {
        request = new TravelCalculatePremiumRequest("Zhansaya", "Kalymova", "14/12/1996", "14/12/1998");

        expectedResponse = service.calculatePremium(request);
        actualResponse = new TravelCalculatePremiumResponse(request.getPersonFirstName(),
                request.getPersonLastName(),
                request.getAgreementDateFrom(),
                request.getAgreementDateTo());
    }

    @Test
    public void getResponse() {
        assertEquals(expectedResponse.getPersonFirstName(), actualResponse.getPersonFirstName());
        assertEquals(expectedResponse.getPersonLastName(), actualResponse.getPersonLastName());
        assertEquals(expectedResponse.getAgreementDateFrom(), actualResponse.getAgreementDateFrom());
        assertEquals(expectedResponse.getAgreementDateTo(), actualResponse.getAgreementDateTo());
    }

    @Test
    public void getFirstName() {
        assertEquals(expectedResponse.getPersonFirstName(), actualResponse.getPersonFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(expectedResponse.getPersonLastName(), actualResponse.getPersonLastName());
    }

    @Test
    public void getDateFrom() {
        assertEquals(expectedResponse.getAgreementDateFrom(), actualResponse.getAgreementDateFrom());
    }

    @Test
    public void getDateTo() {
        assertEquals(expectedResponse.getAgreementDateTo(), actualResponse.getAgreementDateTo());
    }

}