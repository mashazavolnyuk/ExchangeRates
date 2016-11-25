package com.mashazavolnyuk.exchangerates.API;

import com.mashazavolnyuk.exchangerates.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dark Maleficent on 23.11.2016.
 */

public interface IRequest {

    @GET("pubinfo?json&exchange&&coursid=3")
    Call<List<Currency>> getCurrency();

}
