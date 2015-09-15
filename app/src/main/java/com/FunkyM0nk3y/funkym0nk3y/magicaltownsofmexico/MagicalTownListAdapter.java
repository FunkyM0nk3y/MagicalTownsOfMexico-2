package com.FunkyM0nk3y.funkym0nk3y.magicaltownsofmexico;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FunkyM0nk3y on 8/29/15.
 */
public class MagicalTownListAdapter extends BaseAdapter {
    Context context;
    List<MagicalTown> rowItems;

    public MagicalTownListAdapter(Context context, List<MagicalTown> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater lay = (LayoutInflater) context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);

            convertView = lay.inflate(R.layout.list_view, parent, false);
        }

        TextView magicaltown = (TextView) convertView.findViewById(R.id.magicaltown);
        TextView state = (TextView) convertView.findViewById(R.id.state);

        MagicalTown r = rowItems.get(position);
        magicaltown.setText(r.getMagicaltown());
        state.setText(r.getState());

        return convertView;
    }
}
