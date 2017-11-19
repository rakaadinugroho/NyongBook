package com.uinsuka.nyongbook.network;

import com.uinsuka.nyongbook.models.ResponseBooks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Raka Adi Nugroho on 11/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface NetworkStores {
    @GET("volumes")
    Call<ResponseBooks> getBooks(@Query("q") String keywork);

}
