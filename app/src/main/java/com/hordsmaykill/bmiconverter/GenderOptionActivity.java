package com.hordsmaykill.bmiconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GenderOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_option);

    }
    public void setgenderm (View ClickedButton){
        Intent activityIntent = new Intent(this, SettingsActivity.class);
        startActivity(activityIntent);
    }
    public void setgenderf (View ClickedButton){
        Intent activityIntent = new Intent(this, SettingsActivity.class);
        startActivity(activityIntent);
    }


}
