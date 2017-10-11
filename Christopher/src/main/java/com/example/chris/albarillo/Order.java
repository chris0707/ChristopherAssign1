package com.example.chris.albarillo;
/**Christopher Albarillo
 * N01076336
 * CENG319 ONA
 * Assignment1 Pizza App
 */

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


public class Order extends AppCompatActivity{

    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<Integer> mainValue = new ArrayList<>();
    ArrayList<Integer> totalValue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Retrieving the Ordered pizza and its value

        Intent intent = getIntent();
        String crust = intent.getExtras().getString("crust");
        int val = intent.getExtras().getInt("value");

        mainValue.add(val);
        selection.add(crust);
        selection.add("Chicken");
        selection.add("Bacon");
        selection.add("Green Pepper");
        selection.add("Onion");




        final TextView text1 = (TextView)findViewById(R.id.textView1);
        text1.setText(crust);

        final TextView price = (TextView)findViewById(R.id.price1);
        String print = "";
        String print2 = "";

        for(int s : mainValue){
            print2 += s; }
        price.setText(print2);

        final Button button1 = (Button)findViewById(R.id.nextButton);
        button1.setEnabled(false);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Intent intent = new Intent(Order.this, Confirmation.class);
                intent.putStringArrayListExtra("listKey",selection);
                intent.putIntegerArrayListExtra("listValue", values);
                intent.putIntegerArrayListExtra("listValue2", mainValue);
                intent.putIntegerArrayListExtra("totalValue", totalValue);

                startActivity(intent);

            }
        });


        final Button button2 = (Button)findViewById(R.id.backButton);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();

            }
        });


        final EditText editText1 = (EditText)findViewById(R.id.inputText1);
        final EditText editText2 = (EditText)findViewById(R.id.inputText2);
        final EditText editText3 = (EditText)findViewById(R.id.inputText3);
        final EditText editText4 = (EditText)findViewById(R.id.inputText4);


        final TextView total1 =(TextView)findViewById(R.id.totalView1);
        total1.setVisibility(View.INVISIBLE);
        final Button confirmButton1 = (Button)findViewById(R.id.confirm1);


        confirmButton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                confirmButton1.setEnabled(false);
                button1.setEnabled(true);
                if(TextUtils.isEmpty(editText1.getText().toString()))
                {
                    editText1.setText("0");
                }

                if(TextUtils.isEmpty(editText2.getText().toString()))
                {
                    editText2.setText("0");
                }

                if(TextUtils.isEmpty(editText3.getText().toString()))
                {
                    editText3.setText("0");
                }

                if(TextUtils.isEmpty(editText4.getText().toString()))
                {
                    editText4.setText("0");
                }
                try {
                    values.add(Integer.valueOf(editText1.getText().toString())*3);
                    values.add(Integer.valueOf(editText2.getText().toString())*2);
                    values.add(Integer.valueOf(editText3.getText().toString())*1);
                    values.add(Integer.valueOf(editText4.getText().toString())*1);
                }catch(NullPointerException nullPointer){

                }

                int sum1=0;
                for(int i =0; i<values.size(); i++){
                    sum1 += Integer.parseInt(String.valueOf(values.get(i)));

                }
                int sum2=0;
                sum2+=Integer.parseInt(String.valueOf(mainValue.get(0)));

                int sum3 = sum1+sum2;
                totalValue.add(sum3);


                total1.setText("Your total is $"+sum3);
                total1.setVisibility(View.VISIBLE);

            }
        });


            final Button button3 = (Button) findViewById(R.id.clear1);
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {


                    editText1.getText().clear();
                    editText2.getText().clear();
                    editText3.getText().clear();
                    editText4.getText().clear();

                    values.clear();
                    totalValue.clear();
                    confirmButton1.setEnabled(true);
                    button1.setEnabled(false);
                }
            });








    }


}
