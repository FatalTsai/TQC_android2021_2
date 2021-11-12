package com.tqc.gdd02;

  import java.text.DecimalFormat;

  import android.app.Activity;
  import android.content.SharedPreferences;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.TextView;

public class GDD02 extends Activity
{
  public static final String PREF_ExchangeRate = "Exchange_Rate";
  private Button calcbutton;
  private EditText fieldExchangeRate;
  private EditText fieldNTD;
  private TextView tvResult;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

   // TO DO
    fieldExchangeRate = (EditText) findViewById(R.id.etRate);
    fieldNTD = findViewById(R.id.etNTD);
    calcbutton = findViewById(R.id.btnCompute);
    tvResult = findViewById(R.id.tvResult);

    calcbutton.setOnClickListener(new View.OnClickListener() {


      @Override
      public void onClick(View view) {
        double rate = Double.parseDouble(fieldExchangeRate.getText().toString());
        double ntd = Double.parseDouble(fieldNTD.getText().toString());
        String msg = getString(R.string.usd_result) + String.format("%.2f",ntd/rate);
        tvResult.setText(msg);

      }



    });
    SharedPreferences sp = getSharedPreferences(PREF_ExchangeRate,MODE_PRIVATE);
    String strRate = sp.getString(PREF_ExchangeRate,"");
    fieldExchangeRate.setText(strRate);


  }

  protected void onPause() {
    super.onPause();
    SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, 0);
    settings.edit().putString(PREF_ExchangeRate, fieldExchangeRate.getText().toString()).commit();
  }
}
