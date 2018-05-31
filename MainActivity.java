package com.yk.zxs.lrc_view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hw.lrcviewlib.LrcDataBuilder;
import com.hw.lrcviewlib.LrcRow;
import com.hw.lrcviewlib.LrcView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LrcView lrcView1,lrcView2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        imageView = findViewById(R.id.imageview);
        lrcView1 = findViewById(R.id.au_lrcView);
        lrcView2 = findViewById(R.id.au_lrcView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                lrcView2.setVisibility(View.GONE);
                lrcView1.setVisibility(View.VISIBLE);
                initdata(lrcView1);
            }
        });
      lrcView1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              lrcView1.setVisibility(View.GONE);
              lrcView2.setVisibility(View.VISIBLE);
              imageView.setVisibility(View.VISIBLE);
              initdata(lrcView2);
          }
      });
    }

    private void initdata(LrcView view) {

        List<LrcRow> lrcRows = new LrcDataBuilder().BuiltFromAssets(this, "test2.lrc");
        //ro  List<LrcRow> lrcRows = new LrcDataBuilder().Build(file);
        //mLrcView.setTextSizeAutomaticMode(true);//是否自动适配文字大小

        //init the lrcView
        view.getLrcSetting()
                .setTimeTextSize(40)//时间字体大小
                .setSelectLineColor(Color.parseColor("#ffffff"))//选中线颜色
                .setSelectLineTextSize(25)//选中线大小
                .setHeightRowColor(Color.parseColor("#aaffffff"))//高亮字体颜色
                .setNormalRowTextSize(DisPlayUtil.sp2px(this, 17))//正常行字体大小
                .setHeightLightRowTextSize(DisPlayUtil.sp2px(this, 17))//高亮行字体大小
                .setTrySelectRowTextSize(DisPlayUtil.sp2px(this, 17))//尝试选中行字体大小
                .setTimeTextColor(Color.parseColor("#ffffff"))//时间字体颜色
                .setTrySelectRowColor(Color.parseColor("#55ffffff"));//尝试选中字体颜色

        view.commitLrcSettings();
        view.setLrcData(lrcRows);
    }
}
