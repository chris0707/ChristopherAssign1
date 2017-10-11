package com.example.chris.albarillo;
/**Christopher Albarillo
 * N01076336
 * CENG319 ONA
 * Assignment1 Pizza App
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChristopherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christopher);

        //Next button
        final Button button1 = (Button)findViewById(R.id.nextButton);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(ChristopherActivity.this, Detail.class);
                startActivity(intent);

            }

        });

        //Exit button
        final Button button2 = (Button)findViewById(R.id.backButton);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finishAffinity();

            }

        });


    }



}
