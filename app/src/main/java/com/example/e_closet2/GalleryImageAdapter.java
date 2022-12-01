package com.example.e_closet2;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

class GalleryImageAdapter extends BaseAdapter {
    public static Context mContext;
    private final List<Bitmap> bitmaps;

    public GalleryImageAdapter(Context context, List<Bitmap> bitmaps) {
        mContext = context;
        this.bitmaps = bitmaps;
        Log.d("hello", "hellohello");
    }


    @Override
    public int getCount() {
        return bitmaps.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int index, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = new ViewHolder();
        ViewHolderCheckBox viewHolderCheckBox = new ViewHolderCheckBox();
        ViewHolderDelete viewHolderDelete = new ViewHolderDelete();

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.ungued_images, viewGroup, false);

        viewHolder.icon = rowView.findViewById(R.id.imagetest);
        viewHolder.icon.setImageBitmap(bitmaps.get(index));

        viewHolderCheckBox.iconCheckBox = rowView.findViewById(R.id.checkbox);
        viewHolderDelete.iconDelete = rowView.findViewById(R.id.imageButtonDelete);

        return rowView;
    }
}
class ViewHolder {
    ImageView icon;
}
class ViewHolderCheckBox {
    CheckBox iconCheckBox;
}
class ViewHolderDelete {
    ImageButton iconDelete;
}