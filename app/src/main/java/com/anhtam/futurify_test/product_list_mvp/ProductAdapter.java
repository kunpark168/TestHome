package com.anhtam.futurify_test.product_list_mvp;

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

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> arrProduct;
    private Context mContext;

    public ProductAdapter(List<Product> arrProduct, Context mContext) {
        this.arrProduct = arrProduct;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
            holder.bind(arrProduct.get(position));
    }

    public void setArrProduct(List<Product> arrProduct) {
        this.arrProduct = arrProduct;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrProduct.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDescription, tvPrice, tvProductName;
        private RoundRectCornerImageView imgProduct;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }

        public void bind (Product product){
            tvProductName.setText(product.getProductName());
            tvPrice.setText("Orger from " + String.valueOf(product.getPrice()) + "$");
            imgProduct.setImageResource(CategoryList.getImage(product.getCategoryId()));
            tvDescription.setText(product.getDescription());

            ((BaseActivity) mContext).action(this.itemView, () -> {
                Intent intent = new Intent(mContext, DetailProductActivity.class);
                intent.putExtra(Constant.PRODUCT, product);
                ((BaseActivity) mContext).onStartActivity(intent);
            });
        }
    }
}
