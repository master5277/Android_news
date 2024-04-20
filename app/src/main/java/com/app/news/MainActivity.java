package com.app.news;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.news.db.UserDbHelper;
import com.app.news.entity.UserInfo;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.app.news.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] titles = {"娱乐", "军事", "教育", "文化", "健康", "财经", "体育", "汽车", "科技"};

    private List<TitleInfo> titles = new ArrayList<>();
//    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityMainBinding binding;

    private TabLayout tab_layout;
    private ViewPager2 viewPager;

    private NavigationView nav_view;
    private TextView  tv_username;
    private TextView tv_nickname;

    private ImageView btn_open_drawerLayout;
    private  DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据
        titles.add(new TitleInfo("推荐","top"));
        titles.add(new TitleInfo("国内","guonei"));
        titles.add(new TitleInfo("国际","guoji"));
        titles.add(new TitleInfo("娱乐","yule"));
        titles.add(new TitleInfo("体育","tiyu"));
        titles.add(new TitleInfo("军事","junshi"));
        titles.add(new TitleInfo("科技","keji"));
        titles.add(new TitleInfo("财经","caijing"));
        titles.add(new TitleInfo("游戏","youxi"));
        titles.add(new TitleInfo("汽车","qiche"));
        titles.add(new TitleInfo("健康","jiankang"));


        //初始化控件
        tab_layout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);
        nav_view = findViewById(R.id.nav_view);
        btn_open_drawerLayout = findViewById(R.id.btn_open_drawerLayout);
        drawerLayout = findViewById(R.id.drawer_layout);

        //不能直接findviewbyid下面两个
//        tv_username = findViewById(R.id.tv_username);
//        tv_nickname = findViewById(R.id.tv_nickname);
        tv_username = nav_view.getHeaderView(0).findViewById(R.id.tv_username);
        tv_nickname = nav_view.getHeaderView(0).findViewById(R.id.tv_nickname);
        //点击事件
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.nav_history)
                {
                 //跳转到历史记录
                    Intent intent = new Intent(MainActivity.this, HistoryListActivity.class);
                    startActivity(intent);
                }else if (menuItem.getItemId()==R.id.nav_update_pwd)
                {
                    //跳转到修改密码
                    Intent intent = new Intent(MainActivity.this,UpdatePwdActivity.class);
                    startActivity(intent);
                }else if (menuItem.getItemId()==R.id.nav_exit)
                {
                    UserInfo userInfo = UserInfo.getsUserInfo();
                    if (null!=userInfo)
                    {
                        //退出登录
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("温馨提示")
                                .setMessage("确认退出登录吗？")
                                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                        UserInfo.setsUserInfo(null);
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();

                    }else
                    {
                        Toast.makeText(MainActivity.this, "请先登录~~~", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });

        //打开抽屉
        btn_open_drawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        //viewPager需要设置一个adapter
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                String title = titles.get(position).getPy_title();
                TabNewsFragment tabNewsFragment = TabNewsFragment.newInstance(title);
                return tabNewsFragment;
            }

            @Override
            public int getItemCount() {
                return titles.size();
            }
        });

        //tab_layout的点击事件
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //设置viewPager选中当前页
                viewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //tablayout与viewPager关联在一起
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tab_layout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                tab.setText(titles.get(i).getTitle());
            }
        });

        //这句话不可以少
        tabLayoutMediator.attach();

    }

    @Override
    protected void onResume() {
        super.onResume();
        UserInfo userInfo = UserInfo.getsUserInfo();
        if (null!=userInfo)
        {
            tv_username.setText(userInfo.getUsername());
            tv_nickname.setText(userInfo.getNickname());
        }else
        {
            tv_username.setText("请登录");
            tv_nickname.setText("");
            //登录点击事件
            tv_username.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

}