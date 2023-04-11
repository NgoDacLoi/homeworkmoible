package android.example.lab2_bt2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1, button2,button3,button4;
        final RelativeLayout relativeLayout;

        // set button 1 with its id
        button1 = findViewById(R.id.btVar1);

        // set button 2 with its id
        button2 = findViewById(R.id.btVar2);


        button3 = findViewById(R.id.btVar3);

        // set button 2 with its id
        button4 = findViewById(R.id.btVar4);


        // set relative layout with its id
        relativeLayout = findViewById(R.id.rlVar1);

        // onClick function for button 1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                relativeLayout.setBackgroundResource(R.color.red);
            }
        });

        // onClick function for button 2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                relativeLayout.setBackgroundResource(R.color.yellow);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                relativeLayout.setBackgroundResource(R.color.blue);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                relativeLayout.setBackgroundResource(R.color.gray);
            }
        });
    }
}
