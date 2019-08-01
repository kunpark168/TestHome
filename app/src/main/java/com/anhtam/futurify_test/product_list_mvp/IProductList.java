package com.anhtam.futurify_test.product_list_mvp;

import com.anhtam.futurify_test.model.Category;
import com.anhtam.futurify_test.model.Product;

import java.util.List;

public interface IProductList {
    interface view {
        void onGetListCategorySuccess (List<Category> arrCategory);
        void onGetListCategoryFail (String error);
        void onGetListProductSuccess (List<Product> arrProduct);
        void onGetListProductFail (String error);
    }

    interface presenter {
        void onGetListProduct ();
        void onGetListCategory ();
    }
}
