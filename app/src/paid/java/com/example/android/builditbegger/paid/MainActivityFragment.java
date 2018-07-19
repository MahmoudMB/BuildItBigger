package com.example.android.builditbegger;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.androidlibraryjoke.JokeActivity;
import com.example.android.builditbegger.R;


import com.example.android.builditbegger.EndpointsAsyncTask;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.ReciveJokeFromGCE {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);



        Button button = (Button)root.findViewById(R.id.GCEbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new EndpointsAsyncTask(MainActivityFragment.this).execute(new Pair<Context, String>(getActivity().getApplicationContext(), "Manfred"));

            }
        });


        return root;

    }


    @Override
    public void onReceived(String joke) {


        Intent intent = new Intent(getContext(),JokeActivity.class);
        intent.putExtra("Joke",joke);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
}
