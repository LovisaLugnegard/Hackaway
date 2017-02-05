package com.isisochbast.hackaway;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class City extends AppCompatActivity {

    String mCity;
    TextView mToWebTextView;
    TextView mMultipleTripsTextView;
    TextView mSingleTripTextView;
    TextView mWelcomeTextView;
    ImageView mLogoImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        mCity = getIntent().getStringExtra(EXTRA_MESSAGE);

        mWelcomeTextView = (TextView) findViewById(R.id.welcomTextView);
        mToWebTextView = (TextView) findViewById(R.id.toWebsite);
        mSingleTripTextView =(TextView) findViewById(R.id.singleTextView);
        mMultipleTripsTextView = (TextView) findViewById(R.id.multipleTripsTextView);
        mLogoImageView = (ImageView)findViewById(R.id.logoImageView);

        if(mCity.equals("Stockholm")){


            mWelcomeTextView.setText(R.string.welcomeSthlm);
            mToWebTextView.setText(R.string.SLhemsida);
            mSingleTripTextView.setText(R.string.singletripsSL);
            mMultipleTripsTextView.setText(R.string.threetrips);
            mLogoImageView.setImageResource(R.drawable.sl);





            /*Spannable spannedText = (Spannable)
                    Html.fromHtml(value);
            singleTripSL.setMovementMethod(LinkMovementMethod.getInstance());*/

            // Spannable processedText = removeUnderlines(spannedText);
            // singleTripSL.setText(processedText);


        /*    mMultipleTripsTextView.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(City.this, moreInfo.class);
                    String message = "Stockholm";
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);

                }
            }); */
        }

        else if(mCity.equals("Göteborg")){

            mWelcomeTextView.setText(R.string.welcomeGbg);
            mToWebTextView.setText(R.string.VThemsida);
            mSingleTripTextView.setText(R.string.singletripsVT);
            mMultipleTripsTextView.setText(R.string.fourtrips);
            mLogoImageView.setImageResource(R.drawable.vasttrafik);
        }
        else{

            mWelcomeTextView.setText(R.string.welcomeMalmo);
            mToWebTextView.setText(R.string.SThemsida);
            mSingleTripTextView.setText(R.string.singletripsM);
            mMultipleTripsTextView.setText(R.string.threetrips);
            mLogoImageView.setImageResource(R.drawable.skanetrafiken);


        }









    }

    private void removeUnderlines(TextView textView){
        if(textView != null) {
            URLSpanNoUnderline.removeUnderlines((Spannable)textView.getText());
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        mSingleTripTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mToWebTextView.setMovementMethod(LinkMovementMethod.getInstance());

        removeUnderlines(mToWebTextView);
        removeUnderlines(mSingleTripTextView);

    }


}
