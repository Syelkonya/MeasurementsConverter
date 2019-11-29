//package com.example.measurementsconverter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class FromSpinnerAdapter extends BaseAdapter {
//
//    @Override
//    public int getCount() {
//        return Conversion.values().length;
//    }
//
//    @Override
//    public Conversion getItem(int position) {
//        return Conversion.values()[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(parent.getContext())
//                    .inflate(android.R.layout.simple_list_item_1, parent, false);
//            ViewHolder viewHolder = new ViewHolder(convertView);
//            convertView.setTag(viewHolder);
//        }
//        ViewHolder holder = (ViewHolder) convertView.getTag();
//        int unitLabelResources = getItem(position).getArrayOfUnits().get(position).getmLabelResources();
//        if (unitLabelResources != 0) {
//            holder.mMeasures.setText(unitLabelResources);
//        }
//        return convertView;
//    }
//
//    public void setConversion(Conversion selectedConversion) {
//    }
//
//
//    private class ViewHolder {
//        private final TextView mMeasures;
//
//        private ViewHolder(View view) {
//            mMeasures = view.findViewById(android.R.id.text1);
//        }
//    }
//
//
//}
//
