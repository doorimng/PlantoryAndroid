package com.example.plantoryandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestActivity extends AppCompatActivity {

    public static int[] questConditonList = Data.questList ;
    int nutrition = Data.nutritionCnt; //  영양제 3번
    int water = Data.waterCnt; // 물 5번
    int flower = Data.flower ; // 꽃 핌
    int fruit = Data.fruit ; // 열매 열림
    int ventilation = Data.ventilation ; // 환기 팬 작동
    int reset = Data.reset ; // reset버튼 누름
    int goodDay = Data.goodDay ; // 7일 연속 기분 좋음

    ImageButton quest1 = findViewById(R.id.quest1);
    ImageButton quest2 = findViewById(R.id.quest2);
    ImageButton quest3 = findViewById(R.id.quest3);
    ImageButton quest4 = findViewById(R.id.quest4);
    ImageButton quest5 = findViewById(R.id.quest5);
    ImageButton quest6 = findViewById(R.id.quest6);
    ImageButton quest7 = findViewById(R.id.quest7);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quest);

        // 도전과제
        Quest() ;

        // 도전과제 상태 갱신
        RenewalQuest();

    }

    /* [도전과제 시스템]
     * 도전과제 조건 충족할 경우 해금
     * */
    public void Quest() {
        if (nutrition == 3) {
            if (questConditonList[1] == 2) {
                questConditonList[1] = 0;
                quest1.setImageResource(R.drawable.quest_food);
            }
        }
        quest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[1] == 0) {
                    questConditonList[1] = 1;
                    quest1.setImageResource(R.drawable.quest_food_dark);
                }
            }
        });

        if (water == 5) {
            if (questConditonList[2] == 2) {
                questConditonList[2] = 0;
                quest2.setImageResource(R.drawable.quest_umbrella);
            }
        }
        quest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[2] == 0) {
                    questConditonList[2] = 1;
                    quest2.setImageResource(R.drawable.quest_umbrella_dark);
                }
            }
        });

        if (flower == 1) {
            if (questConditonList[3] == 2) {
                questConditonList[3] = 0;
                quest3.setImageResource(R.drawable.quest_hawaiian);
            }
        }
        quest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[3] == 0) {
                    questConditonList[3] = 1;
                    quest3.setImageResource(R.drawable.quest_hawaiian_dark);
                }
            }
        });

        if (fruit == 1) {
            if (questConditonList[4] == 2) {
                questConditonList[4] = 0;
                quest4.setImageResource(R.drawable.quest_hairclip);
            }
        }
        quest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[4] == 0) {
                    questConditonList[4] = 1;
                    quest4.setImageResource(R.drawable.quest_hairclip_dark);
                }
            }
        });

        if (ventilation == 1) {
            if (questConditonList[5] == 2) {
                questConditonList[5] = 0;
                quest5.setImageResource(R.drawable.quest_eyemask);
            }
        }
        quest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[5] == 0) {
                    questConditonList[5] = 1;
                    quest5.setImageResource(R.drawable.quest_eyemask_dark);
                }
            }
        });

        if (reset == 1) {
            if (questConditonList[6] == 2) {
                questConditonList[6] = 0;
                quest6.setImageResource(R.drawable.quest_dirty);
            }
        }
        quest6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[6] == 0) {
                    questConditonList[6] = 1;
                    quest6.setImageResource(R.drawable.quest_dirty_dark);
                }
            }
        });

        if (goodDay == 7) {
            if (questConditonList[7] == 2) {
                questConditonList[7] = 0;
                quest7.setImageResource(R.drawable.quest_sunglass);
            }
        }
        quest7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questConditonList[7] == 0) {
                    questConditonList[7] = 1;
                    quest7.setImageResource(R.drawable.quest_sunglass_dark);
                }
            }
        });

        Data.questList = questConditonList;
    }

    /* [도전과제 상태 갱신]
     * 현재 상태 고려한 도전과제 상태를 갱신
     * */
    public void RenewalQuest() {
            if ( questConditonList[1] == 0 ) quest1.setImageResource(R.drawable.quest_food) ;
            else if ( questConditonList[1] == 1 ) quest1.setImageResource(R.drawable.quest_food_dark) ;
            else quest1.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[2] == 0 ) quest2.setImageResource(R.drawable.quest_umbrella) ;
            else if ( questConditonList[2] == 1 ) quest2.setImageResource(R.drawable.quest_umbrella_dark) ;
            else quest2.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[3] == 0 ) quest3.setImageResource(R.drawable.quest_hawaiian) ;
            else if ( questConditonList[3] == 1 ) quest3.setImageResource(R.drawable.quest_hawaiian_dark) ;
            else quest3.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[4] == 0 ) quest4.setImageResource(R.drawable.quest_hairclip) ;
            else if ( questConditonList[4] == 1 ) quest4.setImageResource(R.drawable.quest_hairclip_dark) ;
            else quest4.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[5] == 0 ) quest5.setImageResource(R.drawable.quest_eyemask) ;
            else if ( questConditonList[5] == 1 ) quest5.setImageResource(R.drawable.quest_eyemask_dark) ;
            else quest5.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[6] == 0 ) quest6.setImageResource(R.drawable.quest_dirty) ;
            else if ( questConditonList[6] == 1 ) quest6.setImageResource(R.drawable.quest_dirty_dark) ;
            else quest6.setImageResource(R.drawable.lockeditemquest) ;

            if ( questConditonList[7] == 0 ) quest7.setImageResource(R.drawable.quest_sunglass) ;
            else if ( questConditonList[7] == 1 ) quest7.setImageResource(R.drawable.quest_sunglass_dark) ;
            else quest7.setImageResource(R.drawable.lockeditemquest) ;

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
    }
}