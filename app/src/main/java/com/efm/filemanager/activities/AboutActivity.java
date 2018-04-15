package com.efm.filemanager.activities;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.efm.filemanager.R;
import com.efm.filemanager.activities.superclasses.BasicActivity;
import com.efm.filemanager.utils.Utils;
import com.efm.filemanager.utils.theme.AppTheme;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;

/**
 * Created by vishal on 27/7/16.
 */
public class AboutActivity extends BasicActivity implements View.OnClickListener {

    private static final String TAG = "AboutActivity";

    private static final int HEADER_HEIGHT = 1024;
    private static final int HEADER_WIDTH = 500;

    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private TextView mTitleTextView;
    private int mCount=0;
    private Snackbar snackbar;
    private SharedPreferences mSharedPref;

    private static final String KEY_PREF_STUDIO = "studio";
    //satochi2017
    private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getAppTheme().equals(AppTheme.DARK)) {
            setTheme(R.style.aboutDark);
        } else if (getAppTheme().equals(AppTheme.BLACK)) {
            setTheme(R.style.aboutBlack);
        } else {
            setTheme(R.style.aboutLight);
        }

        setContentView(R.layout.activity_about);

        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        mAppBarLayout = findViewById(R.id.appBarLayout);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        mTitleTextView =  findViewById(R.id.text_view_title);

        mAppBarLayout.setLayoutParams(calculateHeaderViewParams());

        Toolbar mToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.md_nav_back));
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.about_header);

        // It will generate colors based on the image in an AsyncTask.
        Palette.from(bitmap).generate(palette -> {
            int mutedColor = palette.getMutedColor(Utils.getColor(AboutActivity.this, R.color.primary_blue));
            int darkMutedColor = palette.getDarkMutedColor(Utils.getColor(AboutActivity.this, R.color.primary_blue));
            mCollapsingToolbarLayout.setContentScrimColor(mutedColor);
            mCollapsingToolbarLayout.setStatusBarScrimColor(darkMutedColor);
        });

        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            mTitleTextView.setAlpha(Math.abs(verticalOffset / (float) appBarLayout.getTotalScrollRange()));
        });

        //satochi2017
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        //MobileAds.initialize(this, getString(R.string.admobAppId));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Calculates aspect ratio for the efm header
     * @return the layout params with new set of width and height attribute
     */
    private CoordinatorLayout.LayoutParams calculateHeaderViewParams() {

        // calculating cardview height as per the youtube video thumb aspect ratio
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mAppBarLayout.getLayoutParams();
        float vidAspectRatio = (float) HEADER_WIDTH / (float) HEADER_HEIGHT;
        Log.d(TAG, vidAspectRatio + "");
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        float reqHeightAsPerAspectRatio = (float) screenWidth *vidAspectRatio;
        Log.d(TAG, reqHeightAsPerAspectRatio + "");


        Log.d(TAG, "new width: " + screenWidth + " and height: " + reqHeightAsPerAspectRatio);

        layoutParams.width = screenWidth;
        layoutParams.height = (int) reqHeightAsPerAspectRatio;
        return layoutParams;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relative_layout_version:
                mCount++;
                if (mCount >= 5) {
                    String text = getResources().getString(R.string.easter_egg_title) + " : " + mCount;

                    if(snackbar != null && snackbar.isShown()) {
                        snackbar.setText(text);
                    } else {
                        snackbar = Snackbar.make(v, text, Snackbar.LENGTH_SHORT);
                    }

                    snackbar.show();
                    mSharedPref.edit().putInt(KEY_PREF_STUDIO, Integer.parseInt(Integer.toString(mCount) + "000")).apply();
                } else {
                    mSharedPref.edit().putInt(KEY_PREF_STUDIO, 0).apply();
                }
                break;
        }
    }
}
