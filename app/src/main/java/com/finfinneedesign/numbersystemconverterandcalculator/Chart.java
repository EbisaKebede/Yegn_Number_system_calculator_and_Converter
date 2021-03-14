package com.finfinneedesign.numbersystemconverterandcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Chart extends AppCompatActivity {
    private  AdsManager adsManager;
    private AdView mAdView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                finish();
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey Check out this cool Binary, Decimal, Hexadecimal and Octal number system converter at: http://onelink.to/2g4u7w  ";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.rate:
                rateMe();
                break;
            case R.id.about:
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
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






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        mAdView  = findViewById(R.id.adView);

        AdsManager adsManager =  new AdsManager(this);
        adsManager.createAds(mAdView);

        InterstitialAd ad =  adsManager.getInterstitialAd();
        if (ad != null){
            if (ad.isLoaded()){
                ad.show();
            }
        }
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }
}