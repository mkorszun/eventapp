package com.eventapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.eventapp.R;
import com.eventapp.model.Event;
import com.eventapp.task.CreateEventExecutor;
import com.eventapp.task.CreateEventTask;

public class CreateEventFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.event_create_fragment, container, false);
        setListeners(rootView);
        return rootView;
    }

    private void setListeners(final View rootView) {
        Button createButton = (Button) rootView.findViewById(R.id.dummy_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateEventTask(new CreateEventExecutor() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getActivity(), "Event created", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getActivity(), "Failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }).execute(getEvent(rootView));
            }
        });
    }

    private Event getEvent(View rootView) {
        String headline = ((EditText) rootView.findViewById(R.id.headline)).getText().toString();
        String costStr = ((EditText) rootView.findViewById(R.id.cost)).getText().toString();
        String durationStr = ((EditText) rootView.findViewById(R.id.duration)).getText().toString();
        String description = ((EditText) rootView.findViewById(R.id.description)).getText().toString();
        String locationX = ((EditText) rootView.findViewById(R.id.locationX)).getText().toString();
        String locationY = ((EditText) rootView.findViewById(R.id.locationY)).getText().toString();

        Event event = new Event();
        event.user_id = "Mateusz";
        event.headline = headline;
        event.cost = Float.parseFloat(costStr);
        event.duration = Integer.parseInt(durationStr);
        event.description = description;
        event.x = Long.parseLong(locationX);
        event.y = Long.parseLong(locationY);
        return event;
    }
}
