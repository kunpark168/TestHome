package com.anhtam.futurify_test.model;

public enum AdapterType {
    LIST (0), GRID (1);
    private int type;

    AdapterType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static AdapterType getAdapterType (int type){
        for (AdapterType adapterType : values()){
            if (adapterType.getType() == type)
                return adapterType;
        }
        return LIST;
    }
}
