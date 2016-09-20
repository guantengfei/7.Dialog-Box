package com.example.a7dialog_box;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")//设置对话框标题

                        .setMessage("这是个对话框！")//设置显示的内容

                        .setNegativeButton("返回", new DialogInterface.OnClickListener() {//添加返回按钮


                            @Override

                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                // TODO Auto-generated method stub
                                Toast.makeText(MainActivity.this, "下课歇歇吧！", Toast.LENGTH_SHORT).show();


                            }

                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮


                    @Override

                    public void onClick(DialogInterface dialog, int which) {//响应事件

                        // TODO Auto-generated method stub

                        Toast.makeText(MainActivity.this, "上课好好听课！", Toast.LENGTH_SHORT).show();

                    }

                }).show();//在按键响应事件中显示此对话框


            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LayoutInflater是用来找layout文件夹下的xml布局文件，并且实例化
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                //把activity_login中的控件定义在View中
                final View textEntryView = factory.inflate(R.layout.login_activity, null);

                //将LoginActivity中的控件显示在对话框中
                new AlertDialog.Builder(MainActivity.this)
                        //对话框的标题
                        .setTitle("登陆")
                                //设定显示的View
                        .setView(textEntryView)
                                //对话框中的“登陆”按钮的点击事件
                        .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                //获取用户输入的“用户名”，“密码”
                                //注意：textEntryView.findViewById很重要，因为上面factory.inflate(R.layout.activity_login, null)将页面布局赋值给了textEntryView了
                                final EditText etUserName = (EditText) textEntryView.findViewById(R.id.etuserName);
                                final EditText etPassword = (EditText) textEntryView.findViewById(R.id.etPWD);

                                //将页面输入框中获得的“用户名”，“密码”转为字符串
                                String userName = etUserName.getText().toString().trim();
                                String password = etPassword.getText().toString().trim();

                                //现在为止已经获得了字符型的用户名和密码了，接下来就是根据自己的需求来编写代码了
                                //这里做一个简单的测试，假定输入的用户名和密码都是1则进入其他操作页面（OperationActivity）
                                if (userName.equals("abc") && password.equals("123")) {
                                    //跳转到OperationActivity
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(MainActivity.this, "密码或用户名错误", Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                                //对话框的“退出”单击事件
                        .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })

                                //对话框的创建、显示
                        .create().show();
            }
        });
    }
}