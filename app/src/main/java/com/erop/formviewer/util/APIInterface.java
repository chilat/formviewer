package com.erop.formviewer.util;

import com.erop.formviewer.model.FormListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public interface APIInterface {
    @GET("data?owner=erop")
    Call<List<FormListModel>> getFormList();
}
