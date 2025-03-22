package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TravelCalculatePremiumServiceImplTest {
    TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();;

    @Test
    public void getResponse() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Zhansaya", "Kalymova", "14/12/1996", "14/12/1998");

        //expected response
        TravelCalculatePremiumResponse expectedResponse = service.calculatePremium(request);

        //actual response
        TravelCalculatePremiumResponse actualResponse = new TravelCalculatePremiumResponse(request.getPersonFirstName(),
                request.getPersonLastName(),
                request.getAgreementDateFrom(),
                request.getAgreementDateTo());
        assertEquals("Zhansaya", actualResponse.getPersonFirstName());
        assertEquals("Kalymova", actualResponse.getPersonLastName());
        assertEquals("14/12/1996", actualResponse.getAgreementDateFrom());
        assertEquals("14/12/1998", actualResponse.getAgreementDateTo());

    }

}