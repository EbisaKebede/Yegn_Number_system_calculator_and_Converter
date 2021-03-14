package com.finfinneedesign.numbersystemconverterandcalculator;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Launcher extends AppCompatActivity {
    private Vibrator myVib;
    private AdView mAdViewTop;
    private AdView mAdViewBottom;
    private AdsManager adsManager;




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



    private static int SPLASH_TIMER = 2000;
    private long backPressedTime;
    AlertDialog dialogSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        adsManager = new AdsManager(getApplicationContext());
        final InterstitialAd inter = adsManager.createInterstitialAds();

        mAdViewTop  = findViewById(R.id.adView);
        mAdViewBottom  = findViewById(R.id.adView2);

        AdsManager adsManagerB =  new AdsManager(this);
        adsManager.createAds(mAdViewTop);

        AdsManager adsManager =  new AdsManager(this);
        adsManager.createAds(mAdViewBottom);


        InterstitialAd ad =  adsManagerB.getInterstitialAd();
        if (ad != null){
            if (ad.isLoaded()){
                ad.show();
            }
        }



        InterstitialAd adTop =  adsManager.getInterstitialAd();
        if (ad != null){
            if (ad.isLoaded()){
                ad.show();
            }
        }





    }

    public void openConverter(View view) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);



    }

    public void openCalculator(View view) {

            Intent i = new Intent(this, Calculator.class);
            startActivity(i);


    }


    public void openChart(View view) {
        Intent i = new Intent(this, Chart.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            back();
        } else {
            backPressedTime = System.currentTimeMillis();
            back();
        }


    }

    private void back() {
        if (dialogSetting == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Launcher.this);
            View view = LayoutInflater.from(this).inflate(
                    R.layout.backpressed, (ViewGroup) findViewById(R.id.backContainer)
            );
            builder.setView(view);
            dialogSetting = builder.create();
            if (dialogSetting.getWindow() != null) {
                dialogSetting.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            view.findViewById(R.id.ok2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Launcher.super.onBackPressed();
                }
            });
            view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogSetting.dismiss();
                }
            });


        }
        dialogSetting.show();
    }
}