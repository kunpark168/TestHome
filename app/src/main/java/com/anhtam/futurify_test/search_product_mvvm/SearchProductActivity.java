package com.anhtam.futurify_test.search_product_mvvm;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anhtam.futurify_test.R;
import com.anhtam.futurify_test.base.BaseActivity;

public class SearchProductActivity extends BaseActivity {

    private ImageView imgDelete;
    private EditText etSearch;
    private SearchViewModel viewModel;
    private SearchAdapter mAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        initView ();
        //
        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        viewModel.getProducts().observe(this, products -> {
            // set data adapter
            mAdapter.addItems(products);
        });

        // search
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.search(etSearch.getText().toString());
            }
        });

    }

    private void initView (){
        imgDelete = findViewById(R.id.imgDelete);
        etSearch = findViewById(R.id.etSearch);
        recyclerView = findViewById(R.id.rvSearch);
        mAdapter = new SearchAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }
}
