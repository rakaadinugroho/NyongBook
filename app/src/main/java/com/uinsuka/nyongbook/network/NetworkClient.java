package com.uinsuka.nyongbook.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raka Adi Nugroho on 11/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class NetworkClient {
    private static Retrofit retrofit;
    private static final String BASE_URL    = "https://www.googleapis.com/books/v1/";

    public static Retrofit getRetrofit() {
        if (retrofit == null){
            OkHttpClient.Builder builder    = new OkHttpClient.Builder();
            OkHttpClient httpClient = builder.build();

            retrofit    = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }
}
