package ca.victor.videotech.api;

import com.google.gson.GsonBuilder;
import ca.victor.videotech.Constantes;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static ApiProvider apiProvider;
    private final IApi api;

    private ApiProvider(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()

                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder().build();
                    return chain.proceed(request);
                })
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl
                            .newBuilder()

                            .addQueryParameter("apikey", Constantes.API_KEY)
                            .build();

                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .baseUrl(Constantes.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();

        api = retrofit.create(IApi.class);
    }

    private IApi getApi() {
        return api;
    }

    public static IApi provideApi(){
        if (apiProvider == null) apiProvider = new ApiProvider();
        return apiProvider.getApi();
    }

}
