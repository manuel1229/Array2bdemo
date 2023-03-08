package com.example.arraydemo2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> addArray = new ArrayList<>();
    Button add;
    EditText newString;
    ListView showList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newString = (EditText) findViewById(R.id.ed1);
        showList = (ListView) findViewById(R.id.lv1);
        add = (Button) findViewById(R.id.btn1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getString = newString.getText().toString();

                if(addArray.contains(getString)){

                    Toast.makeText(getBaseContext(), "Item already added!", Toast.LENGTH_SHORT).show();
                }

                else if( getString.trim().equals("")){

                    Toast.makeText(getBaseContext(), "Input field is empty!", Toast.LENGTH_SHORT).show();

                }

                else {

                    addArray.add(getString);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray);
                    showList.setAdapter(adapter);
                    ((EditText)findViewById(R.id.ed1)).setText("");

                }


            }
        });

    }
}