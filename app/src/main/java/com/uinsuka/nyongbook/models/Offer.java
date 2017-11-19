
package com.uinsuka.nyongbook.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Offer {

    @SerializedName("finskyOfferType")
    private Long mFinskyOfferType;
    @SerializedName("listPrice")
    private ListPrice mListPrice;
    @SerializedName("retailPrice")
    private RetailPrice mRetailPrice;

    public Long getFinskyOfferType() {
        return mFinskyOfferType;
    }

    public void setFinskyOfferType(Long finskyOfferType) {
        mFinskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return mListPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        mListPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return mRetailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        mRetailPrice = retailPrice;
    }

}
