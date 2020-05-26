package com.example.carrompointer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int flag=1;
    int score_a=0;
    int score_b=0;
    int temp=0;
    int undo_a=0;
    int undo_b=0;
    String winner="";

    /**
     * method to reset the match score
     */
    public void reset(View view){
        undo_a=score_a;
        undo_b=score_b;
        score_a=0;
        score_b=0;
        temp=0;
        flag=1;
        displayTemp(temp);
        display_a(score_a);
        display_b(score_b);
        dis_res("");
    }
    /**
     *  method to display score of team a
     */
    public void display_a(int num){
        TextView obj= (TextView) findViewById(R.id.scoreA);
        obj.setText(""+num);
    }
    /**
     *  method to display score of team b
     */
    public void display_b(int num){
        TextView obj= (TextView) findViewById(R.id.scoreB);
        obj.setText(""+num);
    }
    /**
     * method of undo
     */
    public void undo(View v){
        score_a=undo_a;
        score_b=undo_b;
        display_a(score_a);
        display_b(score_b);
        if(score_b>28||score_a>28){
            flag=0;
        }
        else flag=1;
        if(flag!=0){
            winner="";
        }
        dis_res(winner);
        if(score_a>28||score_b>28){
            flag=0;
        }
        else flag=1;
    }
    /**
     * increment of temp section
     */
    public void tempPlus(View v){
        if(temp!=14&&flag==1){
            temp++;
        }
        displayTemp(temp);
    }
    /**
     * decrement of temp section
     */
    public void tempMinus(View v){
        if(temp!=0&&flag==1){
            temp--;
        }
        displayTemp(temp);
    }
    /**
     * method to display temp
     */
    public void displayTemp(int n){
        TextView obj = (TextView) findViewById(R.id.temp_score);
        obj.setText(""+temp);
    }
    /**
     * method to add point to team A
     */
    public void wonA(View view){
        if(temp!=0) {
            undo_a = score_a;
            undo_b = score_b;
            score_a = score_a + temp;
            temp = 0;
            displayTemp(temp);
            display_a(score_a);
            if (score_a >= 29) {
                winner = "Team A";
                dis_res(winner);
                flag = 0;
            }
        }
    }
    /**
     * method to add point to team B
     */
    public void wonB(View view){
        if(temp!=0){
            undo_a=score_a;
            undo_b=score_b;
            score_b=score_b+temp;
            temp=0;
            displayTemp(temp);
            display_b(score_b);
            if(score_b>=29){
                winner="Team B";
                dis_res(winner);
                flag=0;
            }
        }
    }
    /**
     *  method to show result
     */
    public void dis_res(String Str){
        TextView obj= (TextView) findViewById(R.id.result);
        if(Str==""){
            String s="RESULT WILL BE DISPLAYED HERE";
            obj.setText(s);
        }
        else{
            String s="\t\t\t\t"+Str+" won the match! \n\n Press reset to Start new game";
            obj.setText(s);
        }

    }

}
