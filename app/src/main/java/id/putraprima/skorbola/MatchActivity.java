package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    ImageView homeLogo, awayLogo;
    TextView scoreHome, scoreAway, txt_home, txt_away;
    Button btnHome, btnAway, btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        homeLogo = findViewById(R.id.home_logo1);
        awayLogo = findViewById(R.id.away_logo1);
        btnHome = findViewById(R.id.btn_add_home);
        btnAway = findViewById(R.id.btn_add_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        txt_home = findViewById(R.id.txt_home);
        txt_away = findViewById(R.id.txt_away);
        btnResult = findViewById(R.id.btn_result);
        //1. Tampilkan Logo Home Team dan Away Team
        Bundle extras = getIntent().getExtras();
        final Uri myUri = Uri.parse(extras.getString("homeLogo"));
        homeLogo.setImageURI(myUri);
        final Uri myUri1 = Uri.parse(extras.getString("awayLogo"));
        awayLogo.setImageURI(myUri1);
        //ganti nama team
        txt_home.setText(extras.getString("homeTeam"));
        txt_away.setText(extras.getString("awayTeam"));
        //2. Tambahkan Skor Home Team
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                String score = scoreHome.getText().toString();
                int score1 = Integer.parseInt(score);
                score1 = score1 + 1;
                scoreHome.setText(String.valueOf(score1));
            }
        });
        //3. Tambahkan Skor Away Team
        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                String score = scoreAway.getText().toString();
                int score1 = Integer.parseInt(score);
                score1 = score1 + 1;
                scoreAway.setText(String.valueOf(score1));
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("scoreHome", scoreHome.getText().toString());
                intent.putExtra("scoreAway", scoreAway.getText().toString());
                intent.putExtra("homeTeam", txt_home.getText().toString());
                intent.putExtra("awayTeam", txt_away.getText().toString());
                intent.putExtra("homeLogo", myUri.toString());
                intent.putExtra("awayLogo", myUri1.toString());
                startActivity(intent);
            }
        });

        }
}