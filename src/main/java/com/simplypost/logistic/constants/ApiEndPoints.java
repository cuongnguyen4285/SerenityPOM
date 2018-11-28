package com.simplypost.logistic.constants;

public interface ApiEndPoints {

    String AUTHORIZATION = "Authorization";
    String CONTENT_TYPE = "Content-Type";
    String APPLICATION_JSON = "application/json";
    String MULTIPART_FORM_DATA = "multipart/form-data";

    String TRACKING_ID = "tracking_id";
    String REFERENCE_NUMBER = "reference_number";

    String MERCHANT_LOGIN = "/api/gateway/v1/auth/login";
    String CREATE_ORDER = "/api/gateway/v1/deliveries";

}
