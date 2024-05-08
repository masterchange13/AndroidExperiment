package com.mao.wechat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment1,fragment2,fragment3,fragment4;
    FragmentManager fm;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        // LinearLayout对象，对应的id是bottom.xml文件中的第二层LinearLayout的id
        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);
        linearLayout4=findViewById(R.id.LinearLayout4);


        fm=getSupportFragmentManager();
        initial();
        fragmenthide();
        fragmentshow(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }

    //隐藏其他项
    private void fragmenthide() {
        FragmentTransaction ft=fm.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        ft.commit();
    }

    //初始化，将所有fragment都添加到界面中部板块
    //对应的id是Activitymain.xml中的Fragment的id
    private void initial() {
        fm=getSupportFragmentManager();
        //用content是因为main.xml用的名字是content(android:id="@+id/content")
        FragmentTransaction ft=fm.beginTransaction()
                .add(R.id.content,fragment1)
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                .add(R.id.content,fragment4);
        ft.commit();
    }
    //点击触发通过监听获取组件id，根据获取得到的id，展示对应的板块
    @Override
    public void onClick(View view){
        fragmenthide();
        int id=view.getId();
        removeBackgroundColor();
        if(id==R.id.LinearLayout1)
            linearLayout1.setBackgroundColor(Color.RED);
            fragmentshow(fragment1);
        if(id==R.id.LinearLayout2)
            linearLayout2.setBackgroundColor(Color.RED);
            fragmentshow(fragment2);
        if(id==R.id.LinearLayout3)
            linearLayout3.setBackgroundColor(Color.RED);
            fragmentshow(fragment3);
        if(id==R.id.LinearLayout4)
            linearLayout4.setBackgroundColor(Color.RED);
            fragmentshow(fragment4);
    }
    //展示
    private void fragmentshow(Fragment fragment){
        FragmentTransaction transaction=fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }

    public void removeBackgroundColor(){
        linearLayout1.setBackground(null);
        linearLayout2.setBackground(null);
        linearLayout3.setBackground(null);
        linearLayout4.setBackground(null);
    }
}