package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * computes result of selected radio buttons and store in count
     *
     * @return score
     */
    public int getOverallScore() {

        int count ;

        RadioButton quiz1Radio1 = (RadioButton) findViewById(R.id.quiz1_radio1);
        boolean isquiz1radio1 = quiz1Radio1.isChecked();

        RadioButton quiz2Radio2 = (RadioButton) findViewById(R.id.quiz2_radio2);
        boolean isquiz2radio2 = quiz2Radio2.isChecked();
        RadioButton quiz3Radio2 = (RadioButton) findViewById(R.id.quiz3_radio2);
        boolean isquiz3radio2 = quiz3Radio2.isChecked();
        RadioButton quiz4Radio3 = (RadioButton) findViewById(R.id.quiz4_radio3);
        boolean isquiz4radio3 = quiz4Radio3.isChecked();
        RadioButton quiz5Radio3 = (RadioButton) findViewById(R.id.quiz5_radio3);
        boolean isquiz5radio3 = quiz5Radio3.isChecked();
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.quiz6Checkbox1);
        boolean isBradley = checkbox1.isChecked();
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.quiz6Checkbox2);
        boolean isConnor = checkbox2.isChecked();
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.quiz6Checkbox3);
        boolean isTristan = checkbox3.isChecked();
        CheckBox checkbox4 = (CheckBox) findViewById(R.id.quiz6Checkbox4);
        boolean isJames = checkbox4.isChecked();

        EditText answerEditText = (EditText) findViewById(R.id.answer_text);
        String answer = answerEditText.getText().toString().trim();
        count = 0;

        if (isquiz1radio1) {
            count++;
        }

        if (isquiz2radio2) {
            count++;
        }

        if (isquiz3radio2) {
            count++;
        }

        if (isquiz4radio3) {
            count++;
        }

        if (isquiz5radio3) {
            count++;
        }
        if (isBradley && isConnor && isTristan && isJames) {
            count++;
        }

        if (answer.equalsIgnoreCase("Abuja")) {
            count++;
        }

        return count;

    }

    /**
     * This method get the appropriate rating based on score
     *
     * @param score from previous method
     * @return result
     */
    private String getResult(int score) {

        String result = "";

        if (score <= 3) {
            result = getString(R.string.poor);
        } else if (score <= 6) {
            result = getString(R.string.good);
        } else if (score >= 7) {
            result = getString(R.string.excellent);
        }
        return result;
    }

    /**
     * display result when button is clicked
     *
     * @param v ...
     */
    public void submitResult(View v) {

        int score = getOverallScore();
        String rating = getResult(score);

        String result = "Your score is " + score + " out of 7" + "\n" + rating;
        Toast.makeText(this, result, Toast.LENGTH_LONG).show(); // print the value of selected super star
        count = 0;
    }
}
