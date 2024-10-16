package com.example.anew;

//import static androidx.core.content.ContextCompat.getSystemService;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NotificationFragment extends Fragment {

    public NotificationFragment() {
        // Required empty public constructor
    }
    private ImageButton buttonUv;
    //создание пуша

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        buttonUv = view.findViewById(R.id.buttonUv);


        //создание пуша
        MyPushNotification myPushNotification = new MyPushNotification(requireContext(),
                requireActivity().getSystemService(NotificationManager.class));
        buttonUv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPushNotification.sendNotify("Веретенникова Анастасия Евгеньевна","Группа: Т-413901-НТ ИСиТ");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}