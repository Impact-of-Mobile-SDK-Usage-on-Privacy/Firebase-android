package de.tubs.cs.ias.firebaseanalyticstestbed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.EnumMap;
import java.util.Map;

import de.tubs.cs.ias.firebaseanalyticstestbed.databinding.FragmentConsentBinding;

public class Consent extends Fragment {

    private FragmentConsentBinding binding;
    public CharSequence text = "4. State: Consent";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentConsentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConsentTransmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)Consent.this.getActivity()).mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
                Consent.this.binding.textviewConsentTransmission.setText("Transmission: Yes");
            }
        });

        binding.buttonConsentYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)Consent.this.getActivity()).mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
                Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus> consentMap = new EnumMap<>(FirebaseAnalytics.ConsentType.class);
                consentMap.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, FirebaseAnalytics.ConsentStatus.GRANTED);
                ((MainActivity)Consent.this.getActivity()).mFirebaseAnalytics.setConsent(consentMap);
                Consent.this.binding.textviewConsent.setText(Consent.this.text + " [YES]");
                Consent.this.binding.textviewConsentTransmission.setText("Transmission: Yes");
            }
        });

        binding.buttonConsentNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)Consent.this.getActivity()).mFirebaseAnalytics.setAnalyticsCollectionEnabled(false);
                Consent.this.binding.textviewConsent.setText(Consent.this.text + " [NO]");
            }
        });

        binding.buttonConsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Consent.this)
                        .navigate(R.id.action_Consent_to_Initialize);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
