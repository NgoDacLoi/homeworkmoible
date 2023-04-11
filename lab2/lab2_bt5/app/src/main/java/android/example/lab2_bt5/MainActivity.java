package android.example.lab2_bt5;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_Google, btn_Phone, btn_View, btn_Send, btn_Picture, btn_Music, btn_Map,btn_Addcontact, btn_SendMail, btn_Wifi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Process button Google
        btn_Google = findViewById(R.id.btn_Google);

        btn_Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        //Process button Phone
        btn_Phone = findViewById(R.id.btn_Phone);

        btn_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: (+84)123456789"));
                startActivity(intent);
            }
        });

        //Process button View
        btn_View = findViewById(R.id.btn_View);

        btn_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        //Process button Send
        btn_Send = findViewById(R.id.btn_Send);

        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
                intent.putExtra("sms_body","T7 nay di ra HN ko?");
                startActivity(intent);
            }
        });

        //Process button Picture
        btn_Picture =   findViewById(R.id.btn_Picture);

        btn_Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                myIntent.setType("image/pictures/*");
                myIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(myIntent);

            }
        });

        //Process Button Music
        btn_Music = findViewById(R.id.btn_Music);

        btn_Music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(myActivity2);
            }
        });

        //Process button Map
        btn_Map = findViewById(R.id.btn_Map);

        btn_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?"+"saddr=9.938083,-84.054430&daddr=9.926392,-84.055964";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        //Process button Send Mail

        btn_SendMail =findViewById(R.id.btn_Sendmail);
        btn_SendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, "ngodacoi")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "ngodacloi")
                        .putExtra(CalendarContract.Events.DESCRIPTION, "10")
                        .putExtra(CalendarContract.Events.ALL_DAY, "11");
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                }

        }
        });

        //Process button Addcontact
        btn_Addcontact = findViewById(R.id.btn_Addcontact);

        btn_Addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME, "ngodacloi");
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "ngodacloi");
                startActivity(intent);
            }
        });

        //Process button Wifi
        btn_Wifi = findViewById(R.id.btn_Wifi);

        btn_Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });
    }

}