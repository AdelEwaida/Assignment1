package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import  com.example.assignment.controller.MovieFactory;
import android.widget.ArrayAdapter;
import com.example.assignment.model.*;
import com.example.assignment.controller.MovieFactory;

import  java.util.*;

import  static  com.example.assignment.R.*;
import  com.example.assignment.controller.MovieFactory;
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Spinner spinner1;
//    MovieFactory factory = new MovieFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        MovieFactory factory = new MovieFactory();
        factory.getModel();
        List<String> arr = new ArrayList<>();
//        MovieData data = new MovieData();
        arr = MovieData.getGenre();
        spinner1  =  findViewById(id.spineer);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
//
//

        editText = findViewById(id.edit_text);
    }



    public void bsearchOnClick(View view) {
        ArrayList<Movie> result = new ArrayList<>();
        EditText myText = (EditText) this.findViewById(id.edit_text);
        EditText res = this.findViewById(id.result);
        Editable word =myText.getText();
        String spin = spinner1.getSelectedItem().toString();
        boolean numeric = true;
        if (word.equals("")) {
            result = MovieData.searchSpin(spin);
        } else{
            try {
                int num =Integer.parseInt(String.valueOf(word));
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric) {
                if(MovieData.searchNum( Integer.parseInt(String.valueOf(word)),spin)!=null)
                    result= MovieData.searchNum( Integer.parseInt(String.valueOf(word)),spin);
            }
            else {
                if ( MovieData.searchTitle(String.valueOf(word),spin)!=null) {
                    result = MovieData.searchTitle(String.valueOf(word),spin);
                }
            } }
        if(result!=null) {
            res.setText(print(result));
        }
        else
        {
            res.setText("There is no Films");

        }

//        Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();

    }

    private String print(ArrayList<Movie> result) {
        String ress = null;
        for (int i =0 ; i<result.size();i++){
            ress+= result.get(i).toString() +"\n";
        }
        return ress;
    }
}