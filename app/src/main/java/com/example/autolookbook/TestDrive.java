package com.example.autolookbook;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.autolookbook.databinding.ActivityTestDriveBinding;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import android.graphics.Color;
import android.widget.Toast;
import java.util.List;

public class TestDrive extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityTestDriveBinding binding;
    private DirectionsService directionsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTestDriveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        directionsService = retrofit.create(DirectionsService.class);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ottawa = new LatLng(45.4215, -75.6910);
        mMap.addMarker(new MarkerOptions().position(ottawa).title("Test cars available in Ottawa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ottawa, 7)); // Zoom level adjusted

        LatLng barrie = new LatLng(44.3894, -79.6903);
        mMap.addMarker(new MarkerOptions().position(barrie).title("Test cars available in Barrie"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barrie, 7)); // Zoom level adjusted

        LatLng origin = ottawa; // Ottawa
        LatLng destination = barrie; // Barrie
        getRoute(origin, destination);
    }

    private void getRoute(LatLng origin, LatLng destination) {
        String originStr = origin.latitude + "," + origin.longitude;
        String destinationStr = destination.latitude + "," + destination.longitude;

        Call<DirectionsResponse> call = directionsService.getDirections(
                originStr,
                destinationStr,
                "AIzaSyApT6haSmoMPOL7OjuGDZqTctl7YNl2qdE"
        );

        call.enqueue(new Callback<DirectionsResponse>() {
            @Override
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                if (response.isSuccessful()) {
                    DirectionsResponse directionsResponse = response.body();
                    if (directionsResponse != null && directionsResponse.getRoutes().length > 0) {
                        String polylinePoints = directionsResponse.getRoutes()[0].getPolylineOverview().getPoints();
                        List<LatLng> decodedPoints = PolyUtil.decode(polylinePoints);
                        PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.addAll(decodedPoints);
                        polylineOptions.color(Color.BLUE);
                        mMap.addPolyline(polylineOptions);
                    } else {
                        Toast.makeText(TestDrive.this, "No routes found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TestDrive.this, "Error fetching directions", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                Toast.makeText(TestDrive.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface DirectionsService {
        @GET("directions/json")
        Call<DirectionsResponse> getDirections(
                @Query("origin") String origin,
                @Query("destination") String destination,
                @Query("key") String apiKey
        );
    }

    public class DirectionsResponse {
        @SerializedName("routes")
        private Route[] routes;

        public Route[] getRoutes() {
            return routes;
        }

        public void setRoutes(Route[] routes) {
            this.routes = routes;
        }
    }

    public class Route {
        @SerializedName("overview_polyline")
        private PolylineOverview polylineOverview;

        public PolylineOverview getPolylineOverview() {
            return polylineOverview;
        }

        public void setPolylineOverview(PolylineOverview polylineOverview) {
            this.polylineOverview = polylineOverview;
        }
    }

    public class PolylineOverview {
        @SerializedName("points")
        private String points;

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }
    }
}
