package com.mashazavolnyuk.exchangerates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Dark Maleficent on 23.11.2016.
 */
@Generated("org.jsonschema2pojo")
public class Currency {

    @SerializedName("ccy")
    @Expose
    private String ccy;
    @SerializedName("base_ccy")
    @Expose
    private String baseCcy;
    @SerializedName("buy")
    @Expose
    private String buy;
    @SerializedName("sale")
    @Expose
    private String sale;

    /**
     *
     * @return
     * The ccy
     */
    public Currency (String ccy,String baseCcy,String buy,String sale){
        this.ccy=ccy;
        this.baseCcy=baseCcy;
        this.buy=buy;
        this.sale=sale;

    }

    public String getCcy() {
        return ccy;
    }

    /**
     * @param ccy The ccy
     */
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    /**
     * @return The baseCcy
     */
    public String getBaseCcy() {
        return baseCcy;
    }

    /**
     * @param baseCcy The base_ccy
     */
    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    /**
     * @return The buy
     */
    public String getBuy() {
        return buy;
    }

    /**
     * @param buy The buy
     */
    public void setBuy(String buy) {
        this.buy = buy;
    }

    /**
     * @return The sale
     */
    public String getSale() {
        return sale;
    }

    /**
     * @param sale The sale
     */
    public void setSale(String sale) {
        this.sale = sale;
    }

}
