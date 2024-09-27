package de.tubs.cs.ias.firebaseanalyticstestbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import de.tubs.cs.ias.firebaseanalyticstestbed.databinding.FragmentInitializeBinding;

public class Initialize extends Fragment {

    private FragmentInitializeBinding binding;
    public CharSequence text = "3. State: Initialize (N/A)";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentInitializeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonInitialize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Initialize.this)
                        .navigate(R.id.action_Initialize_to_BasicFunctionality);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}