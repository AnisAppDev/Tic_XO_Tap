package com.master.ticxotap

import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.master.ticxotap.databinding.ActivityPlayGameBinding

class PlayGameActivity : AppCompatActivity() {

    lateinit var binding : ActivityPlayGameBinding

    var flag: Int = 0
    var count :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityPlayGameBinding.inflate(layoutInflater)
       setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        binding.BtnClear.setOnClickListener {
            clearAllButton()
        }

    }

    fun CkeckValue(View:android.view.View)
    {
        val currentButton: Button = View as Button

        //check button value if not exists then add
        if(currentButton.text.toString().isEmpty()) {

            count++
            if (flag == 0) {
                currentButton.text = "X"
                flag = 1
            } else {
                currentButton.text = "O"
                flag = 0
            }

            when {
                // check after 4 move because of in 5 moves possible
                // made 1 pair either X or O
                count > 4 -> {
                    //store value of button for check win pair
                    var b1 = binding.Btn1.text.toString()
                    var b2 = binding.Btn2.text.toString()
                    var b3 = binding.Btn3.text.toString()
                    var b4 = binding.Btn4.text.toString()
                    var b5 = binding.Btn5.text.toString()
                    var b6 = binding.Btn6.text.toString()
                    var b7 = binding.Btn7.text.toString()
                    var b8 = binding.Btn8.text.toString()
                    var b9 = binding.Btn9.text.toString()

                    Log.d("b1", b1)
                    Log.d("b2", b2)
                    Log.d("b3", b3)
                    Log.d("b4", b4)
                    Log.d("b5", b5)
                    Log.d("b6", b6)
                    Log.d("b7", b7)
                    Log.d("b8", b8)
                    Log.d("b9", b9)

                    //Rows
                    //check 1 Row pair also check row not null
                    //if b1 means in row 1 button empty then condition false
                    if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                        Toast.makeText(this, "Row 1 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineHorizontal1.visibility = android.view.View.VISIBLE
                        binding.winLineHorizontal1.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_horizontal
                            )
                        )
                    }
                    // 2 Row
                    else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                        Toast.makeText(this, "Row 2 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineHorizontal2.visibility = android.view.View.VISIBLE
                        binding.winLineHorizontal2.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_horizontal
                            )
                        )
                    }
                    // 3 Row
                    else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                        Toast.makeText(this, "Row 3 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineHorizontal3.visibility = android.view.View.VISIBLE
                        binding.winLineHorizontal3.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_horizontal
                            )
                        )
                    }

                    //Columns

                    //1 Column
                    else if (b1.equals(b4) && b4.equals(b7) && b4.isNotEmpty()) {
                        Toast.makeText(this, "Coumn 1 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineVertical1.visibility = android.view.View.VISIBLE
                        binding.winLineVertical1.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_vertical
                            )
                        )
                    }
                    //2 Column
                    else if (b2.equals(b5) && b5.equals(b8) && b5.isNotEmpty()) {
                        Toast.makeText(this, "Coumn 2 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineVertical2.visibility = android.view.View.VISIBLE
                        binding.winLineVertical2.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_vertical
                            )
                        )
                    }
                    //3 Column
                    else if (b3.equals(b6) && b6.equals(b9) && b6.isNotEmpty()) {
                        Toast.makeText(this, "Coumn 3 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineVertical3.visibility = android.view.View.VISIBLE
                        binding.winLineVertical3.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_vertical
                            )
                        )
                    }

                    //Diagonals

                    //1 Diagonal left
                    else if (b1.equals(b5) && b5.equals(b9) && b5.isNotEmpty()) {
                        Toast.makeText(this, "Diagonal 1 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineDiagonal1.visibility = android.view.View.VISIBLE
                        binding.winLineDiagonal1.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_diagonal_left
                            )
                        )
                    }
                    //2 Diagonal right
                    else if (b3.equals(b5) && b5.equals(b7) && b5.isNotEmpty()) {
                        Toast.makeText(this, "Diagonal 2 Win", Toast.LENGTH_SHORT).show()

                        binding.winLineDiagonal2.visibility = android.view.View.VISIBLE
                        binding.winLineDiagonal2.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.line_diagonal_right
                            )
                        )
                    }
                }
            }

        }
    }

    private fun PlayGameActivity.clearAllButton() {
        binding.Btn1.text = ""
        binding.Btn2.text = ""
        binding.Btn3.text = ""
        binding.Btn4.text = ""
        binding.Btn5.text = ""
        binding.Btn6.text = ""
        binding.Btn7.text = ""
        binding.Btn8.text = ""
        binding.Btn9.text = ""

    }

}