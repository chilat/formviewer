package com.erop.formviewer.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.erop.formviewer.BR;
import com.erop.formviewer.model.FormListModel;
import com.erop.formviewer.util.APIClient;
import com.erop.formviewer.view.FormListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public class FormListViewModel extends BaseObservable {
    private Integer id;
    private String idString;
    private String title;
    private String description;
    private String url;
    FormListModel formListModel;
    FormListAdapter formListAdapter;
    List<FormListModel> formList;

    public FormListViewModel(Context context) {
        formList = new ArrayList<>();
        getFormList();
        formListAdapter = new FormListAdapter(formList, context);
    }

    public FormListViewModel(FormListModel formListModel) {
        this.formListModel = formListModel;
    }
    public void setUp() {
        // perform set up tasks, such as adding listeners, data population, etc.
        getFormList(null);
    }
    @Bindable
    public List<FormListModel> getFormList() {
        return formList;
    }

    public void setFormList(List<FormListModel> formList) {
        this.formList = formList;
    }

    public FormListModel getFormListModel() {
        return formListModel;
    }

    public void setFormListModel(FormListModel formListModel) {
        this.formListModel = formListModel;
    }

    @Bindable
    public FormListAdapter getFormListAdapter() {
        return formListAdapter;
    }

    public void setFormListAdapter(FormListAdapter formListAdapter) {
        this.formListAdapter = formListAdapter;
    }


    public Integer getId() {
        return formListModel.getId();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public String getIdString() {
        return formListModel.getIdString();
    }


    @Bindable
    public String getTitle() {
        return formListModel.getTitle();
    }

    public void setTitle(String title) {
        this.title = title;
//        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return formListModel.getDescription();
    }

    public void setDescription(String description) {
        this.description = description;
//        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getUrl() {
        return formListModel.getUrl();
    }

    public void setUrl(String url) {
        this.url = url;
//        notifyPropertyChanged(BR.url);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        setMessage(s.toString());
    }

    public void getFormList(View view) {
        formList = new ArrayList<>();
APIClient apiClient = new APIClient();
        apiClient.getFormList("erop", new APIClient.onGetFormList() {
            @Override
            public void onSuccess(List<FormListModel> list) {
                setFormList(list);
                notifyPropertyChanged(BR.formList);
            }

            @Override
            public void onError(String message) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    /*    for (int i = 0; i <= 10; i++) {
            formListModel = new FormListModel();
            formListModel.setTitle("Title " + i);
            formListModel.setDescription("Desc " + i);
            formListModel.setId(i);
            formListModel.setIdString("Id String " + i);
            formList.add(formListModel);
        }*/
        notifyPropertyChanged(BR.formList);

    }

}
