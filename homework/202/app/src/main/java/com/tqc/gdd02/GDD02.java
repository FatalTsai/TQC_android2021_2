package com.tqc.gdd02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GDD02 extends Activity implements View.OnClickListener
{

  Button btnSubmit;
  EditText edInputNum;
  TextView tvRespond;
  //答案
  String luckyNum;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    btnSubmit = (Button) findViewById(R.id.submit);
    edInputNum = (EditText) findViewById(R.id.input_number);
    tvRespond = (TextView) findViewById(R.id.respond);

    btnSubmit.setOnClickListener(this);
    luckyNum = generateLuckyNum();
  }

  private String generateLuckyNum(){
    int num=0;
    String strNum = "";
    do{
      num = (int) (Math.random()*1000);
      strNum = String.format("%03d",num);
    }while(isLegal(strNum)==false);
    return strNum;
  }

  //判斷輸入數字符合規則
  private boolean isLegal(String num){
      // TO DO
    if(num == null || num.length() != 3){
      return  false;
    }
    else  if(num.charAt(0) == num.charAt(1) ||
             num.charAt(1) == num.charAt(2) ||
             num.charAt(2) == num.charAt(0)){
        return  false;
    }


  return true;
  }
// TO DO
  private int  getAnum(String userNum,String luckyNum){
      int counterA = 0;
      for(int i =0;i<3;i++){
        if(userNum.charAt(i) == luckyNum.charAt(i)){
          counterA++;
        }
      }
      return  counterA;
  }

  private int getBnum(String userNum,String luckyNum){
    int counterB = 0;
    for(int i=0;i<3;i++){
      char x = userNum.charAt(i);
      int pos = luckyNum.indexOf(x);

      if(pos == -1)continue;

      if(pos!=i) counterB++;

    }
    return  counterB;
  }


  //按鈕事件
  @Override
  public void onClick(View v) {
    String userNum = edInputNum.getText().toString();
    // TO DO
    if(isLegal(userNum) == false){
      edInputNum.setText("");
      String msg = "輸入錯誤，"+this.getResources().getString(R.string.title);
      tvRespond.setText(msg);
    }
    else{
      int na = getAnum(userNum,luckyNum);
      int nb = getBnum(userNum,luckyNum);
      if(na == 3){
        String msg = String.format("INPUT的數字 : %s   恭喜你! 答對囉~ 答案:%s",userNum,luckyNum);
      }
      else{
        edInputNum.setText("");
        String msg = String.format("INPUT的數字 : %s=%dA%db",userNum,na,nb);
        tvRespond.setText(msg);
      }
    }

    }
  }

