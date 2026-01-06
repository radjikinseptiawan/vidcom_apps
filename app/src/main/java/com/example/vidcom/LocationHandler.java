package com.example.vidcom;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import java.util.List;
import java.util.Locale;

public class LocationHandler {
    private FusedLocationProviderClient fusedLocationClient;
    private Context context;

    public LocationHandler(Context context) {
        this.context = context;
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
    }

    public void updateLanguageBasedOnLocation() {
        // Cek permission terlebih dahulu (asumsi permission sudah diberikan)
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                String countryCode = getCountryCode(location.getLatitude(), location.getLongitude());
                setAppLanguage(countryCode);
            }
        });
    }

    private String getCountryCode(double lat, double lng) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            if (addresses != null && !addresses.isEmpty()) {
                // Mengambil kode negara (misal: "ID", "US", "JP")
                return addresses.get(0).getCountryCode().toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "en"; // Default ke inggris jika gagal
    }

    private void setAppLanguage(String langCode) {
        // Mengubah bahasa aplikasi secara runtime
        LocaleListCompat appLocale = LocaleListCompat.forLanguageTags(langCode);
        AppCompatDelegate.setApplicationLocales(appLocale);
    }
}