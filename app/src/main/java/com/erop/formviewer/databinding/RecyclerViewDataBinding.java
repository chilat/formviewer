package com.erop.formviewer.databinding;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.erop.formviewer.model.FormListModel;
import com.erop.formviewer.view.FormListAdapter;

import java.util.List;
public class RecyclerViewDataBinding {
    /**
     * Binds the data to the {@link android.support.v7.widget.RecyclerView.Adapter}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView passed in automatically with the data binding
     * @param formListAdapter      must be explicitly passed in
     * @param formList         must be explicitly passed in
     */
    @BindingAdapter({"app:formListAdapter", "app:formList"})
    public void bind(RecyclerView recyclerView, FormListAdapter formListAdapter, List<FormListModel> formList) {
        recyclerView.setAdapter(formListAdapter);
        formListAdapter.updateData(formList);
    }
}
