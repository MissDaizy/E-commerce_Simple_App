package com.diana_ukrainsky.e_commerceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.diana_ukrainsky.e_commerceapp.databinding.ProductItemBinding;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{
    private ProductItemBinding productItemBinding;
    private ArrayList<Product> mProductArrayList;

    public ProductAdapter() {
        this.mProductArrayList=new ArrayList<>();
    }


    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productItemBinding = ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = productItemBinding.getRoot();

        return new MyViewHolder(productItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        Product product = mProductArrayList.get(position);

        setProductImage();
        holder.productItemBinding.productItemTXTProductName.setText(product.getProductName());
        holder.productItemBinding.productItemTXTProductDescription.setText(product.getProductDescription());
        holder.productItemBinding.productItemTXTProductPrice.setText(product.getProductPrice());
        
    }

    private void setProductImage() {
        // TODO: set here product image
    }

    @Override
    public int getItemCount() {
        return mProductArrayList.size();
    }

    public void updateEmployeeListItems(List<Product> products) {
        final ProductDiffCallback diffCallback = new ProductDiffCallback(this.mProductArrayList, products);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.mProductArrayList.clear();
        this.mProductArrayList.addAll(products);
        diffResult.dispatchUpdatesTo(this);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private  ProductItemBinding productItemBinding;

        public MyViewHolder(ProductItemBinding productItemBinding) {
            super(productItemBinding.getRoot());
            this.productItemBinding = productItemBinding;

        }
    }
}
