package com.dinhdan.prm392_ex7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    public TextView editTextName;
    public Button btnClickMe;
    public Button btnDial;
    public EditText editTextURL;
    public Button btnURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main
        ), (v, insets) -> {
            Insets systemBars =
                    insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = (EditText)
                findViewById(R.id.editTextName);
        btnClickMe = (Button) findViewById(R.id.buttonClickMe);
        btnDial = (Button) findViewById(R.id.buttonDial);
        btnURL = (Button) findViewById(R.id.buttonURL);
        editTextURL = (EditText) findViewById(R.id.editTextURL);
        //Explicit Intent
        //Input Your name, click button CLICK ME -> open MainActivity02, display Hello + name
        btnClickMe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity02.class);
                String yName=editTextName.getText().toString();
                intent.putExtra("MESSAGE", yName);
                startActivity(intent);
            }
        });
        //Implicit Intent
        //Click button DIAL, open Dial UI
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        //Implicit Intent
        //Input URL, click button BROWSE URL -> open website
        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editTextURL.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}