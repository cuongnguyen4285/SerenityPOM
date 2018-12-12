package com.simplypost.logistic.features.api.createOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplypost.logistic.constants.TestAccounts;
import com.simplypost.logistic.constants.TestDatas;
import com.simplypost.logistic.model.api.DeliveryApi;
import com.simplypost.logistic.platform.api.CreateOrderStepApi;
import com.simplypost.logistic.platform.api.LoginStepApi;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.simplypost.logistic.utilities.DateTimeUtil.*;
import static com.simplypost.logistic.utilities.RandomUtil.getRandomNumber;

@Narrative(text = {"As merchant, I would like to create order via Api gateway"})

@WithTags({
        @WithTag(type = "Feature", name = "CreateOrder"),
        @WithTag(type = "API", name = "Regression"),
        @WithTag(type = "API_Priority", name = "P1")
})
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateOrderApiFeatures {
    private final String randomNumber = getRandomNumber(1,10000);
    private String easyshipToken;

    DeliveryApi delivery = new DeliveryApi();

    @Managed(uniqueSession = true)
    WebDriver webDriver;

    @Steps
    LoginStepApi loginStepApi;

    @Steps
    CreateOrderStepApi createOrderStepApi;

    @Before
    public void beforeTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        delivery = mapper.readValue(new File(TestDatas.EASYSHIP_E0009_API), DeliveryApi.class);
        delivery.setReferenceNumber(getUnquieName("REF_"))
                .setPickupDetails(delivery.getPickupDetails()
                        .setDate(convertToApiPickupDate(getPickupDate(delivery.getMerchantCode())))
                        .setTimeSlot(getTimeSlot(delivery.getMerchantCode()))
                        .setUnit("ES"+randomNumber));

        loginStepApi.login(TestAccounts.EASYSHIP_USERNAME, TestAccounts.PASSWORD);
        easyshipToken = loginStepApi.getToken();
    }

    @Title("Verify merchant can create order via Api successfully")
    @Issue("POS-1002")
    @Test
    public void verifyMerchantCanCreateOrderViaApiSuccessfully(){
        createOrderStepApi.createOrder(easyshipToken, delivery);
        String trackingId = createOrderStepApi.getTrackingID();
        createOrderStepApi.shouldSeeCorrectResponseWhenCreatingOrder();
    }

    @After
    public void afterTest(){
    }





}
