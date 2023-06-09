package android.example.lab4;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*public class MainActivity extends AppCompatActivity {

    EditText editdata;
    Button btn,writebtn;

    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editdata = (EditText) findViewById(R.id.editdata);

        btn = (Button) findViewById(R.id.btnreaddata);

        writebtn = (Button) findViewById(R.id.btnwritedata);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                InputStream inputStream = getResources().openRawResource(R.raw.myfile);
                try {
                    byte[] buffer = new byte[inputStream.available()];
                    while (inputStream.read(buffer) != -1)
                        txt = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                editdata.setText(txt);

            }

        });

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                InputStream inputStream = getResources().openRawResource(R.raw.myfile);
                try {
                    byte[] buffer = new byte[inputStream.available()];
                    while (inputStream.read(buffer) != -1)
                        txt = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                editdata.setText(txt);

            }

        });
    }
}
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

    Button btnread,btnwrite;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread=(Button) findViewById(R.id.btnreaddata);
        btnwrite=(Button) findViewById(R.id.btnwritedata);
        editdata=(EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.btnreaddata)
        {
            readData();
        }
        else if(v.getId()==R.id.btnwritedata)
        {
            writeData();
        }
    }
    /**
     * Hàm đọc tập tin trong Android
     * Dùng openFileInput trong Android để đọc
     * ra FileInputStream
     */
    public void readData()
    {
        try {
            FileInputStream in= openFileInput("myfile.txt");
            BufferedReader reader=new
                    BufferedReader(new InputStreamReader(in));
            String data="";
            StringBuilder builder=new StringBuilder();
            while((data=reader.readLine())!=null)
            {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            editdata.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Hàm ghi tập tin trong Android
     * dùng openFileOutput để ghi
     * openFileOutput tạo ra FileOutputStream
     */
    public void writeData()
    {
        try {
            FileOutputStream out=
                    openFileOutput("myfile.txt",0);
            OutputStreamWriter writer=
                    new OutputStreamWriter(out);
            writer.write(editdata.getText().toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}