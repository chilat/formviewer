package com.erop.formviewer.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erop.formviewer.R;
import com.erop.formviewer.databinding.ActivityMainBinding;
import com.erop.formviewer.databinding.AppDataBindingComponent;
import com.erop.formviewer.viewmodel.FormListViewModel;

import static android.widget.LinearLayout.VERTICAL;
// Main entry class
public class MainActivity extends AppCompatActivity {
ActivityMainBinding activityMainBinding;
FormListViewModel formListViewModel;
Context context;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
        view = bind();
        initRecyclerView(view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        formListViewModel.setUp(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        formListViewModel.setUp();
    }
    private View bind() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        formListViewModel = new FormListViewModel();
        activityMainBinding.setViewmodel(formListViewModel);
        return activityMainBinding.getRoot();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rvFormList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }

}
