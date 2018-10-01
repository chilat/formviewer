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
import com.erop.formviewer.model.FormListModel;
import com.erop.formviewer.viewmodel.FormListViewModel;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding activityMainBinding;
FormListViewModel formListViewModel;
Context context;
    View view;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
        view = bind();
        initRecyclerView(view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Form Viewer");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        formListViewModel.setUp();
    }
    private View bind() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        formListViewModel = new FormListViewModel(this);
        activityMainBinding.setViewmodel(formListViewModel);
        return activityMainBinding.getRoot();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rvFormList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
