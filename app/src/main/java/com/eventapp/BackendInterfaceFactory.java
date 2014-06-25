package com.eventapp;

import retrofit.RestAdapter;

public class BackendInterfaceFactory {

    public static final String URL = "https://eventbackend.cloudcontrolled.com/";

    public static BackendInterface build() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(URL).build();
        return restAdapter.create(BackendInterface.class);
    }
}
