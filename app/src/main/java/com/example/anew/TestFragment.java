package com.example.anew;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
//import android.support.v7.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestFragment extends Fragment {

    public TestFragment() {
        // Required empty public constructor
    }
    private Button buttonAnswer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        buttonAnswer = (Button) view.findViewById(R.id.buttonAnswer);
        String[] igroki={"Лелуш Ламперуж", "Кёко Киригири", "Макото Наеги"};
        boolean[] igroki_c={false, false, false};

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Кто НЕ является персонажем Данганронпы?")
                        .setMultiChoiceItems(igroki, igroki_c, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                igroki_c[i]=b;
                            }
                        })
                        .setPositiveButton("Проверить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (igroki_c[0] && !igroki_c[1] && !igroki_c[2]){
                                    Toast mytost = Toast.makeText(getContext().getApplicationContext(), "Совершенно верно!", Toast.LENGTH_LONG);
                                    mytost.show();
                                }
                                else{
                                    Toast mytost = Toast.makeText(getContext().getApplicationContext(), "Увы, Вы не правы!", Toast.LENGTH_LONG);
                                    mytost.show();
                                }
                            }
                        })
                        .setCancelable(false); //запрещает тыкать по экрану
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}