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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        MovieFactory factory = new MovieFactory();
        factory.getModel();
        List<String> arr = new ArrayList<>();
        arr = MovieData.getGenre();
        spinner1  =  findViewById(id.spineer);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        editText = findViewById(id.edit_Text);

    }



    public void bsearchOnClick(View view) {
        ArrayList<Movie> result = new ArrayList<>();
        EditText myText = (EditText) this.findViewById(id.edit_Text);
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

    }

    private String print(ArrayList<Movie> result) {
        String ress = "";

        if(result.isEmpty())
            ress= "Movie is not exist in this Library";
        else{
        for (int i =0 ; i<result.size();i++){
            ress+= result.get(i).toString() +"\n";
        }}
        return ress;
    }
}