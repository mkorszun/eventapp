package com.eventapp.task;

import android.os.AsyncTask;

import com.eventapp.backend.BackendInterface;
import com.eventapp.backend.BackendInterfaceFactory;
import com.eventapp.model.EventRead;

import java.util.List;

public class ListEventTask extends AsyncTask<Long, Void, List<EventRead>> {

    private ListEventExecutor executor;
    private Exception exception;

    public ListEventTask(ListEventExecutor executor) {
        this.executor = executor;
    }

    @Override
    protected List<EventRead> doInBackground(Long... params) {
        try {
            BackendInterface backend = BackendInterfaceFactory.build();
            backend.list(params[0], params[1]);
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<EventRead> v) {
        if (exception != null) {
            executor.onFailure(exception);
        } else {
            executor.onSuccess();
        }
    }
}