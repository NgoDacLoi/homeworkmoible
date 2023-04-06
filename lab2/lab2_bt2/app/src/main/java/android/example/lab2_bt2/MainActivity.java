package android.example.lab2_bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // load the layout
        setContentView(R.layout.activity_main);
    }
        public void goToAnActivity(View v) {
            Intent iGetConctactInfo = new Intent(this, ViewContactInfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("namekey", ((EditText) v).getText().toString());
            bundle.putString("emailkey", ((EditText) v).getText().toString());
            bundle.putString("projectkey", ((EditText) v).getText().toString());
            iGetConctactInfo.putExtras(bundle);

            startActivity(iGetConctactInfo);

        }
}



