package com.mashazavolnyuk.exchangerates.API;

import com.mashazavolnyuk.exchangerates.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark Maleficent on 23.11.2016.
 */
public class DataCurrencies {
    List<Currency> currencies=new ArrayList<>();
    private static DataCurrencies ourInstance = new DataCurrencies();

    public static DataCurrencies getInstance() {
        return ourInstance;
    }

    private DataCurrencies() {
    }
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setCurrencies(Object[] objects) {

    }
}
