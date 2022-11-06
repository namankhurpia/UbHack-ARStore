package com.namankhurpia.arstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    ImageButton speechtotextbtn;
    TextView text_output_after_speech;

    ImageButton profile;
    ImageButton solar, magneticfieldlines, photosynthesis;
    TextView myapps, trendingapps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        speechtotextbtn = (ImageButton) findViewById(R.id.speechtotextbtn);
        text_output_after_speech = (TextView)findViewById(R.id.textoutput);
        profile = (ImageButton)findViewById(R.id.profile);

        solar = (ImageButton)findViewById(R.id.solar);
        magneticfieldlines = (ImageButton)findViewById(R.id.magf);
        photosynthesis = (ImageButton)findViewById(R.id.photosy);

        trendingapps = (TextView)findViewById(R.id.tredingapps);
        myapps = (TextView)findViewById(R.id.myapps);

        text_output_after_speech.setText("Go head, say something \nlike Plants, Magnetic field lines, horse");
        speechtotextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });

        solar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.Myproject");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
            }
        });

        photosynthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.plants");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
                else
                {
                    Log.d("Tag","intent is null in plants");
                }
            }
        });

        magneticfieldlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.magneticflief");
                if (launchIntent != null) {

                    startActivity(launchIntent);
                }
                else
                {
                    Log.d("Tag","intent is null");
                }
            }
        });

        trendingapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, StoreActivity.class));
            }
        });

    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "say something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry your device doesnt support speech recognition",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String s2 = result.get(0);
                    Log.d("TAG","i got:"+s2+".");

                    if (s2.equalsIgnoreCase("magnetic field lines") || s2.equalsIgnoreCase("magnetic lines") || s2.equalsIgnoreCase("magnetic field") ||s2.equalsIgnoreCase("magnetic") || s2.equalsIgnoreCase("magnet"))
                    {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.magneticflief");
                        if (launchIntent != null) {

                            startActivity(launchIntent);
                        }
                        else
                        {
                            Log.d("Tag","intent is null");
                        }

                    }

                    else if (s2.equalsIgnoreCase("solar") || s2.equalsIgnoreCase("solar system") || s2.equalsIgnoreCase("moon") || s2.equalsIgnoreCase("earth") || s2.equalsIgnoreCase("sun") )  {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.Myproject");
                        if (launchIntent != null) {
                            startActivity(launchIntent);
                        }

                    }
                    else if(s2.equalsIgnoreCase("horse"))
                    {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.horse");
                        if (launchIntent != null) {
                            startActivity(launchIntent);
                        }

                    }

                    else if (s2.equalsIgnoreCase("photosynthesis") || s2.equalsIgnoreCase("plants"))
                    {
                        Log.d("TAG","plants run");
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.plants");
                        if (launchIntent != null) {
                            startActivity(launchIntent);
                        }
                        else
                        {
                            Log.d("Tag","intent is null in plants");
                        }
                    }
                    else
                    {
                        text_output_after_speech.setText("I m sorry i don't understand");
                    }
                }

                //
            }
            break;
            /*case 200:
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String res = result.get(0);
                    if(res.equalsIgnoreCase("horse"))
                    {

                    }

                }
                break;

*/
        }

    }
}