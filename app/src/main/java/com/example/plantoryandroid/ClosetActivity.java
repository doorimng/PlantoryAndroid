package com.example.plantoryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ClosetActivity extends AppCompatActivity {
    public static int[] itemInstall = Data.questList ;
    int condition = Data.condition, clothes = Data.clothes ;
    int[] conditionList = QuestActivity.questConditonList ;
    ImageView character = findViewById(R.id.imageCharacter) ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_closet);

        // 아이템 해금 시스템
        ItemUnlock() ;

        // 아이템 장착 시스템
        ItemInstall() ;

        // 장착 버튼
        InstallButton() ;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /* [아이템 해금 시스템]
     * 도전과제 달성 후 아이템 해금 시 아이템 사용 가능
     * */
    public void ItemUnlock() {
        character.setImageResource(Data.chracterID[condition][clothes]);

        if ( conditionList[1] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonFood) ;
            button.setImageResource(R.drawable.item_food) ;
        }
        if ( conditionList[2] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonUmbrella) ;
            button.setImageResource(R.drawable.item_umbrella) ;
        }
        if ( conditionList[3] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonHawaiian) ;
            button.setImageResource(R.drawable.item_hawaiian) ;
        }
        if ( conditionList[4] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonHairClip) ;
            button.setImageResource(R.drawable.item_hairclip) ;
        }
        if ( conditionList[5] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonEyeMask) ;
            button.setImageResource(R.drawable.item_eyemask) ;
        }
        if ( conditionList[6] == 1 ) {
            ImageButton button = findViewById(R.id.itemButtonDirty) ;
            button.setImageResource(R.drawable.item_dirty) ;
        }
        if ( conditionList[7] == 1) {
            ImageButton button = findViewById(R.id.itemButtonSunglass) ;
            button.setImageResource(R.drawable.item_sunglass) ;
        }

        ImageButton buttonEmpty = findViewById(R.id.itemButtonEmpty) ;
        buttonEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[0] == 1 ) {
                    clothes = 0 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;
    }

    /* [아이템 장착 시스템]
     * 해금되어있는 아이템 장착
     * */
    public void ItemInstall() {
        ImageButton buttonFood = findViewById(R.id.itemButtonFood) ;
        buttonFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[1] == 1 ) {
                    clothes = 1 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonUmbrella = findViewById(R.id.itemButtonUmbrella) ;
        buttonUmbrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[2] == 1 ) {
                    clothes = 2 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonHawaiian = findViewById(R.id.itemButtonHawaiian) ;
        buttonHawaiian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[3] == 1 ) {
                    clothes = 3 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonHairClip = findViewById(R.id.itemButtonHairClip) ;
        buttonHairClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[4] == 1 ) {
                    clothes = 4 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonEyeMask = findViewById(R.id.itemButtonEyeMask) ;
        buttonEyeMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[5] == 1 ) {
                    clothes = 5 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonDirty = findViewById(R.id.itemButtonDirty) ;
        buttonDirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[6] == 1 ) {
                    clothes = 6 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;

        ImageButton buttonSunglass = findViewById(R.id.itemButtonSunglass) ;
        buttonSunglass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( itemInstall[7] == 1 ) {
                    clothes = 7 ;
                    character.setImageResource(Data.chracterID[condition][clothes]) ;
                }
            }
        }) ;
    }

    /* [장착 버튼]
     * 장착 버튼 누를 시 알람과 함께 기본 캐릭터의 장착 아이템 변경 가능
     * */
    public void InstallButton() {
        Button button = findViewById(R.id.buttonInstallation) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView setChracter = MainActivity.character ;
                setChracter.setImageResource(Data.chracterID[condition][clothes]) ;
                Data.clothes = clothes ;

                String message = "장착!" ;

                Toast toast = Toast.makeText(ClosetActivity.this, message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        });
    }


}