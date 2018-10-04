package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Lab2 extends AppCompatActivity {

    EditText gamer;
    TextView status;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button play;
    TextView name;
    TextView winner;
    TextView myMora;
    TextView computerMora;

    int mora_gamer = -1;
    String[] MoraString = {"Scissors", "Rock", "Paper"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        gamer = (EditText) findViewById(R.id.editText);
        status = (TextView) findViewById(R.id.textView);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        play = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.textView6);
        winner = (TextView) findViewById(R.id.textView7);
        myMora = (TextView) findViewById(R.id.textView8);
        computerMora = (TextView) findViewById(R.id.textView9) ;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        mora_gamer = 0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer = 1;
                        break;
                    case R.id.radioButton3:
                        mora_gamer = 2;
                        break;
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (gamer.getText().toString().equals(""))
                        status.setText("Please enter your name to start the game");
                    else if (mora_gamer == -1)
                        status.setText("Please select your choice");
                    else {
                        name.setText(gamer.getText());
                        myMora.setText(MoraString[mora_gamer]);
                        int mora_computer = (int) (Math.random() * 3);
                        computerMora.setText(MoraString[mora_computer]);
                        if ((mora_gamer == 0 && mora_computer == 1) ||
                                (mora_gamer == 1 && mora_computer == 2) || (mora_gamer == 2 && mora_computer == 0)) {
                            winner.setText("Computer");
                            status.setText("You lost");
                        } else if (mora_computer == mora_gamer) {
                            winner.setText("Draw");
                            status.setText("Draw! Try another round");
                        } else {
                            winner.setText(gamer.getText());
                            status.setText("You won");
                        }
                    }
                }
            }
        });
    }
}
