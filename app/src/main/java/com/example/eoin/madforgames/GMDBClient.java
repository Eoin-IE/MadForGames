package com.example.eoin.madforgames;

import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Call;


import java.io.IOException;
import java.util.List;

public class GMDBClient {

    private static TheGameDbService theGameDbService;

    private static final String BASE_URL = "https://api-endpoint.igdb.com";

    public static TheGameDbService getClient() {
        if (theGameDbService == null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
            okHttpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept( Chain chain) throws IOException {
                    final Request request = chain.request().newBuilder().addHeader("user-key", "TO GET API KEY GOTO GMDB and sign up.").build();
                    return chain.proceed(request);
                }
            });
            final Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create()).build();
            theGameDbService = client.create(TheGameDbService.class);
        }
        return theGameDbService;
    }


    public interface TheGameDbService {

        @GET("/games/95340")
        Call<List<Game>> getPubG();

    }
}
