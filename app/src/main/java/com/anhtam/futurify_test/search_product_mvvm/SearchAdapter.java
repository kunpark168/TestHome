package com.anhtam.futurify_test.search_product_mvvm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhtam.futurify_test.R;
import com.anhtam.futurify_test.base.BaseActivity;
import com.anhtam.futurify_test.customview.RoundRectCornerImageView;
import com.anhtam.futurify_test.detail_product.DetailProductActivity;
import com.anhtam.futurify_test.model.CategoryList;
import com.anhtam.futurify_test.model.Product;
import com.anhtam.futurify_test.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Product> mProducts;
    private Context mContext;


    public SearchAdapter() {
        this.mProducts = new ArrayList<>();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        if (mProducts != null && mProducts.size() > 0) {
            holder.bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return mProducts == null ? 0 : mProducts.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDescription, tvPrice;
        private RoundRectCornerImageView imgProduct;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }

        public void bind(int position){
            Product product = mProducts.get(position);
            tvPrice.setText("Orger from " + String.valueOf(product.getPrice()) + "$");
            imgProduct.setImageResource(CategoryList.getImage(product.getCategoryId()));
            tvDescription.setText(product.getProductName());

            ((BaseActivity) mContext).action(this.itemView, () -> {
                Intent intent = new Intent(mContext, DetailProductActivity.class);
                intent.putExtra(Constant.PRODUCT, product);
                ((BaseActivity) mContext).onStartActivity(intent);
            });
        }
    }

    public void addItems(List<Product> products) {
        mProducts = products;
        notifyDataSetChanged();
    }
}
