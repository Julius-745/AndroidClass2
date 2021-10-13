package com.julius745.crudfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    private int resourceLayout;
    private Context mContext;

    public NoteAdapter(Context context, int resource, List<Note> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Note p = getItem(position);

        if (p != null) {
            TextView tt2 = (TextView) v.findViewById(R.id.content);

            if (tt2 != null) {
                tt2.setText(p.getContent());
            }
        }

        return v;
    }

}