package com.finfinneedesign.numbersystemconverterandcalculator;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AdsManager
{


    private static InterstitialAd interstitialAd;
    private Context ctx;
    public AdsManager(Context ctx)
    {
        this.ctx = ctx;
        MobileAds.initialize(ctx, new OnInitializationCompleteListener()
        {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus)
            {

            }
        });
    }
    public InterstitialAd createInterstitialAds()
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd =new InterstitialAd(ctx);
        interstitialAd.setAdUnitId("ca-app-pub-9464104790853930/2191658654");
        interstitialAd.loadAd(adRequest);
        return  interstitialAd;
    }
    public InterstitialAd getInterstitialAd()
    {
        return  interstitialAd;
    }

    public void createAds(AdView adview)
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        adview.setAdListener(new AdListener()
        {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError)
            {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdLoaded()
            {
                super.onAdLoaded();
            }
        });
        adview.loadAd(adRequest);
    }
}