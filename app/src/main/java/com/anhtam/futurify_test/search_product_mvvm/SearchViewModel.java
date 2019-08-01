package com.anhtam.futurify_test.search_product_mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anhtam.futurify_test.model.Product;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
    private SearchRepository repository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository = SearchRepository.getInstance(application);
    }

    public void search(String query) {
        repository.search(query);
    }

    public LiveData<List<Product>> getProducts() {
        return repository.getProducts();
    }
}
