package com.example.measurementsconverter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private  final List <Conversion> mConversions;
    private  final OnDimensionListener mOnDimensionListener;

    public MainAdapter(List<Conversion> conversions, OnDimensionListener onDimensionListener) {
        mConversions = conversions;
        mOnDimensionListener = onDimensionListener;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.unit_adapter_item, parent,false);
        return new ViewHolder(view, mOnDimensionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        final Conversion conversion = mConversions.get(position);
        holder.bindView(conversion);
    }

    @Override
    public int getItemCount() {
        return mConversions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private OnDimensionListener onDimensionListener;

        public ViewHolder(@NonNull View itemView, OnDimensionListener onDimensionListener) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
            this.onDimensionListener = onDimensionListener;

            itemView.setOnClickListener(this);
        }

        public void bindView(Conversion conversion) {
            mTextView.setText(conversion.mLabelRes);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onDimensionListener.onDimensionClick(adapterPosition);
            }
        }
    }

    public interface OnDimensionListener{
        void onDimensionClick(int position);
    }
}
