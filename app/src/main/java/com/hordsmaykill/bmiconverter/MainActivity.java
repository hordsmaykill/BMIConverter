package com.hordsmaykill.bmiconverter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_BMI = "EXTRA_BMI";
    public static final String EXTRA_CW = "EXTRA_CUREENTWEIGHT";
    public static final String EXTRA_DW = "EXTRA_DESIREDWEIGHT";
    TextView tvbmi;
    TextView tvcurrentweight;
    TextView tbdesiredweight;
    TextView bmifinal;
    TextView tvdiff;

    public static Intent getStartIntent(Context context, double bmi, double tbweigthh, double tbdweigthh) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_BMI, bmi);
        intent.putExtra(EXTRA_CW, tbweigthh);
        intent.putExtra(EXTRA_DW, tbdweigthh);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvbmi = (TextView) findViewById(R.id.tvbmi);
        tvcurrentweight = (TextView) findViewById(R.id.tvcurrentweight);
        tbdesiredweight = (TextView) findViewById(R.id.tbdesiredweight);
        bmifinal = (TextView) findViewById(R.id.bmifinal);
        tvdiff= (TextView) findViewById(R.id.tvdiff);



        double bmi = getIntent().getDoubleExtra(EXTRA_BMI, 0);
        double tbweigthh = getIntent().getDoubleExtra(EXTRA_CW, 0);
        double tbdweigthh = getIntent().getDoubleExtra(EXTRA_DW, 0);
        double differenceinweigth = tbweigthh - tbdweigthh;


        String out = String.format(Locale.getDefault(), "%.2f", bmi);
        tvbmi.setText(""+ out);
        tvcurrentweight.setText(""+ tbweigthh);
        tbdesiredweight.setText(""+ tbdweigthh);
        tvdiff.setText(""+differenceinweigth);

        if(bmi < 18.5){
            bmifinal.setText("Underweight");
        }
        else if(bmi >= 18.5 && bmi <= 24.9 ){
            bmifinal.setText("Normal weight");
        }
        else if(bmi >= 25 && bmi <= 29.9 ){
            bmifinal.setText("Overweight ");
        }
        else if(bmi >= 30){
                bmifinal.setText("Obesity");
            }

    }

    public void backtogenderoption (View ClickedButton){
        Intent activityIntent = new Intent(this, SettingsActivity.class);
        startActivity(activityIntent);
    }
    public void backtoabout (View ClickedButton){
        Intent activityIntent = new Intent(this, AboutActivity.class);
        startActivity(activityIntent);
    }

}
