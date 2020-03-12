package com.mrmaximka.mersedestest.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CryptoAnalyserRepo {
    private static  CryptoAnalyserRepo singleton = null;
    private  CryptoAnalyserInterface API;

    public CryptoAnalyserRepo() {
        API = createAdapter();
    }

    public CryptoAnalyserInterface getAPI() {
        return API;
    }

    public static CryptoAnalyserRepo getSingleton() {
        if (singleton == null){
            singleton = new CryptoAnalyserRepo();
        }
        return singleton;
    }

    private CryptoAnalyserInterface createAdapter(){
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("http://crypto-analyser.ml/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(CryptoAnalyserInterface.class);
    }
}
