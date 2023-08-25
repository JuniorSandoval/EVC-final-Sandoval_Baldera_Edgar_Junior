package com.junior.evc_final__sandoval_baldera_edgar_junior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.junior.evc_final__sandoval_baldera_edgar_junior.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   private TextView txt_siguiente;
    private ViewPager viewPager;
    private LinearLayout lnl;
    private IntroPref introPref;
    private int[] layouts;
    private TextView[] dots;
   private MyViewPagerAdapter viewPagerAdapter;

    private SharedPreferences sharedPreferences;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introPref = new IntroPref(this);
        if(!introPref.isFirstTimeLaunch()){
            launchLoginScreen();
            finish();
        }

        txt_siguiente = findViewById(R.id.txt_siguiente);
        viewPager = findViewById(R.id.viewpager);
        lnl = findViewById(R.id.lnl);

        layouts = new int[]{
                R.layout.primera_intro,
                R.layout.segunda_intro,
                R.layout.tercera_intro
        };
        txt_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if(current < layouts.length){
                    viewPager.setCurrentItem(current);
                }else{
                    launchLoginScreen();
                }
            }
        });

        viewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        addBottomDots(0);

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position){
            addBottomDots(position);
            if(position == layouts.length -1){
                txt_siguiente.setText("INICIAR SESION");
            }else{
                txt_siguiente.setText("SIGUIENTE");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addBottomDots(int currentPage){
        dots = new TextView[layouts.length];
        int[] activeColors = getResources().getIntArray(R.array.active);
        int[] inActiveColors = getResources().getIntArray(R.array.inactive);
        lnl.removeAllViews();

        for(int i = 0; i < dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(inActiveColors[currentPage]);
            lnl.addView(dots[i]);
        }
        if(dots.length > 0){
            dots[currentPage].setTextColor(activeColors[currentPage]);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter{

        LayoutInflater layoutInflater;
        public MyViewPagerAdapter(){

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position){

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container,false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
            View view = (View) object;
            container.removeView(view);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + 1;
    }

    private void launchLoginScreen() {
        introPref.setIsFirstTimeLaunch(false);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE,MODE_PRIVATE);
        setContentView(binding.getRoot());
        boolean inSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
        if(inSessionActivated){
            Intent intent = new Intent(this,FruityActivity.class);
            startActivity(intent);
            finish();
        }
        binding.txtSiguiente.setOnClickListener(v -> {
            //Toast.makeText(this, "comenzar", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        });

        /*Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
        //startActivity(new Intent(MainActivity.this, LoginActivity.class));
        //finish();*/
    }
}