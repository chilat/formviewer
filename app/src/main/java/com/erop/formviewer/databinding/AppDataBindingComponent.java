package com.erop.formviewer.databinding;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
public class AppDataBindingComponent implements android.databinding.DataBindingComponent {
    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}