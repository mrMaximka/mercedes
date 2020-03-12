package com.mrmaximka.mersedestest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CryptoAnalyserRestModel {
    @SerializedName("id")               public int id;
    @SerializedName("fsym")             public String fsym;
    @SerializedName("tsym")             public String tsym;
    @SerializedName("exchange")         public String exchange;
    @SerializedName("current_price")    public String current_price;
    @SerializedName("1DABS")            public String day1;
    @SerializedName("7DABS")            public String day7;
    @SerializedName("30DABS")           public String day30;
    @SerializedName("1DPROC")           public String dayProc1;
    @SerializedName("7DPROC")           public String dayProc7;
    @SerializedName("30DPROC")          public String dayProc30;
}
