// Lily Liu <lliu23@stanford.edu>
// RockPaperScissors - This app allows the user to play rock, paper, scissors against the computer

package assignment1.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int computerPoints = 0;
    private int yourPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // If the rock button is pressed
    public void rockClick(View view) {
        String choice = getComputerChoice();
        ImageView img = (ImageView) findViewById(R.id.image);
        if (choice.equals("Rock")) {
            img.setImageResource(R.drawable.rock);
            changeScore(0);
        } else if (choice.equals("Paper")) {
            img.setImageResource(R.drawable.paper);
            changeScore(2);
        } else {
            img.setImageResource(R.drawable.scissors);
            changeScore(1);
        }
    }

    // If the paper button is pressed
    public void paperClick(View view) {
        String choice = getComputerChoice();
        ImageView img = (ImageView) findViewById(R.id.image);
        if (choice.equals("Rock")) {
            img.setImageResource(R.drawable.rock);
            changeScore(1);
        } else if (choice.equals("Paper")) {
            img.setImageResource(R.drawable.paper);
            changeScore(0);
        } else {
            img.setImageResource(R.drawable.scissors);
            changeScore(2);
        }
    }

    // If the scissors button is pressed
    public void scissorsClick(View view) {
        String choice = getComputerChoice();
        ImageView img = (ImageView) findViewById(R.id.image);
        if (choice.equals("Rock")) {
            img.setImageResource(R.drawable.rock);
            changeScore(2);
        } else if (choice.equals("Paper")) {
            img.setImageResource(R.drawable.paper);
            changeScore(1);
        } else {
            img.setImageResource(R.drawable.scissors);
            changeScore(0);
        }
    }

    // Generates a random choice (rock, paper, or scissors) for the computer and returns it as a string
    private String getComputerChoice() {
        Random ran = new Random();
        int choice = ran.nextInt(2);
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    private void changeScore(int result) {
        TextView message = (TextView) findViewById(R.id.message);
        TextView computerScore = (TextView) findViewById(R.id.computer_score);
        TextView yourScore = (TextView) findViewById(R.id.human_score);
        if (result == 0) {
            // Tie
            message.setText("Tie!");
        } else if (result == 1){
            // You win
            message.setText("You win!");
            yourPoints++;
            yourScore.setText("Your Score: " + yourPoints);
        } else {
            // Computer wins
            message.setText("You lose!");
            computerPoints++;
            computerScore.setText("Computer Score: " + computerPoints);
        }
    }

}
