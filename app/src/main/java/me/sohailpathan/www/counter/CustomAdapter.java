package me.sohailpathan.www.counter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapter  extends BaseAdapter {

    private int image[];
    private String name[];
    private Context context;

    public CustomAdapter(Context context, int[] image, String[] name) {
        this.context = context;
        this.image = image;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlviewlayout, null);
        TextView tv1=convertView.findViewById(R.id.name);
        ImageView iv1=convertView.findViewById(R.id.image);
        tv1.setText(name[i]);
        iv1.setImageResource(image[i]);
        return  convertView;
    }
}
