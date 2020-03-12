package com.mrmaximka.mersedestest.rest;

import com.mrmaximka.mersedestest.model.CryptoAnalyserRestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAnalyserInterface {
    @GET("?getData")
    Call<List<CryptoAnalyserRestModel>> loadData();
}
