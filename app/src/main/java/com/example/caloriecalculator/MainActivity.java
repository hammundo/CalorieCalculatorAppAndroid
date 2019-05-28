package com.example.caloriecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Calculation variables
    private int age;
    private int activityLevel;
    private double height;
    private double weight;
    private boolean isMale;

    //Create text fields
    private EditText ageText;
    private EditText heightText;
    private EditText weightText;

    //Create radioButton
    private RadioGroup radioGenderGroup;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    //Setup context and create toast messages
    private int duration = Toast.LENGTH_SHORT;
    private CharSequence ageError = "Please enter an age.";
    private CharSequence heightError = "Please enter a height.";
    private CharSequence weightError = "Please enter a weight.";
    private CharSequence genderError = "Please select a gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init text fields
        ageText = (EditText) findViewById(R.id.editTextAge);
        heightText = (EditText) findViewById(R.id.editTextHeight);
        weightText = (EditText) findViewById(R.id.editTextWeight);

        //Init button
        Button buttonCalculate = (Button) findViewById(R.id.buttonCalculate);

        //Init radio buttons
        radioGenderGroup = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);

        //Init spinner
        final Spinner spinnerActivitySelection = (Spinner) findViewById(R.id.spinnerActivitySelection);

        //Radio button listener
        View.OnClickListener radioButtonGenderSelectionListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get selected radio button from the radio group
                int selectedId = radioGenderGroup.getCheckedRadioButtonId();
                if(selectedId == 0) {
                    isMale = true;
                }
                if(selectedId == 1) {
                    isMale = false;
                }
            }
        };
        radioGenderGroup.setOnClickListener(radioButtonGenderSelectionListener);
        radioButtonMale.setOnClickListener(radioButtonGenderSelectionListener);
        radioButtonFemale.setOnClickListener(radioButtonGenderSelectionListener);

        //Calculate button listener
        View.OnClickListener buttonCalculateListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;

                //Check to see if fields are left blank and produce error toast if blank
                Context context = getApplicationContext();

                //TODO: Modify  if else to nested if or switch?
                if(ageText.getText().toString().equals("")) {
                    Toast.makeText(context, ageError, duration).show();
                } else if(heightText.getText().toString().equals("")){
                    Toast.makeText(context, heightError, duration).show();
                } else if(weightText.getText().toString().equals("")) {
                    Toast.makeText(context, weightError, duration).show();
                } else if(radioGenderGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(context, genderError, duration).show();
                } else {
                    //Retrieve values from editText fields and set as variables
                    age = Integer.parseInt(ageText.getText().toString());
                    activityLevel = spinnerActivitySelection.getSelectedItemPosition();
                    weight = Double.parseDouble(weightText.getText().toString());
                    height = Double.parseDouble(heightText.getText().toString());

                    //Create new person object and calculate calories used passed params
                    Person person = new Person(age, activityLevel, isMale, weight, height);
                    int mCal = person.calculateCalories();

                    //Save information to intent and pass to the results class
                    Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                    intent.putExtra("data", mCal);
                    startActivity(intent);

                }
            }
        };
        buttonCalculate.setOnClickListener(buttonCalculateListener);
    }
}
