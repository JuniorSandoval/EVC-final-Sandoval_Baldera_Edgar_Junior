package com.junior.evc_final__sandoval_baldera_edgar_junior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.junior.evc_final__sandoval_baldera_edgar_junior.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private SharedPreferences sharedPreferences;
    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";
    public static String SESSION_ACTIVATED = "SESSION_ACTIVATED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);
        binding.btnLogin.setOnClickListener(v -> {
            //Toast.makeText(this,"login press",Toast.LENGTH_SHORT).show();
            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();
            Intent intent = new Intent(this, FruityActivity.class);
            intent.putExtra(FruityActivity.EMAIL, binding.tilEmail.getEditText().getText().toString());
            startActivity(intent);
            finish();
        });

        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                boolean isOk = isCredentialsValidate(s.toString(), binding.tilPassword.getEditText().getText().toString() );
                binding.btnLogin.setEnabled(isOk);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                boolean isOk = isCredentialsValidate(binding.tilEmail.getEditText().getText().toString(),s.toString());
                binding.btnLogin.setEnabled(isOk);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private boolean isCredentialsValidate(String email, String password){
        boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean isPasswordOk = password.length() >= 8;
        return isEmailOk && isPasswordOk;
    }
}