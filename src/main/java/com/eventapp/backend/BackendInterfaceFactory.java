package com.eventapp.backend;

import retrofit.RestAdapter;

public class BackendInterfaceFactory {

    public static final String URL = "https://eventbackend.cloudcontrolled.com/";

    public static BackendInterface build() {
        return build(URL);
    }

    public static BackendInterface build(String url) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(url).build();
        return restAdapter.create(BackendInterface.class);
    }
}
