package com.example.homework7.ui.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.homework7.R;
import com.example.homework7.databinding.FragmentListBinding;
import com.example.homework7.ui.fragments.home.model.ModelData;

public class ListFragment extends Fragment {
   private FragmentListBinding binding;
   ModelData modelData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentListBinding.inflate(inflater,container,false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
        getData();

    }

    private void getData() {
         if (getArguments() != null) {
             modelData = (ModelData) getArguments().getSerializable("put");
             binding.textGet.setText((CharSequence) modelData);
         }
    }

    private void listeners() {
        binding.btnToSendData.setOnClickListener(view -> {
//            Navigation.findNavController(view).navigate(R.id.homeFragment);
            String data= binding.etData.getText().toString();
            if (data.isEmpty()){
                binding.etData.setError("Input text");
            }
            else {
                modelData = new ModelData(data);
                Bundle bundle=new Bundle();
                bundle.putSerializable("key",modelData);
                Navigation.findNavController(view).navigate(R.id.homeFragment,bundle);


            }
    });

}
}