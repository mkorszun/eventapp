package com.eventapp.backend;

import com.eventapp.model.Event;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface BackendInterface {

    @POST("/event")
    String create(@Body Event event);

    @GET("/event")
    String list(@Path("x") long x, @Path("y") long y);
}
