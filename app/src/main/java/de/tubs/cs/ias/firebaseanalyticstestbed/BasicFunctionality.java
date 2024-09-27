package de.tubs.cs.ias.firebaseanalyticstestbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import de.tubs.cs.ias.firebaseanalyticstestbed.databinding.FragmentBasicFunctionalityBinding;
import java.util.Random;

public class BasicFunctionality extends Fragment {

    private FragmentBasicFunctionalityBinding binding;
    public CharSequence text = "5. State: Basic Func";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBasicFunctionalityBinding.inflate(inflater, container, false);

        binding.buttonLogEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                int value = new Random().nextInt(1000);

                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "" + value);
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "purchase " + value);
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "indicator");
                ((MainActivity)BasicFunctionality.this.getActivity()).mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                binding.textviewBasicFunctionality.setText("send item " + value);
            }
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onStart() {
        Bundle bundle = new Bundle();
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
