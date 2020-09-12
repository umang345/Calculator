package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button clearButton,delButton,plusButton,minusButton,multiplyButton,divideButton,equalsButton,expoButton,decimalButton;

    public void onDecimalPressed(View view)
    {
           String current = displayTextView.getText().toString();
           if(!current.equals(""))
           {
               if(current.indexOf(".")<0) {
                   if (isSymbol(String.valueOf(current.charAt(current.length() - 1)))) {
                       if(current.length()==1)
                       {
                             current="0.";
                       }else {

                           String sub = current.substring(0, current.length() - 1);
                           sub += String.valueOf(".");
                           current = sub;
                       }
                   } else {
                       current += ".";
                   }
               }
           }
           else
           {
                 current="0.";
           }
           displayTextView.setText(current);
    }

    public void onDelPressed(View view)
    {
          String currentDisplay = displayTextView.getText().toString();
          if(!currentDisplay.equals(""))
          {
                currentDisplay=currentDisplay.substring(0,currentDisplay.length()-1);
          }
          displayTextView.setText(currentDisplay);
    }

    public void onEqualsPressed(View view)
    {
          String currentDisplay = displayTextView.getText().toString();
          if(isExpression(currentDisplay)!=-1 && (isExpression(currentDisplay)>0 && isExpression(currentDisplay)<currentDisplay.length()-1))
          {
              double eval = evaluate(currentDisplay);
              double d1 = Double.parseDouble(currentDisplay.substring(0,isExpression(currentDisplay)));
              double d2 = Double.parseDouble(currentDisplay.substring(isExpression(currentDisplay)+1));
              currentDisplay="";
              if(d2==0.0)
              {
                     currentDisplay="";
              }
              else{
                  if(d1==(int)d1 && d2 ==(int)d2 && eval==(int)eval)
                  {

                      currentDisplay+=Integer.toString((int)eval);
                  }
                  else
                  {
                      eval = Double.parseDouble(String.format("%.4f",eval));
                      currentDisplay+=Double.toString((eval));
                  }

              }
              displayTextView.setText(currentDisplay);

          }
    }

    public void onClearPressed(View view)
    {
          displayTextView.setText("");
    }

    public void onOperationClicked(View view)
    {
          String currentDisplay = displayTextView.getText().toString();
          char op = view.getTag().toString().charAt(0);
          if(currentDisplay.equals(""))
          {
               currentDisplay+=String.valueOf(op);
          }
          else if(isExpression(currentDisplay)>0 && isExpression(currentDisplay)<currentDisplay.length()-1)
          {
                double eval = evaluate(currentDisplay);
              double d1 = Double.parseDouble(currentDisplay.substring(0,isExpression(currentDisplay)));
              double d2 = Double.parseDouble(currentDisplay.substring(isExpression(currentDisplay)+1));
              currentDisplay="";
              if(d1==(int)d1 && d2 ==(int)d2 && eval==(int)eval)
              {

                  currentDisplay+=Integer.toString((int)eval);
              }
              else
              {
                  eval = Double.parseDouble(String.format("%.4f",eval));
                   currentDisplay+=Double.toString((eval));
              }
              currentDisplay+=String.valueOf(op);
          }
          else if(isSymbol(String.valueOf(currentDisplay.charAt(currentDisplay.length()-1))))
          {
                   String sub = currentDisplay.substring(0,currentDisplay.length()-1);
                   sub+=String.valueOf(op);
                   currentDisplay=sub;
          }
          else
          {
                currentDisplay+=String.valueOf(op);
          }
          displayTextView.setText(currentDisplay);
    }

    public void onNumberClicked(View view)
    {
          String currentDisplay = displayTextView.getText().toString();
          int tag = Integer.parseInt(view.getTag().toString());

          if(currentDisplay.equals("") || currentDisplay.length()>1)
          {


                    currentDisplay+=Integer.toString(tag);


          }
          else if(currentDisplay.length()==1)
          {
                 if((isSymbol(currentDisplay) && currentDisplay.charAt(0)!='-') || currentDisplay.equals("0"))
                 {
                      currentDisplay=Integer.toString(tag);
                 }
                 else
                 {
                       currentDisplay+=Integer.toString(tag);
                 }
          }

          displayTextView.setText(currentDisplay);

    }

    public void onClickButton(View view)
    {
           int id = view.getId();
           if(id==R.id.button0)
           {
                 onNumberClicked(view);

           }
           else if(id==R.id.button1)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button2)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button3)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button4)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button5)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button6)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button7)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button8)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.button9)
           {
               onNumberClicked(view);
           }
           else if(id==R.id.plusButton)
           {
                onOperationClicked(view);
           }
           else if(id==R.id.minusButton)
           {
               onOperationClicked(view);
           }
           else if(id==R.id.multiplyButton)
           {
               onOperationClicked(view);
           }
           else if(id==R.id.divideButton)
           {
               onOperationClicked(view);
           }
           else if(id==R.id.expoButton)
           {
               onOperationClicked(view);

           }
           else if(id==R.id.decimalButton)
           {
                  onDecimalPressed(view);
           }
           else if(id==R.id.equalsButton)
           {
               onEqualsPressed(view);

           }
           else if(id==R.id.delButton)
           {
                 onDelPressed(view);
           }
           else if(id==R.id.clearButton)
           {
               onClearPressed(view);

           }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();


    }

    private void initialize()
    {
          displayTextView = (TextView)findViewById(R.id.displayTextView);
          displayTextView.setText("");
          button0 = (Button)findViewById(R.id.button0);
          button1 = (Button)findViewById(R.id.button1);
          button2 = (Button)findViewById(R.id.button2);
          button3 = (Button)findViewById(R.id.button3);
          button4 = (Button)findViewById(R.id.button4);
          button5 = (Button)findViewById(R.id.button5);
          button6 = (Button)findViewById(R.id.button6);
          button7 = (Button)findViewById(R.id.button7);
          button8 = (Button)findViewById(R.id.button8);
          button9 = (Button)findViewById(R.id.button9);
          clearButton = (Button)findViewById(R.id.clearButton);
          delButton = (Button)findViewById(R.id.delButton);
          plusButton = (Button)findViewById(R.id.plusButton);
          minusButton = (Button)findViewById(R.id.minusButton);
          multiplyButton = (Button)findViewById(R.id.multiplyButton);
          divideButton = (Button)findViewById(R.id.divideButton);
          equalsButton = (Button)findViewById(R.id.equalsButton);
          expoButton = (Button)findViewById(R.id.expoButton);
          decimalButton = (Button)findViewById(R.id.decimalButton);
    }

    private boolean isSymbol(String s)
    {
          if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^") || s.equals("."))
          {
                return true;
          }
          return false;
    }

    private int isExpression(String s)
    {
          int in=-1;
          boolean flag=false;
          if(s.charAt(0)=='-')
          {
               flag=true;
          }
          if(s.length()>2)
          {

                if(s.contains("+"))
                {
                      in = s.indexOf("+");
                      if(in!=-1)
                      {
                           return in;
                      }
                }
                if(s.contains("-"))
                {
                    in = s.lastIndexOf("-");
                    if(flag==true && in==0)
                    {
                         in = -1;
                    }
                    if(in!=-1)
                    {
                          return in;
                    }


                }
                 if(s.contains("*"))
                {
                    in = s.indexOf("*");
                    if(in!=-1)
                    {
                          return in;
                    }
                }
                 if(s.contains("/"))
                {
                    in = s.indexOf("/");
                    if(in!=-1)
                    {
                         return in;
                    }
                }
                 if(s.contains("^"))
                {
                    in = s.indexOf("^");
                    if(in!=-1)
                    {
                         return in;
                    }
                }
          }
          return in;
    }

    public double evaluate(String s)
    {
        int in=-1;
        char op='+';
        boolean flag = false;
        boolean found=false;
        if(s.charAt(0)=='-')
        {
             flag=true;
        }
        if(s.length()>2)
        {

            if(s.contains("+"))
            {
                in = s.indexOf("+");
                op='+';
                found=true;
            }
            else if(s.contains("-") && !found)
            {
                in = s.lastIndexOf("-");
                if(flag)
                {
                     if(in>0)
                     {
                           found=true;
                         op='-';
                     }
                     else
                     {
                          found=false;
                     }
                }
                else
                {
                      found=true;
                    op='-';
                }


            }
             if(s.contains("*") && !found)
            {
                in = s.indexOf("*");
                op = '*';
                found=true;
            }
             if(s.contains("/") && !found)
            {
                in = s.indexOf("/");
                op = '/';
                found=true;
            }
             if(s.contains("^") && !found)
            {
                in = s.indexOf("^");
                op = '^';
            }
        }
        double d1 = Double.parseDouble(s.substring(0,in));
        double d2 = Double.parseDouble(s.substring(in+1));
        Log.i("d1 = ",Double.toString(d1));
        Log.i("d2 = ",Double.toString(d2));
        double ans = solve(d1,d2,op);
        return ans;

    }

    public double solve(double a,double b,char op)
    {

           if(op=='+')
           {
                return a+b;
           }
           if(op=='-')
           {
               return a-b;
           }
           if(op=='*')
           {
                return a*b;
           }
           if(op=='^')
           {
                 return Math.pow(a,b);
           }
           if(op=='/')
           {
                 if(b!=0)
                 {
                       return a/b;
                 }
                 else
                 {
                       displayTextView.setText("");
                     Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                 }
           }
           return 0.0;
    }
}