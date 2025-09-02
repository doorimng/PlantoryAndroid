package com.example.plantoryandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// 라즈베리파이 연결
import android.widget.ImageView;
import android.widget.TextView ;

public class MainActivity extends AppCompatActivity {

    public static ImageView character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 점수 시스템
        Score() ;

        // 각 버튼 누를 경우 화면 전환
        ChangeActivity() ;

        // 초기화 버튼
        ImageButton quitButton = findViewById(R.id.buttonQuit) ;
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset() ;
            }
        });

        // 물이 부족할 때 알림
        if ( Data.water <= 20 ) WaterAlert() ;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /* [점수 시스템]
     *  토양 습도, 공기 중 온습도를 고려하여 100점만점의 점수 도입
     * if 80점 이상 : 웃는 표정 + "오늘은 기분이 좋아요!"
     * else if 50점 이상 : 정색 표정 + "오늘은 기분이 그저그래요."
     * else : 화난 표정 + "오늘은 기분이 별로예요."
     * */
    public void Score() {
        int final_score = Data.score ;
        TextView score = findViewById(R.id.textScore) ;
        score.setText(final_score+"점!") ;

        TextView ment = findViewById(R.id.textMent) ;
        character = findViewById(R.id.imageChracter) ;

        int clothes = 0, condition = 0 ;

        if ( final_score >= 80 ) {
            ment.setText("오늘은 기분이 좋아요!") ;
            condition = 2 ;
        }
        else if ( final_score >= 50 ) {
            ment.setText("오늘은 기분이 그저그래요.") ;
            condition = 1 ;
        }
        else {
            ment.setText("오늘은 기분이 별로예요.") ;
            condition = 0 ;
        }

        Data.clothes = clothes ;
        Data.condition = condition ;
        character.setImageResource(Data.chracterID[condition][clothes]) ;
    }

    public void ChangeActivity() {
        // [기능 버튼] 기능 창으로 이동
        ImageButton option = findViewById(R.id.optionButton) ;
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OptionActivity.class) ;
                startActivity(intent) ;
            }
        });

        // [옷장 버튼] 옷장 창으로 이동
        ImageButton closet = findViewById(R.id.closetButton) ;
        closet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class) ;
                startActivity(intent) ;
            }
        });

        // [도전과제 버튼] 도전과제 창으로 이동
        ImageButton quest = findViewById(R.id.questButton) ;
        quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestActivity.class) ;
                startActivity(intent) ;
            }
        });
    }

    /*
     * [초기화 버튼]
     * 예 - 모든 기록 초기화 (단, 해금된 아이템 및 도전과제는 다시 잠금되지 않음)
     * 아니오 - 변화 없음
     * */
    public void Reset() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this) ;
        builder.setTitle("알림")
                .setMessage("정말 딸기 키우기를 중단하시겠습니까?\n(모든 기록이 초기화됩니다.)")
                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if ( Data.nutritionCnt < 3 ) Data.nutritionCnt = 0 ;
                        if ( Data.waterCnt < 5 ) Data.waterCnt = 0 ;
                        if ( Data.goodDay < 7 ) Data.goodDay = 0 ;
                        Data.reset = 1 ;

                        Data.clothes = 0 ;
                        MainActivity.character.setImageResource(Data.chracterID[Data.condition][Data.clothes]) ;
                    }
                })
                .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }) ;
        AlertDialog dialog = builder.create() ;
        dialog.show() ;
    }

    // 물 부족 시 알람
    public void WaterAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this) ;
        builder.setTitle("물이 부족합니다!!")
                .setMessage("물통에 물을 채워주세요.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }) ;
        AlertDialog dialog = builder.create() ;
        dialog.show() ;
    }
}
