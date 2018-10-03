package com.erop.formviewer.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.erop.formviewer.BR;
import com.erop.formviewer.R;
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
    private FormListModel formListModel;
    private FormListAdapter formListAdapter;
    private List<FormListModel> formList;
    private Context context;
    private String owner;
    private String message;
    boolean listVisible;

    public FormListViewModel() {
        formList = new ArrayList<>();
        formListAdapter = new FormListAdapter(formList, context);
    }

    public FormListViewModel(FormListModel formListModel) {
        this.formListModel = formListModel;
    }

    public void setUp(View view) {
        // perform set up tasks, such as adding listeners, data population, etc.
        getFormList(view);
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

    @Bindable
    public boolean isListVisible() {
        return listVisible;
    }

    public void setListVisible(boolean listVisible) {
        this.listVisible = listVisible;
        notifyPropertyChanged(BR.listVisible);
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    public String getOwner() {
        return owner;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        setMessage(s.toString());
        owner = s.toString();
    }

    public void getFormList(final View view) {
        formList = new ArrayList<>();
        final MaterialDialog dialog = new MaterialDialog.Builder(view.getContext())
                .content("Loading...")
                .cancelable(false)
                .progress(true, 0)
                .show();
        APIClient apiClient = new APIClient();
        apiClient.getFormList(owner, new APIClient.onGetFormList() {
            @Override
            public void onSuccess(List<FormListModel> list) {
                dialog.dismiss();
                setListVisible(list.size()>0);
                setMessage(view.getContext().getResources().getString(R.string.no_records) +" "+getOwner());
                setFormList(list);
                notifyPropertyChanged(BR.formList);
            }

            @Override
            public void onError(String message) {
                dialog.dismiss();

            }

            @Override
            public void onFailure(Exception e) {
                dialog.dismiss();

            }
        });

        notifyPropertyChanged(BR.formList);

    }

}
