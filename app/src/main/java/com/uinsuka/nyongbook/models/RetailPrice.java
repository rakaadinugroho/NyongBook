
package com.uinsuka.nyongbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RetailPrice {

    @SerializedName("amount")
    private Double mAmount;
    @SerializedName("amountInMicros")
    private Double mAmountInMicros;
    @SerializedName("currencyCode")
    private String mCurrencyCode;

    public Double getAmount() {
        return mAmount;
    }

    public void setAmount(Double amount) {
        mAmount = amount;
    }

    public Double getAmountInMicros() {
        return mAmountInMicros;
    }

    public void setAmountInMicros(Double amountInMicros) {
        mAmountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        mCurrencyCode = currencyCode;
    }

}
