package com.example.caloriecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    //Create calories variables
    private int maintenanceCal;
    private int mildWeightLossCal;
    private int weightLossCal;
    private int extremeWeightLossCal;

    //Create field objects
    private TextView mCalText;
    private TextView mildLossCalText;
    private TextView lossCalText;
    private TextView extremeLossCalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Get data passed from the main activity class
        Bundle bundle = getIntent().getExtras();
        maintenanceCal = bundle.getInt("data");

        //Init text to be filled in
        mCalText = (TextView) findViewById(R.id.textViewMaintainValue);
        mildLossCalText = (TextView) findViewById(R.id.textViewMildLossValue);
        lossCalText = (TextView) findViewById(R.id.textViewLossValue);
        extremeLossCalText = (TextView) findViewById(R.id.textViewExtremeLossValue);

        //Calculate values and then set them in the respective fields
        populateTextFields(maintenanceCal,
                calculatePercentage(maintenanceCal, 0.9),
                calculatePercentage(maintenanceCal, 0.8),
                calculatePercentage(maintenanceCal, 0.66));

    }

    //Calculate calorie percentage
    private int calculatePercentage(int x, double percentage) {
        double d = x;
        d *= percentage;
        int result = (int) Math.round(d);

        return result;
    }

    //Populate text fields
    private void populateTextFields(int field1, int field2, int field3, int field4) {
        mCalText.setText(Integer.toString(field1));
        mildLossCalText.setText(Integer.toString(field2));
        lossCalText.setText(Integer.toString(field3));
        extremeLossCalText.setText(Integer.toString(field4));
    }

}
