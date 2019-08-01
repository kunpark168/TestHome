package com.anhtam.futurify_test.detail_product;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhtam.futurify_test.R;
import com.anhtam.futurify_test.base.BaseActivity;
import com.anhtam.futurify_test.customview.RoundRectCornerImageView;
import com.anhtam.futurify_test.model.CategoryList;
import com.anhtam.futurify_test.model.Product;
import com.anhtam.futurify_test.utils.Constant;

public class DetailProductActivity extends BaseActivity {

    private Product product;
    private ImageView imgBack;
    private TextView tvProductName, tvDescription, tvPrice;
    private RoundRectCornerImageView imgProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        initView ();
        getData ();
        initControls ();
    }

    private void initView (){
        imgBack = findViewById(R.id.imgBack);
        tvProductName = findViewById(R.id.tvProductName);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        imgProduct = findViewById(R.id.imgProduct);
    }

    private void getData (){
        product = (Product) getIntent().getSerializableExtra(Constant.PRODUCT);
        if (product != null){
            tvProductName.setText(product.getProductName());
            tvDescription.setText(product.getDescription());
            tvPrice.setText("Orger from " + String.valueOf(product.getPrice()) + "$");
            imgProduct.setImageResource(CategoryList.getImage(product.getCategoryId()));
        }
    }

    private void initControls (){
        action(imgBack, () -> onBackPressed());
    }
}
