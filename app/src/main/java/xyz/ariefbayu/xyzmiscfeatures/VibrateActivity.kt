package xyz.ariefbayu.xyzmiscfeatures

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_vibrate.*

class VibrateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        val vibrate = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val canVirate = vibrate.hasVibrator()

        if(canVirate) {
            btnVibrateOnce.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrate.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrate.vibrate(100)
                }
            }

            btnVibrateEffect.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val pattern = longArrayOf(0, 100, 100, 100, 100, 500, 100, 100, 100, 100, 100, 100, 100)
                    val effect = VibrationEffect.createWaveform(pattern, -1)
                    vibrate.vibrate(effect)
                } else {
                    vibrate.vibrate(100)
                }
            }
        }
    }

}
