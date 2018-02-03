package com.example.android.budapestquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * If the return value for answer check is true, adds one point. If it's incorrect, no point is added.
     */
    public void checkAnswers(View view){
        int result = 0;

        if (checkRadioButtonAnswer(R.id.first_answer, R.id.first_answer3)){
            result = result + 1;
        }

        if (checkTextViewAnswer(R.id.second_answer, "lions")){
            result = result + 1;
        }

        if (checkRadioButtonAnswer(R.id.third_answer, R.id.third_answer1)){
            result = result + 1;
        }

        if (checkRadioButtonAnswer(R.id.fourth_answer, R.id.fourth_answer3)){
            result = result + 1;
        }

        if (checkRadioButtonAnswer(R.id.fifth_answer, R.id.fifth_answer3)){
            result = result + 1;
        }

        if (checkRadioButtonAnswer(R.id.sixth_answer, R.id.sixth_answer2)){
            result = result + 1;
        }

        if (checkCheckBoxAnswer(R.id.seventh_answer1, true) &&
                checkCheckBoxAnswer(R.id.seventh_answer2, true) &&
                checkCheckBoxAnswer(R.id.seventh_answer3, true) &&
                checkCheckBoxAnswer(R.id.seventh_answer4, false)){
            result = result + 1;
        }

        /**
         * A toast message is shown which represents the scored points out of the total 7.
         */
        Toast.makeText(this, "Result: " + Integer.toString(result) + "/7", Toast.LENGTH_SHORT).show();
    }

    /**
     *
     Checks radio button type answers and compares them with the correct answer. Returns true or false (if correct or not).
     */
    private boolean checkRadioButtonAnswer(int resourceIdRadioButtonGroup, int resourceIdCorrectRadioButton){
        RadioGroup group = findViewById(resourceIdRadioButtonGroup);
        return group.getCheckedRadioButtonId() == resourceIdCorrectRadioButton;
    }

    /**
     *
     Checks EditText type answers and compares them with the correct answer. Returns true or false (if correct or not).
     */
    private boolean checkTextViewAnswer(int resourceId, String correctAnswer){
        TextView textView = findViewById(resourceId);
        return textView.getText().toString().equals(correctAnswer);
    }


    /**
     *
     Checks checkbox type answers and compares them with the correct answer. Returns true or false (if correct or not).
     */
    private boolean checkCheckBoxAnswer(int resourceId, boolean correctAnswer){
        CheckBox answerOption = findViewById(resourceId);
        return answerOption.isChecked() == correctAnswer;
    }
}
