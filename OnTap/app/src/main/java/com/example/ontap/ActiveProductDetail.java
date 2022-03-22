package com.example.ontap;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActiveProductDetail extends AppCompatActivity {
    private Product product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product);
        product = (Product) getIntent().getSerializableExtra("selectedProduct");
        showProductInfor(product);
    }

    private void showProductInfor(Product product) {
        ImageView imgProduct = findViewById(R.id.imgProduct);
        imgProduct.setImageResource(product.getId());

        TextView tvName = findViewById(R.id.tvName);

        tvName.setText(product.getTvName());
        TextView tvGH = findViewById(R.id.tvGH);

        tvGH.setText(product.getTvGH());
        TextView tvGiaThat = findViewById(R.id.tvGiaThat);

        tvGiaThat.setText("$ " +product.getTvGiaThat());
        TextView tvGiamGia = findViewById(R.id.tvGiamGia);

        tvGiamGia.setText("$ " +product.getTvGiamGia());


    }

}
