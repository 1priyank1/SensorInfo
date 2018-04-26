package priyank.patel.sensorinfo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    // Initializing an empty ArrayList to be filled with sensors
    val sensors: ArrayList<SensorData> = ArrayList()
    private var mSensorManager: SensorManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addSensors()

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors = mSensorManager?.getSensorList(Sensor.TYPE_ALL) as List<Sensor>

        //var deviceSensors: List<Sensor> = mSensorManager?.getSensorList(Sensor.TYPE_ALL)
        for(sensor in deviceSensors) {
            Log.d(TAG, "sensor name : " + sensor.name)
        }

        //getting recyclerview from xml
        //val recyclerView = findViewById(R.id.sensor_recyclerview) as RecyclerView
        sensor_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        sensor_recyclerview.adapter = SensorAdapter(this, sensors, mSensorManager!!)

    }

    // Adds animals to the empty animals ArrayList
    fun addSensors() {
        sensors.add(SensorData("ACCELEROMETER", Sensor.TYPE_ACCELEROMETER))
        sensors.add(SensorData("AMBIENT_TEMPERATURE", Sensor.TYPE_AMBIENT_TEMPERATURE))
        sensors.add(SensorData("GRAVITY", Sensor.TYPE_GRAVITY))
        sensors.add(SensorData("GYROSCOPE", Sensor.TYPE_GYROSCOPE))
        sensors.add(SensorData("LIGHT", Sensor.TYPE_LIGHT))
        sensors.add(SensorData("LINEAR_ACCELERATION", Sensor.TYPE_LINEAR_ACCELERATION))
        sensors.add(SensorData("MAGNETIC_FIELD", Sensor.TYPE_MAGNETIC_FIELD))
        sensors.add(SensorData("PRESSURE", Sensor.TYPE_PRESSURE))
        sensors.add(SensorData("PROXIMITY", Sensor.TYPE_PROXIMITY))
        sensors.add(SensorData("RELATIVE_HUMIDITY", Sensor.TYPE_RELATIVE_HUMIDITY))
        sensors.add(SensorData("ROTATION_VECTOR", Sensor.TYPE_ROTATION_VECTOR))
        sensors.add(SensorData("ORIENTATION", Sensor.TYPE_ORIENTATION))
        sensors.add(SensorData("TEMPERATURE", Sensor.TYPE_TEMPERATURE))
    }
}
