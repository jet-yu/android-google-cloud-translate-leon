package com.example.mziccard.myapplication;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MainActivity extends AppCompatActivity {

    // todo API_KEY should not be stored in plain sight
    private static final String API_KEY = "AIzaSyDvLbFs7VE5k_zAOOTaxbAz-tTc-0U5cuw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.text_view);
        final Handler textViewHandler = new Handler();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                TranslateOptions options = TranslateOptions.newBuilder()
                        .setApiKey(API_KEY)
                        .build();
                Translate translate = options.getService();
                final Translation translation =
                        translate.translate("The world is the great gymnasium where we come to make ourselves strong.\n" +
                                        "You cannot believe in God until you believe in yourself.\n" +
                                        "All the powers in the universe are already ours. It is we who have put our hands before our eyes and cry that it is dark.\n" +
                                        "Condemn none: if you can stretch out a helping hand, do so. If you cannot, fold your hands, bless your brothers, and let them go their own way.\n" +
                                        "Arise,awake and donot stop until the goal is reached.\n" +
                                        "When an idea exclusively occupies the mind, it is transformed into an actual physical or mental state.\n" +
                                        "Truth can be stated in a thousand different ways, yet each one can be true.",
                                Translate.TranslateOption.targetLanguage("te"));
                textViewHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (textView != null) {
                            textView.setText(translation.getTranslatedText());
                        }
                    }
                });
                return null;
            }
        }.execute();
    }
}
