package com.example.agedatabase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.agedatabase.R;

public class InsertFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_insert, container, false);
        // Database and UI code goes here in next chapter

        // Database and UI code goes here in next chapter
        final DataManager dm = new DataManager(getActivity());
        Button btnInsert = (Button) v.findViewById(R.id.btnInsert);
        final EditText editName = (EditText) v.findViewById(R.id.editName);
        final EditText editAge = (EditText) v.findViewById(R.id.editAge);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.insert(editName.getText().toString(),
                        editAge.getText().toString());
            }
        });
        return v;
    }

}
