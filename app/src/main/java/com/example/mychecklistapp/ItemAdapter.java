package com.example.mychecklistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mychecklistapp.models.Item;
import com.example.mychecklistapp.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // Get current item
        Item currentItem = itemList.get(position);

        // Bind data to views
        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemTitle = convertView.findViewById(R.id.item_title);

        itemImage.setImageResource(currentItem.getPath());
        itemTitle.setText(currentItem.getName());

        return convertView;
    }
}
