package com.example.anew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactFragment extends Fragment {

    public ContactFragment() {
        // Required empty public constructor
    }
    private TextView editFIO;
    private TextView editEmail;
    private Button buttonOK;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        editFIO =  view.findViewById(R.id.editFIO);
        editEmail = view.findViewById(R.id.editEmail);
        buttonOK = view.findViewById(R.id.buttonOK);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFIO.setText("");
                editEmail.setText("");
                Toast.makeText(getActivity().getApplicationContext(), "Данные успешно отправлены!", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}