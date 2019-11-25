package com.example.measurementsconverter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapterTwo extends RecyclerView.Adapter<MainAdapterTwo.ViewHolder> {


    private  final List <Conversion> mConversions;

    public MainAdapterTwo(List<Conversion> conversions) {
        mConversions = conversions;
    }

    @NonNull
    @Override
    public MainAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.unit_adapter_item_two, parent,false);
        return new ViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull MainAdapterTwo.ViewHolder holder, int position) {
        final Conversion conversion = mConversions.get(position);
        holder.bindView(conversion);
    }

    @Override
    public int getItemCount() {
        return mConversions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }

        public void bindView(Conversion conversion) {
            mTextView.setText(conversion.mLabelRes);
        }
    }
}
