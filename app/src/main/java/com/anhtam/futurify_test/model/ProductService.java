package com.anhtam.futurify_test.model;

import android.content.Context;

import com.anhtam.futurify_test.utils.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {
    private static ProductService instance;
    private String jsonCategory;
    private String jsonProduct;
    private Context mContext;

    public static ProductService getInstance(Context mContext) {
        if (instance == null)
            instance = new ProductService(mContext);
        return instance;
    }

    private ProductService(Context mContext) {
        this.mContext = mContext;
        readJsonFromAssets("category.json");
        readJsonFromAssets("product.json");
    }

    public void readJsonFromAssets(String pathFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(mContext.getAssets().open("raw/" + pathFile), "UTF-8"));
            StringBuilder contents = new StringBuilder();
            String text;
            while ((text = reader.readLine()) != null) {
                contents.append(text);
            }
            if (pathFile.equals("category.json"))
                jsonCategory = contents.toString();
            else jsonProduct = contents.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Category> getListCategory (){
        List<Category> arrCategory = new ArrayList<>();
        try {
            arrCategory.addAll(Arrays.asList(JSON.decode(jsonCategory, Category[].class)));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return arrCategory;
    }

    public List<Product> getListProduct (){
        List<Product> arrProduct = new ArrayList<>();
        try {
            arrProduct.addAll(Arrays.asList(JSON.decode(jsonProduct, Product[].class)));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return arrProduct;
    }

    public List<Product> getFilterCategory (String idCategory){
        List<Product> arrProduct = new ArrayList<>();
        for (Product product : getListProduct()){
            if (product.getCategoryId().equals(idCategory)){
                arrProduct.add(product);
            }
        }
        if (arrProduct.size() <= 0)
            arrProduct = getListProduct();
        return arrProduct;
    }
}
