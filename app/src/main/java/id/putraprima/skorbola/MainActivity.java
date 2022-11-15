package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button buttonTeam;

    // One Preview Image
    ImageView awayLogo, homeLogo;
    Uri imagesUri, imagesUri1;

    // constant to compare
    // the activity result code
    final int ACTIVITY1 = 200;
    final int ACTIVITY2 = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText homeTeam = findViewById(R.id.home_team);
        final EditText awayTeam = findViewById(R.id.away_team);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        buttonTeam = findViewById(R.id.btn_team);
        //Fitur Main Activity

        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team dari galeri
        homeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();

            }
        });

        //4. Ganti Logo Away Team
        awayLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser1();
            }
        });
        //5. Next Button Pindah Ke MatchActivity

        buttonTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeTeam.getText().toString().isEmpty()) {
                    homeTeam.setError("Home Team is Required");
                } else if (awayTeam.getText().toString().isEmpty()) {
                    awayTeam.setError("Away Team is Required");
                } else {
                    Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                    intent.putExtra("homeTeam", homeTeam.getText().toString());
                    intent.putExtra("awayTeam", awayTeam.getText().toString());
                    intent.putExtra("homeLogo", imagesUri1.toString());
                    intent.putExtra("awayLogo", imagesUri.toString());
                    startActivity(intent);
                }
            }
        });
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), ACTIVITY1);
    }
    void imageChooser1() {

        // create an instance of the
        // intent of the type image
        Intent j = new Intent();
        j.setType("image/*");
        j.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(j, "Select Picture"), ACTIVITY2);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    // and returns the image to the imageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // compare the resultCode with the
        // SELECT_PICTURE constant
        switch (requestCode) {
            case ACTIVITY1:
                if (resultCode == RESULT_OK) {
                    // Get the url from data
                    Uri selectedImageUri1 = data.getData();
                    imagesUri1 = selectedImageUri1;
                    if (null != selectedImageUri1) {
                        // Set the image in ImageView
                        homeLogo.setImageURI(selectedImageUri1);
                    }
                }
                break;
            case ACTIVITY2:
                if (resultCode == RESULT_OK) {
                    // Get the url from data
                    Uri selectedImageUri = data.getData();
                    imagesUri = selectedImageUri;
                    if (null != selectedImageUri) {
                        // Set the image in ImageView
                        awayLogo.setImageURI(selectedImageUri);
                    }
                }
                break;
        }
    }
}