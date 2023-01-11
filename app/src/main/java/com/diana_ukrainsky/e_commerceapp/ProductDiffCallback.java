package com.diana_ukrainsky.e_commerceapp;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class ProductDiffCallback extends DiffUtil.Callback {

        private final List<Product> mOldProductList;
        private final List<Product> mNewProductList;

        public ProductDiffCallback(List<Product> oldProductList, List<Product> newProductList) {
            this.mOldProductList = oldProductList;
            this.mNewProductList = newProductList;
        }

        @Override
        public int getOldListSize() {
            return mOldProductList.size();
        }

        @Override
        public int getNewListSize() {
            return mNewProductList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return mOldProductList.get(oldItemPosition).getProductId() == mNewProductList.get(
                    newItemPosition).getProductId();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            final Product oldProduct = mOldProductList.get(oldItemPosition);
            final Product newProduct = mNewProductList.get(newItemPosition);

            return oldProduct.getProductName().equals(newProduct.getProductName());
        }

        @Nullable
        @Override
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            // Implement method if you're going to use ItemAnimator
            return super.getChangePayload(oldItemPosition, newItemPosition);
        }

}
