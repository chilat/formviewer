package com.erop.formviewer.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.erop.formviewer.R;
import com.erop.formviewer.databinding.ItemFormBinding;
import com.erop.formviewer.model.FormListModel;
import com.erop.formviewer.viewmodel.FormListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.MyViewHolder> {
    List<FormListModel> formList = new ArrayList<>();
    Context context;

    public FormListAdapter(List<FormListModel> list, Context context) {
        this.formList = list;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ItemFormBinding itemFormBinding;

        public MyViewHolder(View view) {
            super(view);
            if (itemFormBinding == null)
                itemFormBinding = DataBindingUtil.bind(itemView);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*ItemFormBinding itemFormBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_form, parent, false);
        return new MyViewHolder(itemFormBinding);*/
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_form,
                new FrameLayout(parent.getContext()), false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FormListModel formListModel = formList.get(position);
        holder.itemFormBinding.setViewmodel(new FormListViewModel(formListModel));
    }

    @Override
    public int getItemCount() {
        return formList.size();
    }
    public void updateData(@Nullable List<FormListModel> data) {
        if (data == null || data.isEmpty()) {
            this.formList.clear();
        } else {
            this.formList.addAll(data);
        }
        notifyDataSetChanged();
    }
    /*@Override
    public void onViewAttachedToWindow(MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.();
    }*/
}
