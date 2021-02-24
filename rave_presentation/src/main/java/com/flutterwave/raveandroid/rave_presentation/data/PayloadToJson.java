package com.flutterwave.raveandroid.rave_presentation.data;

import com.flutterwave.raveandroid.rave_java_commons.Payload;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

public class PayloadToJson {

    public Gson gson;

    @Inject
    public PayloadToJson(Gson gson) {
        this.gson = gson;
    }

    public String convertChargeRequestPayloadToJson(Payload body) {

        Type type = new TypeToken<Payload>() {
        }.getType();
        return gson.toJson(body, type);
    }

}