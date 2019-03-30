package com.example.ganesh.driver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class LocationTracker extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    String bus_no;
    LocationManager locationManager;
    LocationListener locationListener;
    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_tracker);
        setUpMapIfNeeded();
        Bundle extras = getIntent().getExtras();
        bus_no = extras.getString("Value1");
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        //      .findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        //get the location service
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //request the location update thru location manager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            locationManager .requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get the latitude and longitude from the location
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    //Toast.makeText(getApplicationContext(), "Latitude :" + latitude + "  " + "Longitude :" + longitude + " ", Toast.LENGTH_SHORT).show();
                    //get the location name from latitude and longitude
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses =
                                geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addresses.get(0).getAddressLine(0) + ",";
                        str += addresses.get(0).getLocality() + ",";
                        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
                        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        Data_Handling(latitude,longitude);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
        else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager .requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get the latitude and longitude from the location
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                   // Toast.makeText(getApplicationContext(),"Latitude :"+latitude + "  " +"Longitude :"+ longitude + " ",Toast.LENGTH_SHORT).show();

                    //get the location name from latitude and longitude
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addresses.get(0).getAddressLine(0) + ",";
                        str += addresses.get(0).getLocality() + ",";
                        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
                        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

                        Data_Handling(latitude,longitude);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
    }
    public void Data_Handling(double latitude,double longitude){

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://shockable-medals.000webhostapp.com/insert.php?n1=" + latitude + "&n2=" + longitude + "&n3=" + bus_no);
            HttpResponse response = httpClient.execute(httppost);
            //Toast.makeText(getApplicationContext(), "Location Stored in Remote DataBase", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.43.157:3306/rec_transport", "root", "root");
            Statement st = con.createStatement();
            String query = "insert into transport values('" + latitude + "','" + longitude + "', '" + bus_no + "')";
            st.executeUpdate(query);
            Toast.makeText(getApplicationContext(), "user is added successfully" , Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }*/
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
