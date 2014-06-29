package com.eventapp.backend;

import com.eventapp.model.Event;
import retrofit.http.Body;
import retrofit.http.POST;

public interface BackendInterface {

    @POST("/event")
    String create(@Body Event event);
}
