package com.example.myweixin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private Fragment mtab01=new weixinFragment();
    private Fragment mtab02=new friendFragment();
    private Fragment mtab03=new contactFragment();
    private Fragment mtab04=new setFragment();
    private FragmentManager fm;

    private  LinearLayout mtabweixin;
    private  LinearLayout mtabfrd;
    private  LinearLayout mtabaddress;
    private  LinearLayout mtabset;
    private  ImageButton mimgweixin;
    private  ImageButton mimgfrd;
    private  ImageButton mimgaddress;
    private  ImageButton mimgset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
   initEvent();

        selectfragment(0);

    }
    private  void initFragment(){
        fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mtab01);
        transaction.add(R.id.id_content,mtab02);
        transaction.add(R.id.id_content,mtab03);
        transaction.add(R.id.id_content,mtab04);
        transaction.commit();
    }

    private  void initView(){

        mtabweixin=(LinearLayout) findViewById(R.id.weixin);
        mtabfrd=(LinearLayout) findViewById(R.id.frd);
        mtabaddress=(LinearLayout) findViewById(R.id.contact);
        mtabset=(LinearLayout) findViewById(R.id.setting);

        mimgweixin=findViewById(R.id.imageButton1);
        mimgfrd=findViewById(R.id.imageButton2);
        mimgaddress=findViewById(R.id.imageButton3);
        mimgset=findViewById(R.id.imageButton4);
    }
  private  void initEvent(){
        mtabweixin.setOnClickListener(this);
      mtabfrd.setOnClickListener(this);
      mtabaddress.setOnClickListener(this);
      mtabset.setOnClickListener(this);
  }
    private void hidefragment(FragmentTransaction transaction){

        transaction.hide(mtab01);
        transaction.hide(mtab02);
        transaction.hide(mtab03);
        transaction.hide(mtab04);
    }
    private  void  selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        switch (i){
            case 0:
                transaction.show(mtab01);
                mimgweixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mtab02);
                mimgfrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mtab03);
                mimgaddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mtab04);
                mimgset.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v){
        resetimg();

        switch (v.getId()){
            case R.id.imageButton1:
                selectfragment(0);
              System.out.println(v.getId());
                break;
            case R.id.imageButton2:
                selectfragment(1);
                break;
            case R.id.imageButton3:
                selectfragment(2);
                break;
            case R.id.imageButton4:
                selectfragment(3);
                break;
            default:
                break;
        }

    }
    public  void  resetimg(){
        mimgweixin.setImageResource(R.drawable.tab_weixin_normal);
        mimgfrd.setImageResource(R.drawable.tab_find_frd_normal);
        mimgaddress.setImageResource(R.drawable.tab_address_normal);
        mimgset.setImageResource(R.drawable.tab_settings_normal);
    }

}

