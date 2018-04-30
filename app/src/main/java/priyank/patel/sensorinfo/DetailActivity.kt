package priyank.patel.sensorinfo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*


class DetailActivity : AppCompatActivity() {

    val TAG = "DetailActivity"
    private var mSensorManager: SensorManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val sensorType = intent.extras.getInt("TYPE")
        Log.d(TAG, "sensorType : " + sensorType)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (mSensorManager?.getDefaultSensor(sensorType) != null) {
            val sensors = mSensorManager?.getSensorList(sensorType) as List<Sensor>
            Log.d(TAG, "sensor size : " + sensors.size)
            for (i in sensors.indices) {
                Log.d(TAG, "sensor name : " + sensors[i])

                name_text.text = "Name: " + sensors[i].name
                type_text.text = "Type: " + sensors[i].type
                type_text.visibility = View.GONE
                vendor_text.text = "Vendor: " +  sensors[i].vendor
                version_text.text = "Version: " + sensors[i].version
                power_text.text = "Power: " + sensors[i].power + " mA"
                max_range_text.text = "Maximum range: " + sensors[i].maximumRange
                min_delay_text.text = "Minimum Delay: " + sensors[i].minDelay + " ms"
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    max_delay_text.visibility = View.VISIBLE
                    max_delay_text.text = "Maximum Delay: " + sensors[i].maxDelay + " ms"
                    reporting_mode_text.visibility = View.VISIBLE
                    reporting_mode_text.text = "Reporting Mode: " + sensorReportingModeToString(sensors[i].reportingMode)
                }
            }
        }
    }

    fun sensorReportingModeToString(reportingMode: Int) : String {
        when (reportingMode) {
            Sensor.REPORTING_MODE_CONTINUOUS
            -> return "Continuous"
            Sensor.REPORTING_MODE_ONE_SHOT
            -> return "One-shot"
            Sensor.REPORTING_MODE_ON_CHANGE
            -> return "On-change"
            Sensor.REPORTING_MODE_SPECIAL_TRIGGER
            -> return "Special"
            else
            -> return "Unknown"
        }
    }


}
