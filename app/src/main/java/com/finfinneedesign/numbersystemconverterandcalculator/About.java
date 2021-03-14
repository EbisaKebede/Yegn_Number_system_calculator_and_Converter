package com.finfinneedesign.numbersystemconverterandcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class About extends AppCompatActivity {

    LinearLayout faceboook, telegram, gmail, rate, privacyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        //Hooks

        faceboook = findViewById(R.id.facebook);
        telegram = findViewById(R.id.telegram);
        gmail = findViewById(R.id.gmail);
        rate = findViewById(R.id.rate);



        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "finfinnedesign2020@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Thank you for your feedback");
                startActivity(Intent.createChooser(intent, "Select post client"));
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMe();
            }
        });

        faceboook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebook("2119931504898858");
            }
        });

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTelegram("finfinne_design_plc");
            }
        });

    }

    private void rateMe() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +
                    this.getPackageName())));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" +
                    this.getPackageName())));
        }
    }

    private void goToFacebook(String id) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent);
        }
    }

    private void goToTelegram(String id) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("t.me//page/" + id));
            startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/" + id));
            startActivity(intent);
        }


    }

}