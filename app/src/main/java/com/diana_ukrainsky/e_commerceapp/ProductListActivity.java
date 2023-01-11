package com.diana_ukrainsky.e_commerceapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diana_ukrainsky.e_commerceapp.databinding.ActivityProductListBinding;

import java.util.ArrayList;

// view binding
// fragment medium + fragment replace developers
public class ProductListActivity extends AppCompatActivity implements LifecycleOwner {
    private ActivityProductListBinding activityProductListBinding;
    private ProductListViewModel viewModel;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductListBinding = ActivityProductListBinding.inflate(getLayoutInflater());
        View view = activityProductListBinding.getRoot();
        setContentView(view);
        
        setViewModel();
        setRecyclerView();
        setAdapter();
        setListeners();
    }

    private void setListeners() {
        activityProductListBinding.activityProductListBTNGenerate.setOnClickListener(v ->{
            viewModel.populateAnotherList();
        });
    }

    private void setRecyclerView() {
        recyclerView=activityProductListBinding.fragmentProductListRVProductList;

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (linearLayoutManager);
    }

    private void setViewModel() {
        viewModel =new ViewModelProvider(this).get(ProductListViewModel.class);
        viewModel.getProductMutableLiveData().observe(this, productListUpdateObserver);
    }

    private void setAdapter() {
        productAdapter = new ProductAdapter();
        recyclerView.setAdapter(productAdapter);
    }
    Observer<ArrayList<Product>> productListUpdateObserver = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> productArrayList) {
            productAdapter.updateEmployeeListItems(productArrayList);
        }
    };
}
