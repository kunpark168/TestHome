package com.anhtam.futurify_test.model;

import com.anhtam.futurify_test.R;

public enum CategoryList {
    ORANGE ("C01", R.drawable.orange),
    PEACH ("C04", R.drawable.peach),
    APPLE ("C02", R.drawable.img_apple),
    BANANA ("C03", R.drawable.img_banana);
    private String idCategory;
    private int image;

    public String getIdCategory() {
        return idCategory;
    }

    public int getImage() {
        return image;
    }

    CategoryList(String idCategory, int image) {
        this.idCategory = idCategory;
        this.image = image;
    }

    public static int getImage (String idCategory){
        for (CategoryList category : values()){
            if (category.getIdCategory().equals(idCategory)){
                return category.getImage();
            }
        }
        return 0;
    }
}
