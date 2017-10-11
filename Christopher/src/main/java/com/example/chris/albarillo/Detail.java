package com.example.chris.albarillo;
/**Christopher Albarillo
 * N01076336
 * CENG319 ONA
 * Assignment1 Pizza App
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        final ImageView imageButton1 = (ImageView) findViewById(R.id.regularImage);
        imageButton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String regular = "Regular Pizza";
                int intVal = 5;
                Intent intent = new Intent(Detail.this, Order.class);
                intent.putExtra("crust", regular);
                intent.putExtra("value",intVal);

                startActivity(intent);
            }

        });

        final ImageView imageButton2 = (ImageView) findViewById(R.id.largeImage);
        imageButton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String large = "Large Pizza";
                int intVal = 10;
                Intent intent = new Intent(Detail.this, Order.class);
                intent.putExtra("crust", large);
                intent.putExtra("value", intVal);


                startActivity(intent);
            }

        });


        final Button button2 = (Button)findViewById(R.id.backButton);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbarmenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.appbar1:
                appbar();
                return true;
            case R.id.help1:
                helpbar();
                return true;
            case R.id.pizza1:
                pizzabar();
                return true;
            case R.id.name1:
                namebar();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


    }

    private void appbar() {
        Uri uri = Uri.parse("https://developer.android.com/training/appbar/setting-up.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void helpbar() {

        Uri uri = Uri.parse("https://developer.android.com/index.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void pizzabar() {
        Uri uri = Uri.parse("https://www.pizzahut.ca/home");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void namebar() {
        Toast.makeText(getBaseContext(),"Yep..That's my name alright.",Toast.LENGTH_LONG).show();
    }
}
