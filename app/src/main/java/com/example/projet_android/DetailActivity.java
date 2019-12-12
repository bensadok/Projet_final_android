package com.example.projet_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.projet_android.Fragments.Fragment_Detail;
import com.example.projet_android.Fragments.Fragment_plus_info;
import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.RootObject_UniqueAnime;
import com.example.projet_android.Models.UniqueAnime.UniqueAnime;
import com.example.projet_android.Utils.AnimeCalls;
import com.example.projet_android.Utils.AnimeUniqueCall;


public class DetailActivity extends AppCompatActivity {


    private Fragment_Detail fragment_detail;
    private Fragment_plus_info fragment_plus_info;
    private ViewPager viewPager;
    private RootObject_UniqueAnime rootObject_uniqueAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        setupViewPagerAndTabs();

    }

    private void setupViewPagerAndTabs() {
        fragment_detail = new Fragment_Detail();
        fragment_plus_info = new Fragment_plus_info();

        viewPager = findViewById(R.id.tab_viewpager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0)
                return fragment_detail;
            else
                return fragment_plus_info;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position){
            if(position==0)
                return fragment_detail.TAB_NAME;
            else
                return fragment_plus_info.TAB_NAME;
        }
    }







}
