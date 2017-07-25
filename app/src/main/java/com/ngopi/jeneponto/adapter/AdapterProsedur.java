package com.ngopi.jeneponto.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ngopi.jeneponto.R;
import com.ngopi.jeneponto.data.DataProsedur;

import java.util.List;


/**
 * Created by pranadana on 7/21/2017.
 */
public class AdapterProsedur extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataProsedur> item;

    public AdapterProsedur(Activity activity, List<DataProsedur> item){
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount(){
        return item.size();
    }

    @Override
    public Object getItem(int location){
        return item.get(location);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_izin, null);

        TextView izin = (TextView) convertView.findViewById(R.id.izin);

        DataProsedur data;
        data = item.get(position);

        izin.setText(data.getNamaIzin());

        return convertView;
    }
}
