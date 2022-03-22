package com.example.ontap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Product> productList;
    private int posSelect = 1;

    public ProductAdapter(Context context, int idLayout, List<Product> productList) {
        this.context = context;
        this.idLayout = idLayout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        if(productList.size() != 0 && !productList.isEmpty())
            return productList.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        ImageView imgProduct = view.findViewById(R.id.imgProduct);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvGH = view.findViewById(R.id.tvGH);
        TextView tvGiaThat = view.findViewById(R.id.tvGiaThat);
        TextView tvGiamGia = view.findViewById(R.id.tvGiamGia);
        final ConstraintLayout productView = view.findViewById(R.id.productView);

        Product product = productList.get(i);

        if(product != null && !productList.isEmpty()) {
            imgProduct.setImageResource(product.getId());
            tvName.setText(product.getTvName());
            tvGH.setText(product.getTvGH());
            tvGiaThat.setText("$ " +product.getTvGiaThat());
            tvGiamGia.setText("$ " +product.getTvGiamGia());
        }

        productView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("thanh cong");
                Intent intent = new Intent(context, ActiveProductDetail.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("selectedProduct", product);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
