package vcmsa.ci.myfoodappassigment1

//ST10469661
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mealButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val time = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.mealButton)
        val food = findViewById<TextView>(R.id.SuggestionView)
        val reset = findViewById<Button>(R.id.ResetButton)

        //button
        button.setOnClickListener {
            var inputText = time.text.toString().trim().lowercase()
            val mealSuggestion = when (inputText) {
                "morning" -> {
                    "Morning: Scrambled eggs and toast"
                }

                "mid-morning" -> {
                    "Mid-Morning Snack: Dried Fruit and Smoothies"
                }

                "lunch" -> {
                    "Lunch: Fried Chicken Sandwich"
                }

                "late-noon" -> {
                    "Late-Noon Snack: Trail Mix with fruits or berries"
                }

                "supper" -> {
                    "Supper: Steak and Eggs"
                }

                else -> {
                    "Invalid input. Please Enter one of the above options."
                }
            }

            food.text = mealSuggestion

            reset.setOnClickListener {
                time.setText("")
                food.text = ""
            }
        }
    }
}