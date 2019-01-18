package xyz.ariefbayu.xyzmiscfeatures

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_vibrate.*

class VibrateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        val vibrate = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val canVibrate = vibrate.hasVibrator()

        btnVibrateOnce.setOnClickListener {
            if(canVibrate) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrate.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrate.vibrate(100)
                }
            } else {
                Toast.makeText(this, "No vibration support", Toast.LENGTH_LONG).show()
            }
        }

        btnVibrateEffect.setOnClickListener {
            if(canVibrate) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val pattern = longArrayOf(0, 100, 100, 100, 100, 500, 100, 100, 100, 100, 100, 100, 100)
                    val effect = VibrationEffect.createWaveform(pattern, -1)
                    vibrate.vibrate(effect)
                } else {
                    vibrate.vibrate(100)
                }
            } else {
                Toast.makeText(this, "No vibration support", Toast.LENGTH_LONG).show()
            }
        }
    }
}
