package com.anhtam.futurify_test.product_list_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anhtam.futurify_test.R;
import com.anhtam.futurify_test.base.BaseActivity;
import com.anhtam.futurify_test.model.AdapterType;
import com.anhtam.futurify_test.model.Category;
import com.anhtam.futurify_test.model.Product;
import com.anhtam.futurify_test.model.ProductService;
import com.anhtam.futurify_test.product_list_mvp.filter_product.FilterAdapter;
import com.anhtam.futurify_test.search_product_mvvm.SearchProductActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends BaseActivity implements IProductList.view {

    private ImageView imgSearch, imgTransfer;
    private ProductAdapter mAdapter;
    private RecyclerView rvProduct;
    private ProductPresenter mPresenter;
    private Spinner spinner;
    private TextView tvCategory;
    private int type = 1;
    private List<Product> arrProduct = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView ();
        initRecyclerView ();
        initSpinner ();
        getData ();
        initControls ();
    }

    private void initView (){
        mPresenter = new ProductPresenter(this, this);
        imgTransfer = findViewById(R.id.imgTransfer);
        imgSearch = findViewById(R.id.imgSearch);
        rvProduct = findViewById(R.id.rvProduct);
        spinner = findViewById(R.id.spinner);
        tvCategory = findViewById(R.id.tvCategory);
    }

    private void initRecyclerView (){
        switch (AdapterType.getAdapterType(type)){
            case GRID:
                rvProduct.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case LIST:
                rvProduct.setLayoutManager(new LinearLayoutManager(this));
                break;
        }
        mAdapter = new ProductAdapter(arrProduct, this);
        rvProduct.setAdapter(mAdapter);

    }

    private void initSpinner(){
        List<Category> arrCategory = ProductService.getInstance(this).getListCategory();
        arrCategory.add(new Category().setId("ALL").setCategoryName("All"));
        SpinnerAdapter filterAdapter = new FilterAdapter(arrCategory, this);
        spinner.setAdapter(filterAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvCategory.setText(arrCategory.get(i).getCategoryName());
                filter(arrCategory.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void filter(Category category) {
        this.arrProduct = ProductService.getInstance(this).getFilterCategory(category.getId());
        mAdapter.setArrProduct(arrProduct);
    }


    private void getData (){
        mPresenter.onGetListCategory();
        mPresenter.onGetListProduct();
    }

    private void initControls (){
        action(imgTransfer, () -> {
            if (type == AdapterType.LIST.getType()){
                type = AdapterType.GRID.getType();
            } else type = AdapterType.LIST.getType();
            initRecyclerView();
        });

        action(imgSearch, () -> onStartActivity(new Intent(this, SearchProductActivity.class)));
    }

    @Override
    public void onGetListCategorySuccess(List<Category> arrCategory) {

    }

    @Override
    public void onGetListCategoryFail(String error) {

    }

    @Override
    public void onGetListProductSuccess(List<Product> arrProduct) {
        this.arrProduct = arrProduct;
        mAdapter.setArrProduct(this.arrProduct);
    }

    @Override
    public void onGetListProductFail(String error) {

    }
}
