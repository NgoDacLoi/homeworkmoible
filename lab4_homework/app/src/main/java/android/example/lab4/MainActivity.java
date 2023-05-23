package android.example.lab4;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

    Button save,cancel,change;
    RadioButton female,male;

    EditText name,mail,phone;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=(Button) findViewById(R.id.save);
        cancel=(Button) findViewById(R.id.cancel);
        change=(Button) findViewById(R.id.change);

        female = findViewById(R.id.radio2);
        male = findViewById(R.id.radio1);

        name=(EditText) findViewById(R.id.name);
        mail=(EditText) findViewById(R.id.mail);
        phone=(EditText) findViewById(R.id.phone);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
        change.setOnClickListener(this);
        female.setOnClickListener(this::radio1);
        female.setOnClickListener(this::radio2);
        this.imageView = (ImageView) this.findViewById(R.id.image);

        readData();
    }
    public void radio2(View view) {
            female.setChecked(true);
        male.setChecked(false);
        //Toast.makeText(this, female.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public void radio1(View view) {
        male.setChecked(true);
        female.setChecked(false);
        //Toast.makeText(this, male.getText().toString(), Toast.LENGTH_SHORT).show();

    }
    public void onClick(View v) {
        if(v.getId()==R.id.cancel)
        {
            finish();
        }
        else if(v.getId()==R.id.save)
        {
            writeData();
        }
        if(v.getId()==R.id.change)
        {
           // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

           // File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

          //  File output = new File(dir, "CameraDemo.jpeg");

           // intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
           // startActivityForResult(intent, 100);

           // Create an implicit intent, for image capture.
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Start camera and wait for the results.
           this.startActivityForResult(intent, 100);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                this.imageView.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
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
            int i=0;
            String data="";
            StringBuilder builder=new StringBuilder();
            while((data=reader.readLine())!=null)
            {
               // builder.append(data);

                if(i==0) {
                    name.setText(data);
                             }
                if(i==1) {
                    mail.setText(data);

                            }
                if(i==2) {
                    phone.setText(data);
                             }
                if(i==3){ female.setChecked(true);
                    male.setChecked(false);
                }
                if(i==4){ female.setChecked(false);
                    male.setChecked(true);}
                //builder.append("\n");
                i++;
            }
            in.close();

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
            writer.write(name.getText().toString()+"\n");
            writer.write(mail.getText().toString()+"\n");
            writer.write(phone.getText().toString()+"\n");

            writer.write("1"+"\n");


            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}