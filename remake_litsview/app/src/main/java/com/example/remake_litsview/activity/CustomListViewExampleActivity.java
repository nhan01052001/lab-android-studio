package com.example.remake_litsview.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.remake_litsview.R;
import com.example.remake_litsview.adapter.ProductAdapter;
import com.example.remake_litsview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewExampleActivity extends AppCompatActivity {
    private List<Product> listProduct;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view_activity);

        listView = (ListView) findViewById(R.id.idListView);
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Lập Trình Java"));
        listProduct.add(new Product(2, "Lập Trình Android"));
        listProduct.add(new Product(3, "Lập Trình JavaFX"));
        listProduct.add(new Product(4, "Lập Trình Web"));
        listProduct.add(new Product(5, "Lập Trình Ruby"));
        listProduct.add(new Product(6, "Lập Trình C++"));
        listProduct.add(new Product(7, "Lập Trình PHP"));
        listProduct.add(new Product(8, "Lập Trình WordPress"));

        ProductAdapter adapter = new ProductAdapter(this, R.layout.item_custom_list_view, listProduct);
        listView.setAdapter(adapter);

    }
}
