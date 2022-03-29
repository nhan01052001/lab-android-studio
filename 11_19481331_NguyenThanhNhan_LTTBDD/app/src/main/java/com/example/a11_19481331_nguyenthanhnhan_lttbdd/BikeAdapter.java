package com.example.a11_19481331_nguyenthanhnhan_lttbdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BikeAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Bike> bikeList;
    private int posSelect = 1;

    public BikeAdapter(Context context, int idLayout, List<Bike> bikeList) {
        this.context = context;
        this.idLayout = idLayout;
        this.bikeList = bikeList;
        this.posSelect = posSelect;
    }

    @Override
    public int getCount() {
        if(bikeList.size() != 0 && !bikeList.isEmpty())
            return bikeList.size();
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
        ImageView imgXe = view.findViewById(R.id.imgXe);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvGia = view.findViewById(R.id.tvGia);

        Bike bike = bikeList.get(i);

        if(bike != null && !bikeList.isEmpty()) {
            imgXe.setImageResource(bike.getIdImg());
            tvName.setText(bike.getTvName());
            tvGia.setText("$ "+bike.getTvGia());
        }
        return view;
    }
}
