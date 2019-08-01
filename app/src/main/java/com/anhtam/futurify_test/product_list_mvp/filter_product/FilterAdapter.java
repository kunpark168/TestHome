package com.anhtam.futurify_test.product_list_mvp.filter_product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.anhtam.futurify_test.R;
import com.anhtam.futurify_test.model.Category;

import java.util.List;

public class FilterAdapter extends BaseAdapter {

    private List<Category> arrCategory;
    private Context mContext;

    public FilterAdapter(List<Category> arrCategory, Context mContext) {
        this.arrCategory = arrCategory;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrCategory.size();
    }

    @Override
    public Object getItem(int i) {
        return arrCategory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_category, null);
        TextView tvCategory = view.findViewById(R.id.tvCategory);
        tvCategory.setText(arrCategory.get(i).getCategoryName());
        return view;
    }

}
