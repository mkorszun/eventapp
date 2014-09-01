package com.eventapp.task;

public interface ListEventExecutor {
    public void onSuccess();

    public void onFailure(Exception e);
}
