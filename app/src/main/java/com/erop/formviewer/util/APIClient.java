package com.erop.formviewer.util;

import android.util.Log;

import com.erop.formviewer.BuildConfig;
import com.erop.formviewer.model.FormListModel;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public class APIClient {
    /**
     * Contains the base url builder that is used by all other API calls.
     */
    public static Retrofit getClient() {
        Retrofit retrofit;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG)
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(NativeTasks.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public interface onGetFormList {
        void onSuccess(List<FormListModel> list);

        void onError(String message);

        void onFailure(Exception e);
    }

    public void getFormList(String owner, final onGetFormList onResult) {
        List<FormListModel> list = new ArrayList<>();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<FormListModel>> call = owner == null ? apiInterface.getFormList("erop") : apiInterface.getFormList(owner);
        call.enqueue(new Callback<List<FormListModel>>() {
            @Override
            public void onResponse(Call<List<FormListModel>> call, retrofit2.Response<List<FormListModel>> response) {
                try {

                    if (response.isSuccessful())
                        onResult.onSuccess(response.body());
//                    Log.d("Dataa",response.body().toString());
                    else
                        onResult.onError(response.message());

                } catch (Exception e) {
                    e.printStackTrace();
                    onResult.onFailure(e);
                }
            }

            @Override
            public void onFailure(Call<List<FormListModel>> call, Throwable t) {
                onResult.onError(t.getLocalizedMessage());
            }
        });
    }
}
