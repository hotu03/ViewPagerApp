package com.example.viewpageapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    MyViewPagerAdapter adapter;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);

        adapter = new MyViewPagerAdapter(
                // Phương thức thường được gọi trong một hoạt động hoặc phân đoạn để lấy phiên bản
                // của trình quản lý phân đoạn. Phiên bản được sử dụng ể thực hiện thêm, thay thế,
                // xóa các phân đoạn
                getSupportFragmentManager(),
                // Tham chiếu đến vòng đời của thành phần hiện tại cho phép quan sát các sự kiện
                // trong vòng đời
                getLifecycle()
        );

        // Thêm nhiều Fragment vào danh sách trong AdapterClass
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());

        // Thiết đặt hướng trong ViewPager2
        viewPager = findViewById(R.id.viewPager2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Kết nối Adapter với ViewPager2
        viewPager.setAdapter(adapter);

        // Kết nối TabLayout với ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                        tab.setText("Fragment "+(i+1));
                    }
                }
        ).attach();
        // .attach() là Phương thức gắn kèm để gắn bộ hòa giải bố cục tab (TabLayoutMediator)
        // vào bố cục tab và ViewPager
    }
}