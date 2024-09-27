package de.tubs.cs.ias.firebaseanalyticstestbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import de.tubs.cs.ias.firebaseanalyticstestbed.databinding.FragmentExtendedFunctionalityBinding;

public class ExtendedFunctionality extends Fragment {

    private FragmentExtendedFunctionalityBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentExtendedFunctionalityBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "123456");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "itemId");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        ((MainActivity)this.getActivity()).mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public void onStart() {
        ((MainActivity)this.getActivity()).mFirebaseAnalytics.setUserProperty("custom_property","bikini-atoll");
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}