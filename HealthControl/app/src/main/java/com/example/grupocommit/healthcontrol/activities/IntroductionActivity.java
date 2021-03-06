package com.example.grupocommit.healthcontrol.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.grupocommit.healthcontrol.R;
import com.example.grupocommit.healthcontrol.SliderAdapter;

public class IntroductionActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private Button mNextBtn, mBackBtn;

    private int mCurrentPage;

    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.btnNextPage);
        mBackBtn = (Button) findViewById(R.id.btnPreviousPage);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSlideViewPager.getCurrentItem() == mDots.length -1){
                    Intent intent = new Intent (IntroductionActivity.this, CadastroActivity.class);
                    startActivity(intent);
                }else{
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();


        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.introductionTransparent));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length >0){
            mDots[position].setTextColor(getResources().getColor(R.color.introductionWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage = i;
            if(i == 0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Avançar");
                mBackBtn.setText("");
            }else if(i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);

                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Finalizar");
                mBackBtn.setText("Voltar");
            }else{
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);

                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Avançar");
                mBackBtn.setText("Voltar");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
