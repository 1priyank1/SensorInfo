package priyank.patel.sensorinfo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*


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
                Log.d(TAG, "sensor name : " + sensors[i].name)
                Log.d(TAG, "sensor type : " + sensors[i].type)
                Log.d(TAG, "sensor vendor : " + sensors[i].vendor)
                Log.d(TAG, "sensor version : " + sensors[i].version)
                Log.d(TAG, "sensor power : " + sensors[i].power)

                name_text.text = "Name : " + sensors[i].name
                type_text.text = "Type : " + sensors[i].type
                vendor_text.text = "Vendor : " +  sensors[i].vendor
                version_text.text = "Version : " + sensors[i].version
            }
        }

    }


}
