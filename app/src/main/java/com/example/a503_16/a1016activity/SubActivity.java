package com.example.a503_16.a1016activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        TextView title = (TextView)findViewById(R.id.title);
        //앞에 있는 Activity 에서 title 이라는 이름으로
        //넘겨준 문자열을 받아서 출력
        title.setText(getIntent().getStringExtra(
                "title"));
        final TextView textView = (TextView)findViewById(R.id.txtcount);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { value = value + 1;
                textView.setText(value + "");
            }
        });
    }

    //액티비ㅣ가 종료되기 직전에 호출되는 메소드
    //복원할 데이터 저장
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        //데이터 저장
        bundle.putInt("value", value);
    }

    //액티비티가 시작할 때 호출되는 메소드
    //데이터를 복원한다.

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int value =bundle.getInt("value");
        this.value = value;
        TextView textview = (TextView)findViewById(R.id.txtcount);
        textview.setText(value+"");
    }
}
