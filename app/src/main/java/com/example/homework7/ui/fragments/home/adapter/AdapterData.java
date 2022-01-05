package com.example.homework7.ui.fragments.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework7.databinding.ListHolderDataBinding;
import com.example.homework7.listeners.OnItemClickListener;
import com.example.homework7.ui.fragments.home.model.ModelData;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    ArrayList<ModelData> list = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(ListHolderDataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.OnBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(ModelData modelData) {
        this.list.add(modelData);
        notifyDataSetChanged();

    }

    public class HolderData extends RecyclerView.ViewHolder {
        private ListHolderDataBinding binding;

        public HolderData(@NonNull ListHolderDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void OnBind(ModelData modelData) {
            binding.tvData.setText(modelData.getData());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(modelData);
                }
            });

        }
    }
}
