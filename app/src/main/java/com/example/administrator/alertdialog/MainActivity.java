package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private AlertDialog dl;
    private AlertDialog.Builder build;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) this.findViewById(R.id.textview1);
        Button b1=(Button)this.findViewById(R.id.button1);
        Button b2=(Button)this.findViewById(R.id.button2);
        Button b3=(Button)this.findViewById(R.id.button3);
        Button b4=(Button)this.findViewById(R.id.button4);
        Button b5=(Button)this.findViewById(R.id.button5);
        Button b6=(Button)this.findViewById(R.id.button6);
        Button b7=(Button)this.findViewById(R.id.button7);
        View.OnClickListener listen=new View.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.button1:dialog1();break;
                    case R.id.button2:dialog2();break;
                    case R.id.button3:dialog3();break;
                    case R.id.button4:dialog4();break;
                    case R.id.button5:dialog5();break;
                    case R.id.button6:dialog6();break;
                    case R.id.button7:dialog7();break;
                }
            }
        };
        b1.setOnClickListener(listen);
        b2.setOnClickListener(listen);
        b3.setOnClickListener(listen);
        b4.setOnClickListener(listen);
        b5.setOnClickListener(listen);
        b6.setOnClickListener(listen);
        b7.setOnClickListener(listen);
    }
    public void dialog1(){
        dl=new AlertDialog.Builder(this).create();
        dl.setTitle("退出确定");
        dl.setMessage("你真的要走吗亲？");
        dl.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listen1=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                if(which==DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"是的",listen1);
        dl.setButton(DialogInterface.BUTTON_NEGATIVE,"等等",listen1);
        dl.show();
    }
    public void dialog2(){
        dl=new AlertDialog.Builder(this).create();
        dl.setTitle("提问");
        dl.setMessage("你觉得LOL是垃圾渣渣吗？");
        dl.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listen1=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String s="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        s="是的，超渣";break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        s="不渣";break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        s="不是很渣";break;
                }
                tv1.setText(s);
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"超渣",listen1);
        dl.setButton(DialogInterface.BUTTON_NEGATIVE,"不渣",listen1);
        dl.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listen1);
        dl.show();
    }
    public void dialog3(){
        dl=new AlertDialog.Builder(this).create();
        dl.setTitle("提问");
        dl.setMessage("你觉得LOL是神马？");
        dl.setIcon(android.R.drawable.ic_dialog_alert);
        final EditText et=new EditText(this);
        DialogInterface.OnClickListener listen1=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                tv1.setText("你觉得LOL是："+et.getText().toString());
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"提交",listen1);
        dl.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"RPG","ACT","FPS"};
        final boolean selected[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlisten=new DialogInterface.OnMultiChoiceClickListener(){
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                selected[which]=isChecked;
            }
        };
        build=new AlertDialog.Builder(this);
        build.setMultiChoiceItems(item,null,mlisten);
        dl=build.create();
        dl.setTitle("兴趣");
        DialogInterface.OnClickListener listen1=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String s="你选了：";
                for(int t=0;t<selected.length;t++){
                    if(selected[t]){
                        s=s+"\n"+item[t];
                    }
                }
                tv1.setText("s");
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"提交",listen1);
        dl.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"RPG","ACT","FPS"};
        final boolean selected[]=new boolean[item.length];
        DialogInterface.OnClickListener slisten=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String s="你选了"+item[which];
            }
        };
        build=new AlertDialog.Builder(this);
        build.setSingleChoiceItems(item,-1,slisten);
        dl=build.create();
        dl.setTitle("兴趣");
        DialogInterface.OnClickListener listen=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                String s="你选了：";
                for(int t=0;t<selected.length;t++){
                    if(t==which){
                        if(selected[t]) {
                            s = s + "\n" + item[t];
                        }
                    }
                }
                tv1.setText(s);
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"提交",listen);
        dl.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"RPG","ACT","FPS"};
        final boolean selected[]=new boolean[item.length];
        DialogInterface.OnClickListener slisten=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String s="你选了"+item[which];
                tv1.setText(s);
            }
        };
        build=new AlertDialog.Builder(this);
        build.setItems(item,slisten);
        dl=build.create();
        dl.setTitle("兴趣");
        DialogInterface.OnClickListener listen=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                dl.dismiss();
            }
        };
        dl.setButton(DialogInterface.BUTTON_NEGATIVE,"提交",listen);
        dl.show();
    }
    public void dialog7(){
        LayoutInflater inf=getLayoutInflater();
        View layout=inf.inflate(R.layout.activity_main,null);
        final EditText ed=(EditText) layout.findViewById(R.id.editText);
        dl=new AlertDialog.Builder(this).create();
        dl.setTitle("自定义");
        dl.setView(layout);
        DialogInterface.OnClickListener listen=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                tv1.setText(ed.getText().toString());
            }
        };
        dl.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listen);
        dl.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listen);
        dl.show();
    }
}
