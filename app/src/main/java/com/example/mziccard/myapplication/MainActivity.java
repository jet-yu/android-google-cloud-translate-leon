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
//                final Translation translation =
//                        translate.translate("Hey #vapers \uD83C\uDF2C️❄️\n" +
//                                        "▶️ do u love the #heisenberg #eliquid to? \n" +
//                                        "#VaffleFam #eliquidporn #VampireVape",
//                                Translate.TranslateOption.targetLanguage("pl"));

                final Translation translation =
                        translate.translate("hello",
                                Translate.TranslateOption.targetLanguage("el"));
                //zh-CN 简体汉语
                //zh_TW 中文 (中国)

                //en 英文 2
//                ru 俄语 2
//                in 印尼 2
//                pl 波兰 2
//                pt 葡萄牙 2
//                ja 日本   2
//                el 希腊   2
//                tr 土耳其 2
//                es 西班牙 2
//                fr 法语   2
//                it 意大利 2
//                ko 韩国 2
//                de 德语  2






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
