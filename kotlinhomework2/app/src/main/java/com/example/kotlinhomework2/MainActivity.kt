package com.example.kotlinhomework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Int3
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlin.random.Random

private lateinit var ed_name:EditText
private lateinit var tv_text:TextView
private lateinit var tv_name:TextView
private lateinit var tv_winner:TextView
private lateinit var tv_mmora:TextView
private lateinit var tv_cmora:TextView
private lateinit var btn_paper:RadioButton
private lateinit var btn_stone:RadioButton
private lateinit var btn_scissor:RadioButton
private lateinit var btn_mora:Button
private var computer:Int = 0
public const val random=3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_mora.setOnClickListener(){
            if (ed_name.length()<1)
                tv_text.setText("請輸入玩家姓名")
            else
                {
                    tv_name.setText(String.format("名字\n" + "%s", ed_name.toString()));
                   if (btn_scissor.isChecked)
                       tv_mmora.setText("我方出拳\n" + "剪刀")
                    else if (btn_stone.isChecked)
                       tv_mmora.setText("我方出拳\n" + "石頭")
                    else
                       tv_mmora.setText("我方出拳\n" + "布")

                    var computer : Int=0
                    Random(Int)

                    if (computer == 0)
                        tv_cmora.setText("電腦出拳\n" + "剪刀")
                    else if (computer==1)
                        tv_cmora.setText("電腦出拳\n" + "石頭")
                    else
                        tv_cmora.setText("電腦出拳\n" + "布")

                    if ((btn_scissor.isChecked && computer == 2)||
                        (btn_stone.isChecked && computer == 0) ||
                        (btn_paper.isChecked && computer == 1) ){
                        tv_winner.setText("勝利者\n"+ ed_name.toString())
                        tv_text.setText("恭喜你獲勝了!!!")
                    }else if ((btn_scissor.isChecked && computer == 1)||
                        (btn_stone.isChecked && computer == 2)||
                        (btn_paper.isChecked && computer == 0)){
                        tv_winner.setText("勝利者\n" + "電腦")
                        tv_text.setText("可惜，電腦獲勝了!")
                    }else{
                        tv_winner.setText("勝利者\n" + "平手")
                        tv_text.setText("平局，請再試一次！")
                    }
                }
        }
    }

    private fun Random(computer: Int.Companion): Random {
        return Random(Int)
    }
}