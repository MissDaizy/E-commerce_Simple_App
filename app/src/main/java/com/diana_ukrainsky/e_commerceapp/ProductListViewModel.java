package com.diana_ukrainsky.e_commerceapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ProductListViewModel extends ViewModel {
    MutableLiveData<ArrayList<Product>> productLiveData;
    ArrayList<Product> productArrayList;

    public ProductListViewModel() {
        productLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<Product>> getProductMutableLiveData(){
        return productLiveData;
    }

    public void init(){
        populateList();
        productLiveData.setValue(productArrayList);
    }

    public void populateList(){
        Product product = new Product();
        product.setProductName("NAME_1");
        product.setProductDescription("DESC_1 !");

        productArrayList = new ArrayList<>();
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);

    }

    public void populateAnotherList() {
        Product product = new Product();
        product.setProductName("NAME_2");
        product.setProductDescription("DESC_2 !");

        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);

        productLiveData.setValue(productArrayList);


    }
}
