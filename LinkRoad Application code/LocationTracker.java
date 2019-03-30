package com.example.ganesh.rectransportmanagement;

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

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class LocationTracker extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    LocationManager locationManager;
    double latitude, longitude;
    String bus_no = null, result = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_tracker);
        setUpMapIfNeeded();
        Bundle extras = getIntent().getExtras();
        bus_no = extras.getString("Value1");
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
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
        datahandling();
        // checking whether network provider is enabled
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //Toast.makeText(getApplicationContext(), latitude + " " + longitude + " ", Toast.LENGTH_SHORT).show();
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getAddressLine(0) + ",";
                        str += addressList.get(0).getLocality() + ",";
                        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
                        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
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
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                   // Toast.makeText(getApplicationContext(), latitude + " " + longitude + " ", Toast.LENGTH_SHORT).show();
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getAddressLine(0) + ",";
                        str += addressList.get(0).getLocality() + ",";
                        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
                        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(str).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
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
    public void datahandling() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);
       /* try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://shockable-medals.000webhostapp.com/select.php?n1=" + bus_no);
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("log_tag", "connection success");
            Toast.makeText(getApplicationContext(), "Connection Successfull", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), "This is where the"+ bus_no + "is now", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Connection Failed" + e.getMessage(), Toast.LENGTH_LONG).show();
        }*/
        try {
            URL connectURL = new URL("https://shockable-medals.000webhostapp.com/select.php?n1=" + bus_no);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connectURL.openStream()));

            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                sb.append(inputLine);
            }
            //Toast.makeText(getApplicationContext(),""+sb.toString(),Toast.LENGTH_LONG).show();
            String[] strArray2 = sb.toString().split(Pattern.quote("split"));
            //Toast.makeText(getApplicationContext(), "" + strArray2[0] + strArray2[1], Toast.LENGTH_SHORT).show();
            latitude = Double.parseDouble(strArray2[0]);
            longitude = Double.parseDouble(strArray2[1]);
            in.close();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),""+ e,Toast.LENGTH_LONG).show();
        }
        /*try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"), 8);
            Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
            StringBuilder sb = new StringBuilder();
            String line = null;
            Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
            while((line = reader.readLine())!=null){
                sb.append(line + "\n");
            }
            result = sb.toString();
            Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result" + e.toString());
            Toast.makeText(getApplicationContext(), "Input reading fail", Toast.LENGTH_SHORT).show();
        }*/
       /* try {
            JSONArray jArray = new JSONArray(result);
            for (int i = -1; i < jArray.length() - 1; i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Toast.makeText(getApplicationContext(), " " + json_data.getDouble("Latitude"), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), " " + json_data.getDouble("Longitude"), Toast.LENGTH_SHORT).show();
                latitude = json_data.getDouble("Latitude");
                longitude = json_data.getDouble("Longitude");
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/
    }

}
