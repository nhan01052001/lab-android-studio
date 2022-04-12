package com.example.connectwithdb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Customer> listCus;
    private int positionSelect = -1;
    public int tempIndex = -1;

    public CustomerAdapter(Context context, int idLayout, List<Customer> listCus) {
        this.context = context;
        this.idLayout = idLayout;
        this.listCus = listCus;
    }

    @Override
    public int getCount() {
        if (listCus.size() != 0 && !listCus.isEmpty()) {
            return listCus.size();
        }
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvID = (TextView) convertView.findViewById(R.id.tvID);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        final ConstraintLayout constraintLayout = (ConstraintLayout) convertView.findViewById(R.id.idConstraint);
        final Customer customer = listCus.get(position);

        if (listCus != null && !listCus.isEmpty()) {
            tvID.setText(""+customer.getId());
            tvName.setText(customer.getName());
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, customer.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                tempIndex = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            constraintLayout.setBackgroundColor(Color.BLUE);
        } else {
            constraintLayout.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }

}
