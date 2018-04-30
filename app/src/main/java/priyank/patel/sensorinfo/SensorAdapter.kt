package priyank.patel.sensorinfo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class SensorAdapter(val context : Context, val sensorList: ArrayList<SensorData>, var sensorManager : SensorManager) : RecyclerView.Adapter<SensorAdapter.SensorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return SensorViewHolder(view)
    }


    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        holder.type.text = sensorTypeToString(sensorList[position].type)

        if(position == 0) {
            holder.available.text = "Available"
            holder.available.setTextColor(Color.BLACK)
            holder.type.setTextColor(Color.BLACK)
        }
        else if (sensorManager.getDefaultSensor(sensorList[position].type) != null){
            // Success! There's a magnetometer.
            holder.available.text = "YES"

            holder.layout.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("TYPE", sensorList[position].type)
                context.startActivity(intent)
            }
        }
        else {
            // Failure! No magnetometer.
            holder.available.text = "NO"
        }
    }

    override fun getItemCount(): Int {
        return sensorList.size
    }


    class SensorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val type = itemView.sensor_type
        val available = itemView.available
        val layout = itemView.sensor_layout

    }


    fun sensorTypeToString(sensorType: Int) : String {
        when (sensorType) {
            Sensor.TYPE_ACCELEROMETER
            -> return "Accelerometer"
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_TEMPERATURE
            -> return "Ambient Temperature"
            Sensor.TYPE_GAME_ROTATION_VECTOR
            -> return "Game Rotation Vector"
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR
            -> return "Geomagnetic Rotation Vector"
            Sensor.TYPE_GRAVITY
            -> return "Gravity"
            Sensor.TYPE_GYROSCOPE
            -> return "Gyroscope"
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED
            -> return "Gyroscope Uncalibrated"
            Sensor.TYPE_HEART_RATE
            -> return "Heart Rate Monitor"
            Sensor.TYPE_LIGHT
            -> return "Light"
            Sensor.TYPE_LINEAR_ACCELERATION
            -> return "Linear Acceleration"
            Sensor.TYPE_MAGNETIC_FIELD
            -> return "Magnetic Field"
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED
            -> return "Magnetic Field Uncalibrated"
            Sensor.TYPE_ORIENTATION
            -> return "Orientation"
            Sensor.TYPE_PRESSURE
            -> return "Orientation"
            Sensor.TYPE_PROXIMITY
            -> return "Proximity"
            Sensor.TYPE_RELATIVE_HUMIDITY
            -> return "Relative Humidity"
            Sensor.TYPE_ROTATION_VECTOR
            -> return "Rotation Vector"
            Sensor.TYPE_SIGNIFICANT_MOTION
            -> return "Significant Motion"
            Sensor.TYPE_STEP_COUNTER
            -> return "Step Counter"
            Sensor.TYPE_STEP_DETECTOR
            -> return "Step Detector"
            Sensor.TYPE_ALL
            -> return "Sensor"
            else
            -> return "Unknown"
        }
    }
}