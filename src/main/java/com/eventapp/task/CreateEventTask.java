package com.eventapp.task;

import android.os.AsyncTask;
import com.eventapp.backend.BackendInterface;
import com.eventapp.backend.BackendInterfaceFactory;
import com.eventapp.model.Event;

public class CreateEventTask extends AsyncTask<Event, Void, Void> {

    private CreateEventExecutor executor;
    private Exception exception;

    public CreateEventTask(CreateEventExecutor executor) {
        this.executor = executor;
    }

    @Override
    protected Void doInBackground(Event... params) {
        try {
            BackendInterface backend = BackendInterfaceFactory.build();
            backend.create(params[0]);
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Void v) {
        if (exception != null) {
            executor.onFailure(exception);
        } else {
            executor.onSuccess();
        }
    }
}
