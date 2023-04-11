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


    TextView txtName;
    TextView txtEmail;
    TextView txtProject;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // load the layout
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.nameKey);
        txtEmail = findViewById(R.id.emailKey);
        txtProject = findViewById(R.id.projectKey);
    }
        public void goToAnActivity(View v) {
            Intent iGetConctactInfo = new Intent(this, ViewContactInfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nameKey", txtName.getText().toString());
            bundle.putString("emailKey", txtEmail.getText().toString());
            bundle.putString("projectKey", txtProject.getText().toString());
            iGetConctactInfo.putExtras(bundle);

            startActivity(iGetConctactInfo);

        }
}



