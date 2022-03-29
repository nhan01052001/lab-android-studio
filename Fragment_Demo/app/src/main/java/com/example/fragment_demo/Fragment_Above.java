package com.example.fragment_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Above extends Fragment {

    ImageButton btnImgPlus, btnImgSub;
    Button btnApDung;
    TextView tvMuaSau, tvSoLuong;
    int soLuong = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewAbove = inflater.inflate(R.layout.fragment_above, container, false);

        btnImgPlus = (ImageButton) viewAbove.findViewById(R.id.btnImgPlus);
        btnImgSub = (ImageButton) viewAbove.findViewById(R.id.btnImgSub);
        btnApDung = viewAbove.findViewById(R.id.btnApDung);

        soLuong = Integer.parseInt(tvSoLuong.getText().toString());

        btnImgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soLuong = soLuong + 1;
                tvSoLuong.setText(soLuong+"");
            }
        });

        btnImgSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soLuong != 0) {
                    soLuong = soLuong - 1;
                    tvSoLuong.setText(soLuong + "");
                }
            }
        });

        btnApDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMuaSau.setText("Mua truoc");
            }
        });

        return viewAbove;
    }
}
