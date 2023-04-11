package android.example.lab2_bt2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewContactInfoActivity extends Activity {



    TextView txtNameValue;
    TextView txtEmailValue;
    TextView txtProjectValue;

    Button finishBtn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        txtNameValue = findViewById(R.id.nameValue);
        txtEmailValue = findViewById(R.id.emailValue);
        txtProjectValue = findViewById(R.id.projectvalue);

        finishBtn = findViewById(R.id.finish);
        finishBtn.setOnClickListener(mClickFinishListener);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("nameKey");
        String mail = bundle.getString("emailKey");
        String project = bundle.getString("projectKey");

        txtNameValue.setText(name);
        txtEmailValue.setText(mail);
        txtProjectValue.setText(project);

    }
    private final View.OnClickListener mClickFinishListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            finish();
        }
    };
}


