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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Receipt extends AppCompatActivity {

    ArrayList<String> pizza = new ArrayList<>();
    ArrayList<Integer> pizzaValue = new ArrayList<>();
    ArrayList<Integer> toppingsValue = new ArrayList<>();
    ArrayList<String> credentials = new ArrayList<>();
    ArrayList<Integer> totalValue = new ArrayList<>(); //Total value of order


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);*/
        Random r = new Random();
        int ran = r.nextInt(4000 - 1000) + 1000;
        //Produces random number for order number
        TextView randomText = (TextView) findViewById(R.id.randomNum1);
        randomText.setText("Order number: "+ran);

        String credit="";
        pizza = getIntent().getStringArrayListExtra("pizza"); //pizza name
        pizzaValue = getIntent().getIntegerArrayListExtra("pizzaValue");
        toppingsValue = getIntent().getIntegerArrayListExtra("toppingsValue"); //List of values(toppings)
        credentials = getIntent().getStringArrayListExtra("credentials"); //credentials
        totalValue = getIntent().getIntegerArrayListExtra("totalValue");

        credit = getIntent().getStringExtra("credit");



        final TextView text1 = (TextView)findViewById(R.id.listName);
        String tops = "";
        for(String list : pizza){
            tops = tops + list + "\n";

        }
        text1.setText(tops);

        final TextView text2 = (TextView)findViewById(R.id.listValue);

        String pizzaValString="", toppingsValString = "";
        for(int pizzaValInt : pizzaValue ){
            pizzaValString = pizzaValString + pizzaValInt + "\n";

        }

        for(int toppingsValInt : toppingsValue ){
            toppingsValString = toppingsValString + toppingsValInt + "\n";

        }
        text2.setText(pizzaValString + toppingsValString);


        final TextView text3 = (TextView)findViewById(R.id.credentials1);
        String cred1 ="";
        for(String cred2: credentials){
            cred1 = cred1 + cred2 + "\n";
        }
        text3.setText(cred1);

        final TextView text4 = (TextView)findViewById(R.id.credit1);
        text4.setText("Credit card number: "+credit);

        final TextView text5 = (TextView)findViewById(R.id.totalValue);
        text5.setText("$" + totalValue.get(0));

        final Button menuButton = (Button)findViewById(R.id.mainButton1);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Receipt.this,ChristopherActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
/*
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
    }  */
}
