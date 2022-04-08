package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText inputvalue;
    TextView resultviewCM;
    TextView resultviewFoot;
    TextView resultviewInch;
    TextView resultviewGram;
    TextView resultviewOunceOZ;
    TextView resultviewPoundIb;
    TextView resultviewFH;
    TextView resultviewKelvin;
    Integer choice;


    private Spinner spinner;
    private static final String[] paths = {"Metre", "Celsius", "Kilograms"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Dropdown Menu
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //
        // Allowing me to access
        inputvalue = findViewById(R.id.inputvalue);
        resultviewCM = findViewById(R.id.resultviewCM);
        resultviewFoot = findViewById(R.id.resultviewFoot);
        resultviewInch = findViewById(R.id.resultviewInch);
        resultviewGram = findViewById(R.id.resultviewGram);
        resultviewOunceOZ = findViewById(R.id.resultviewOunceOZ);
        resultviewPoundIb = findViewById(R.id.resultviewPoundIb);
        resultviewFH = findViewById(R.id.resultviewFH);
        resultviewKelvin = findViewById(R.id.resultviewKelvin);
        //
    }

    public void temperature(View view){
        if(choice != 1) {
            for (TextView textView : Arrays.asList(resultviewCM, resultviewFoot, resultviewInch, resultviewGram, resultviewOunceOZ, resultviewPoundIb, resultviewFH, resultviewKelvin))
                textView.setText("Please select the correct conversion icon");
            return;
        }
        double resultFH = Double.parseDouble(inputvalue.getText().toString())*2+30; // *2+30 is formula to get FH
        double resultKV = Double.parseDouble(inputvalue.getText().toString())+273.15;
        //Rounding to 2 Decimal places
        BigDecimal resultFH2 = new BigDecimal(resultFH).setScale(2, RoundingMode.HALF_UP);
        double resultFH2D = resultFH2.doubleValue();

        BigDecimal resultKV2 = new BigDecimal(resultKV).setScale(2, RoundingMode.HALF_UP);
        double resultKV2D = resultKV2.doubleValue();
        //
        resultviewFH.setText(Double.toString(resultFH2D)+" Fahrenheit");
        resultviewKelvin.setText(Double.toString(resultKV2D)+" Kelvin");
    }
    public void weight(View view){
        if(choice != 2){
            for (TextView textView : Arrays.asList(resultviewCM, resultviewFoot, resultviewInch, resultviewGram, resultviewOunceOZ, resultviewPoundIb, resultviewFH, resultviewKelvin))
                textView.setText("Please select the correct conversion icon");
            return;
        }
        double resultG = Double.parseDouble(inputvalue.getText().toString())*1000;
        double resultO = Double.parseDouble(inputvalue.getText().toString())*35.27396195;
        double resultP = Double.parseDouble(inputvalue.getText().toString())*2.20462262185;
        //Rounding to 2 Decimal places
        BigDecimal resultG2 = new BigDecimal(resultG).setScale(2, RoundingMode.HALF_UP);
        double resultG2D = resultG2.doubleValue();

        BigDecimal resultO2 = new BigDecimal(resultO).setScale(2, RoundingMode.HALF_UP);
        double resultO2D = resultO2.doubleValue();

        BigDecimal resultP2 = new BigDecimal(resultP).setScale(2, RoundingMode.HALF_UP);
        double resultP2D = resultP2.doubleValue();
        //
        resultviewGram.setText(Double.toString(resultG2D)+" Gram");
        resultviewOunceOZ.setText(Double.toString(resultO2D)+" Ounce(Oz)");
        resultviewPoundIb.setText(Double.toString(resultP2D)+" Pound(Ib)");
    }
    public void measurement(View view){
        if(choice != 0){
            for (TextView textView : Arrays.asList(resultviewCM, resultviewFoot, resultviewInch, resultviewGram, resultviewOunceOZ, resultviewPoundIb, resultviewFH, resultviewKelvin))
                textView.setText("Please select the correct conversion icon");
            return;
        }
        double resultCM = Double.parseDouble(inputvalue.getText().toString())*100;
        double resultF = Double.parseDouble(inputvalue.getText().toString())*3.280839895;
        double resultIn = Double.parseDouble(inputvalue.getText().toString())*39.37007874;
        //Rounding to 2 Decimal places
        BigDecimal resultCM2 = new BigDecimal(resultCM).setScale(2, RoundingMode.HALF_UP);
        double resultCM2D = resultCM2.doubleValue();

        BigDecimal resultF2 = new BigDecimal(resultF).setScale(2, RoundingMode.HALF_UP);
        double resultF2D = resultF2.doubleValue();

        BigDecimal resultIn2 = new BigDecimal(resultIn).setScale(2, RoundingMode.HALF_UP);
        double resultIn2D = resultIn2.doubleValue();
        //
        resultviewCM.setText(Double.toString(resultCM2D)+" Centimetre");
        resultviewFoot.setText(Double.toString(resultF2D)+" Foot");
        resultviewInch.setText(Double.toString(resultIn2D)+" Inch");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0: //Metre Conversion
                resultviewCM.setVisibility(View.VISIBLE);
                resultviewFoot.setVisibility(View.VISIBLE);
                resultviewInch.setVisibility(View.VISIBLE);
                //
                resultviewGram.setVisibility(View.INVISIBLE);
                resultviewOunceOZ.setVisibility(View.INVISIBLE);
                resultviewPoundIb.setVisibility(View.INVISIBLE);
                resultviewFH.setVisibility(View.INVISIBLE);
                resultviewKelvin.setVisibility(View.INVISIBLE);
                //
                choice = 0;
                break;
            case 1: // Temperature Conversion
                resultviewFH.setVisibility(View.VISIBLE);
                resultviewKelvin.setVisibility(View.VISIBLE);
                //
                resultviewCM.setVisibility(View.INVISIBLE);
                resultviewFoot.setVisibility(View.INVISIBLE);
                resultviewInch.setVisibility(View.INVISIBLE);
                resultviewGram.setVisibility(View.INVISIBLE);
                resultviewOunceOZ.setVisibility(View.INVISIBLE);
                resultviewPoundIb.setVisibility(View.INVISIBLE);
                //
                choice = 1;
                break;
            case 2: // Weight Conversion
                resultviewGram.setVisibility(View.VISIBLE);
                resultviewOunceOZ.setVisibility(View.VISIBLE);
                resultviewPoundIb.setVisibility(View.VISIBLE);
                //
                resultviewCM.setVisibility(View.INVISIBLE);
                resultviewFoot.setVisibility(View.INVISIBLE);
                resultviewInch.setVisibility(View.INVISIBLE);
                resultviewFH.setVisibility(View.INVISIBLE);
                resultviewKelvin.setVisibility(View.INVISIBLE);
                //
                choice = 2;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    // Nothing happens
    }

}