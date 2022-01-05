package com.example.homework7.ui.fragments.home;

import static com.example.homework7.R.id.listFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.homework7.databinding.FragmentHomeBinding;
import com.example.homework7.listeners.OnItemClickListener;
import com.example.homework7.ui.fragments.home.adapter.AdapterData;
import com.example.homework7.ui.fragments.home.model.ModelData;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    ArrayList<ModelData> list = new ArrayList<>();
    AdapterData adapterData;
    ModelData modelData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterData = new AdapterData();
        binding.recycleviewHomeFragment.setAdapter(adapterData);
        listeners();
        getData();
        setClick();
    }

    private void setClick() {
        adapterData.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(ModelData modelData) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("put", modelData);
                Navigation.findNavController(requireView()).navigate(listFragment, bundle);
                Log.e("tag", "tag");
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("bool", true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            Log.i("Dev", "not null");
        } else {
            Log.i("Dev", "null");
        }
    }


    private void listeners() {
        binding.btnOpen.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(listFragment);
        });

//        adapterData.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClickListener(ModelData modelData) {
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("put",modelData );
//                Navigation.findNavController(requireView()).navigate(listFragment, bundle);
//            }
//        });
    }


    private void getData() {
        if (getArguments() != null) {
            modelData = (ModelData) getArguments().getSerializable("key");
            adapterData.addData(modelData);
        }

    }
}
