package com.hordsmaykill.bmiconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {


    EditText tbheight;
    EditText tbweigth;
    EditText tbdweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        tbheight = (EditText) findViewById(R.id.tbheight);
        tbweigth = (EditText) findViewById(R.id.tbweight);
        tbdweight = (EditText) findViewById(R.id.tbdweight);
    }
    public void backtogenderoption (View ClickedButton){
        Intent activityIntent = new Intent(this, GenderOptionActivity.class);
        startActivity(activityIntent);
    }
    public void convertBmi(View ClickedButton){


        double tbheightt = Double.parseDouble(tbheight.getText().toString());
        double tbweigthh = Double.parseDouble(tbweigth.getText().toString());
        double tbdweigthh = Double.parseDouble(tbdweight.getText().toString());

        double CmtoM = tbheightt /100;
        double bmi = tbweigthh /(CmtoM * CmtoM);

        startActivity(MainActivity.getStartIntent(this, bmi, tbweigthh, tbdweigthh));


    }
}
