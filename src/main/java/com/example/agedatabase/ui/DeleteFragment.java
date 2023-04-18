package com.example.agedatabase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.agedatabase.R;

public class DeleteFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_delete, container, false);
        // Database and UI code goes here in next chapter

        final DataManager dm = new DataManager(getActivity());
        Button btnDelete = (Button) v.findViewById(R.id.btnDelete);
        final EditText editDelete = (EditText) v.findViewById(R.id.editDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.delete(editDelete.getText().toString());
            }
        });
        return v;
    }
}
