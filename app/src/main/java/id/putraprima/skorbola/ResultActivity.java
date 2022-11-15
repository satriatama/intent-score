package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView, textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.textView3);
        textView1 = findViewById(R.id.textView4);
        Bundle extras = getIntent().getExtras();
        textView1.setText(extras.getString("scoreHome") + " - " + extras.getString("scoreAway"));
        //winner
        int scoreHome = Integer.parseInt(extras.getString("scoreHome"));
        int scoreAway = Integer.parseInt(extras.getString("scoreAway"));
        if (scoreHome > scoreAway){
            textView.setText(extras.getString("homeTeam") + " Menang");
        } else if (scoreHome < scoreAway){
            textView.setText(extras.getString("awayTeam") + " Menang");
        } else {
            textView.setText("Seri");
        }

    }
}
