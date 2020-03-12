package com.mrmaximka.mersedestest.model;

import com.google.gson.annotations.SerializedName;

class LineModel {
    @SerializedName("pair")             public String pair;
    @SerializedName("current_price")    public String currentPrice;
    @SerializedName("1d_change")        public String change1;
    @SerializedName("7d_change")        public String change7;
    @SerializedName("30d_change")       public String change30;
    @SerializedName("exchange")         public String exchange;
}
