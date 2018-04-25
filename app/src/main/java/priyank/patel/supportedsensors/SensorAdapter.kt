package priyank.patel.supportedsensors

import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class SensorAdapter(val sensorList: ArrayList<SensorData>, var sensorManager : SensorManager) : RecyclerView.Adapter<SensorAdapter.SensorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return SensorViewHolder(view)
    }


    override fun onBindViewHolder(holder: SensorViewHolder, position: Int) {
        holder.type.text = sensorList[position].name

        if (sensorManager.getDefaultSensor(sensorList[position].type) != null){
            // Success! There's a magnetometer.
            holder.available.text = "YES"
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
    }

}