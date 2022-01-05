package com.example.homework7.ui.fragments.home.model;

import java.io.Serializable;

public class ModelData implements Serializable {
    public ModelData(String data) {
        this.data = data;
    }

    private String data;

    public String getData()
    {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
