package de.tubs.cs.ias.firebaseanalyticstestbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import de.tubs.cs.ias.firebaseanalyticstestbed.databinding.FragmentCreateObjectBinding;

public class CreateObject extends Fragment {

    private FragmentCreateObjectBinding binding;
    public CharSequence text = "2. State: Create Object";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCreateObjectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCreateObjectAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)CreateObject.this.getActivity()).setFirebaseAnalytics(FirebaseAnalytics.getInstance(CreateObject.this.getActivity()));
                binding.textviewCreateObject.setText(text + " [CREATED]");
            }
        });

        binding.buttonCreateObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CreateObject.this)
                        .navigate(R.id.action_CreateObject_to_Consent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}