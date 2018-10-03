package com.erop.formviewer.util;

import com.erop.formviewer.model.FormListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public interface APIInterface {
    @GET("data")
    Call<List<FormListModel>> getFormList(@Query("owner")String owner);

    @GET("data")
        Call<List<FormListModel>> getFormList();
}
