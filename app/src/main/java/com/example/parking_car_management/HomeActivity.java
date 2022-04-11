package com.example.parking_car_management;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;

    private FirebaseAuth firebaseAuth;

    private DrawerLayout drawer;

    private Button addbook, viewbook, deletebook, feedback, viewmachanic, findpetrolpump;
    private Button rent, viewslot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        addbook = findViewById(R.id.btn_addbooking);
        viewbook = findViewById(R.id.btn_viewbooking);
        deletebook = findViewById(R.id.btn_deletebooking);
        feedback = findViewById(R.id.btn_feedback);
        rent = findViewById(R.id.btn_slotrent);
        viewmachanic = findViewById(R.id.btn_viewmachanic);
        viewslot = findViewById(R.id.btn_slotview);
        findpetrolpump = findViewById(R.id.btn_findpetrolpump);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        addbook.setOnClickListener(this);
        viewbook.setOnClickListener(this);
        deletebook.setOnClickListener(this);
        feedback.setOnClickListener(this);
        viewmachanic.setOnClickListener(this);
        rent.setOnClickListener(this);
        viewslot.setOnClickListener(this);
        findpetrolpump.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.signout: {

                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            }

            case R.id.settings: {
                startActivity(new Intent(this, SettingActivity.class));
                break;
            }

            case R.id.about: {
                startActivity(new Intent(this, About.class));
                break;
            }

        }
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_tools:
                startActivity(new Intent(this, SettingActivity.class));
                break;

            /*case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ChatFragment()).commit();
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
*/
            case R.id.nav_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_about:
                startActivity(new Intent(this, About.class));
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onClick(View view) {

        if (view == addbook) {
            startActivity(new Intent(this, Add_Booking.class));
        }

        if (view == viewbook) {
            startActivity(new Intent(this, View_Booking.class));
        }

        if (view == deletebook) {
            startActivity(new Intent(this, Delete_Booking.class));
        }

        if (view == feedback) {
            startActivity(new Intent(this, Feedback.class));
        }

        if (view == viewmachanic) {
            startActivity(new Intent(this, viewMachanicDetails.class));
        }

        if (view == rent) {
            startActivity(new Intent(this, RentSlot.class));
        }

        if (view == viewslot) {
            startActivity(new Intent(this, ViewSlot.class));
        }
        if (view == findpetrolpump) {
            // Search for restaurants nearby
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=petrol pump");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
//            startActivity(new Intent(this, ViewSlot.class));




        }
    }
}
