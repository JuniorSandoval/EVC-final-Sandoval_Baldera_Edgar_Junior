package com.junior.evc_final__sandoval_baldera_edgar_junior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;
import com.junior.evc_final__sandoval_baldera_edgar_junior.databinding.ActivityFruityBinding;
import com.junior.evc_final__sandoval_baldera_edgar_junior.data.fragments.HomeFragment;

public class FruityActivity extends AppCompatActivity {

    private ActivityFruityBinding binding;
    public static String EMAIL = "EMAIL";
    private String email;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFruityBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.tbFrityvice);
        //setSession();
        addHomeFragment();

    }

    private void addHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(binding.fcvMain.getId(), new HomeFragment()).commit();
    }

    /*private void setSession() {
        Intent getIntent = getIntent();
        email = getIntent.getStringExtra(EMAIL);
        binding.txtEmail.setText(email);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.movies_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.List_favorite){
            Snackbar.make(binding.getRoot(), "Lista de favoritos", Snackbar.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId() == R.id.logout){
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }
}