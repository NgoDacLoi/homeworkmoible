package android.example.bt4;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button btn;

    TextView txt;


    private AlertDialog.Builder editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editTextTextPersonName);
        btn = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textViewhienthi);
        final AlertDialog ad = new AlertDialog.Builder(this).create();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t;
                t = edit.getText() + "";
                ad.setMessage(t);
                ad.show();
            }
        });
    }
}
