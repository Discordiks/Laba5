package com.example.anew;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.content.Context;
import android.os.Build;
import android.util.Log;
//import android.support.v4.app.NotificationCompat;

public class MyPushNotification {
    private static String CHANNEL_ID="Base channel";
    private static String CHANNEL_DESCRIPTION="it's a base channel";
    private static final int NOTIFY_ID=315;
    private NotificationManager notificationManager;
    private Context context;

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_ID,importance);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public MyPushNotification(Context context,NotificationManager manager){
        notificationManager=manager;
        this.context=context;
        createNotificationChannel();
    }

    public void sendNotify(String title,String text){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.notification_24);
        try {
            notificationManager.notify(NOTIFY_ID, builder.build());
        } catch (Exception e) {
           Log.e("MyPushNotification", "Ошибка: ", e);
        }
    }
}