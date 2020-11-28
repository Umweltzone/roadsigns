package info.metadude.kotlin.library.roadsigns.demo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import info.metadude.kotlin.library.roadsigns.RoadSign
import info.metadude.kotlin.library.roadsigns.demo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.roadSignView.type = RoadSign.Type.EnvironmentalBadge.Green
        ArrayAdapter.createFromResource(
            this,
            R.array.road_signs_array,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.selectionView.adapter = it
        }
        binding.selectionView.onItemSelectedListener = this
    }

    override fun onItemSelected(
        spinnerView: AdapterView<*>,
        itemView: View?,
        viewPosition: Int,
        rowId: Long
    ) {
        val item: String = spinnerView.getItemAtPosition(viewPosition) as String
        binding.roadSignView.type = item.roadSignType
    }

    override fun onNothingSelected(parent: AdapterView<*>) = Unit

    private val String.roadSignType: RoadSign.Type
        get() {
            when (this) {
                getString(R.string.sign_none) ->
                    return RoadSign.Type.None
                getString(R.string.environmental_badges_content_description_green) ->
                    return RoadSign.Type.EnvironmentalBadge.Green
                getString(R.string.environmental_badges_content_description_yellow_green) ->
                    return RoadSign.Type.EnvironmentalBadge.YellowGreen
                getString(R.string.environmental_badges_content_description_red_yellow_green) ->
                    return RoadSign.Type.EnvironmentalBadge.RedYellowGreen
                // Same for Berlin
                getString(R.string.diesel_prohibition_cars_free_until_euro_5_v_open_for_residents) ->
                    return RoadSign.Type.DieselProhibition.CarsFreeUntilEuro5VOpenForResidentsHamburg
                getString(R.string.diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg) ->
                    return RoadSign.Type.DieselProhibition.HgvsFreeUntilEuroVOpenForResidentsHamburg
                getString(R.string.diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart) ->
                    return RoadSign.Type.DieselProhibition.FreeAsOfEuro5VExceptDeliveryVehiclesStuttgart
                getString(R.string.prohibition_cars_free_until_euro_5_petrol_until_euro_2_darmstadt) ->
                    return RoadSign.Type.DieselProhibition.CarsFreeUntilEuro5PetrolUntilEuro2Darmstadt
                getString(R.string.prohibition_hgvs_cars_free_until_euro_5_v_petrol_until_euro_2_darmstadt) ->
                    return RoadSign.Type.DieselProhibition.HgvsCarsFreeUntilEuro5VPetrolUntilEuro2Darmstadt
            }
            throw IllegalStateException("Unknown item value: $this")
        }

}
