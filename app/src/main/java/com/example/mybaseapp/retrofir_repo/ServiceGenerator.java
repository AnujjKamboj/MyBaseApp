package com.example.mybaseapp.retrofir_repo;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anuj.Kamboj on 3/7/2019.
 */

public class ServiceGenerator {
    public static final String API_BASE_URL = "https://dev1.xicom.us/xttest/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS).
                    writeTimeout(60, TimeUnit.SECONDS);


    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);

    }

    public static <S> S createService(Class<S> serviceClass, final String authToken, final String userId) {
        if (authToken != null) {
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

// Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("AuthorizationToken", authToken)
                            .header("userId", userId)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = httpClient.build();
        httpClient.addInterceptor(interceptor);
        Retrofit retrofit = builder.client(client).build();

        return retrofit.create(serviceClass);
    }
}