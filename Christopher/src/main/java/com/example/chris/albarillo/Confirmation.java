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
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


public class Confirmation extends AppCompatActivity {

    ArrayList<String> toppingsList = new ArrayList<>(); //List of names(toppings) //update removed string inside bracket
    ArrayList<Integer> valueList = new ArrayList<>(); //List of values(toppings)
    ArrayList<Integer> valueList2 = new ArrayList<>(); //Pizza value
    ArrayList<Integer> totalValue = new ArrayList<>(); //Total value of order
    ArrayList<String> credentials = new ArrayList<>(); //credentials
    //ArrayList<Integer> credit = new ArrayList<>(); //credit card number




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        final TextView text1 = (TextView)findViewById(R.id.confirmationText);
        final TextView text2 = (TextView)findViewById(R.id.totalText);
        final TextView text3 = (TextView) findViewById(R.id.totalText2);
        final TextView text4 = (TextView) findViewById(R.id.total1);
        toppingsList = getIntent().getStringArrayListExtra("listKey"); //List of names(toppings)
        valueList = getIntent().getIntegerArrayListExtra("listValue"); //List of values(toppings)
        valueList2 = getIntent().getIntegerArrayListExtra("listValue2"); //Pizza value
        totalValue = getIntent().getIntegerArrayListExtra("totalValue");
        text4.setText("$"+totalValue.get(0));

        //Enter credentials including credit card information
        final EditText editName = (EditText)findViewById(R.id.editText);
        final EditText editName2 = (EditText)findViewById(R.id.editText2);
        final EditText editName3 = (EditText)findViewById(R.id.editText3);
        final EditText editName4 = (EditText)findViewById(R.id.editText4);

        String toppings = "", val = "", val2 = "";

        //toppings list
        for(String Selections : toppingsList){
            toppings = toppings + Selections + "\n";

        }
        text1.setText(toppings);

        //getting the value of the pizza using for loop
        for(int vals : valueList2){
            val2 = val2 + vals + "\n";
        }
        text2.setText(val2);

        /**getting the value of the toppings with the use of try and catch
        because there is an option that clears the valueList to null/default.
        */
        try {
            for (int vals : valueList) {
                val = val + vals + "\n";
            }

            text3.setText(val);
        }catch(NullPointerException nullPointer){

        }

        final Button button2 = (Button)findViewById(R.id.order1);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String credit="";
                Intent intent = new Intent(Confirmation.this,Receipt.class);
                credentials.add(editName.getText().toString());
                credentials.add(editName2.getText().toString());
                credentials.add(editName3.getText().toString());
                credit = editName4.getText().toString();

                intent.putStringArrayListExtra("credentials",credentials);
                intent.putExtra("credit",credit);
                intent.putStringArrayListExtra("pizza", toppingsList);
                intent.putIntegerArrayListExtra("pizzaValue", valueList2);
                intent.putIntegerArrayListExtra("toppingsValue", valueList);
                intent.putIntegerArrayListExtra("totalValue", totalValue);

                startActivity(intent);


            }

        });


        final Button button1 = (Button)findViewById(R.id.backButton);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                finish();
            }

        });



    }

}
