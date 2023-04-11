package codewithcal.au.calculatorappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class second_activity2 extends AppCompatActivity {


    ListView l;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
       // String hisCount = String.valueOf(intent.getExtras());

        ArrayList<MainActivity.operation> a = (ArrayList<MainActivity.operation>) intent.getSerializableExtra("operations");

      //  TextView textView = (TextView) findViewById(R.id.showCount);

      /*   StringBuilder builder = new StringBuilder();
        for (MainActivity.operation b: a) {
            builder.append(a);
            builder.append(", ");
        }

        textView.setText(builder.toString());*/


        l = findViewById(R.id.list);
        ArrayAdapter<MainActivity.operation> arr;
        arr    = new ArrayAdapter(
                this,R.layout.support_simple_spinner_dropdown_item, a);
        l.setAdapter(arr);
    }
}