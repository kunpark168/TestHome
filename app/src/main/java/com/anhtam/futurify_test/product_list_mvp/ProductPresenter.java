package com.anhtam.futurify_test.product_list_mvp;

import android.content.Context;

import com.anhtam.futurify_test.model.ProductService;

public class ProductPresenter implements IProductList.presenter {
    private IProductList.view mView;
    private Context mContext;

    public ProductPresenter(IProductList.view mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }

    @Override
    public void onGetListProduct() {
        /** If I have API GET LIST PRODUCT - I will handle it here */
        mView.onGetListProductSuccess(ProductService.getInstance(mContext).getListProduct());
    }

    @Override
    public void onGetListCategory() {
        /** If I have API GET LIST CATEGORY - I will handle it here */
        mView.onGetListCategorySuccess(ProductService.getInstance(mContext).getListCategory());
    }
}
