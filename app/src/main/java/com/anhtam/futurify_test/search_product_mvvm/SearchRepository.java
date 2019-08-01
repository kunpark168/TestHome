package com.anhtam.futurify_test.search_product_mvvm;

import android.content.Context;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anhtam.futurify_test.model.Product;
import com.anhtam.futurify_test.model.ProductService;

import java.util.ArrayList;
import java.util.List;

public class SearchRepository {

    private MutableLiveData<List<Product>> mProducts;
    public static SearchRepository instance;
    private Context context;

    public static SearchRepository getInstance(Context context) {
        if(instance == null)
            instance = new SearchRepository(context);
        return instance;
    }

    private SearchRepository(Context context){
        this.context = context;
        mProducts = new MutableLiveData<>();
    }


    public void search(String query){
        List<Product> list =  new ArrayList<>();
        if (!TextUtils.isEmpty(query)) {
            for (Product product : ProductService.getInstance(context).getListProduct()) {
                if (product.getProductName().toLowerCase().contains(query.toLowerCase())) {
                    list.add(product);
                }

            }
        }
        mProducts.postValue(list);

    }

    public LiveData<List<Product>> getProducts() {
        return mProducts;
    }


}
