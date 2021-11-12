package com.tqc.gdd01;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class GDD01 extends Activity
{
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   // TO DO

    CheckBox mCheck = findViewById(R.id.mCheck);
    mCheck.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                EditText mPassword = (EditText) findViewById(R.id.mPassword);
                if(isChecked){
                  mPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else {
                  mPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
              }
            });


  }
}
