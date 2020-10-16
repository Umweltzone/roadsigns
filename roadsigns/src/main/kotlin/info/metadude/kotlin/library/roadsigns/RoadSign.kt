package info.metadude.kotlin.library.roadsigns

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class RoadSign : ConstraintLayout {

    sealed class Type {

        object None : Type()

        sealed class DieselProhibition : Type() {
            object CarsFreeUntilEuro5VOpenForResidentsBerlin : DieselProhibition()
            object CarsFreeUntilEuro5PetrolUntilEuro2Darmstadt : DieselProhibition()
            object HgvsCarsFreeUntilEuro5VPetrolUntilEuro2Darmstadt : DieselProhibition()
            object CarsFreeUntilEuro5VOpenForResidentsHamburg : DieselProhibition()
            object HgvsFreeUntilEuroVOpenForResidentsHamburg : DieselProhibition()
            object FreeAsOfEuro5VExceptDeliveryVehiclesStuttgart : DieselProhibition()
        }

        sealed class EnvironmentalBadge : Type() {
            object Green : EnvironmentalBadge()
            object YellowGreen : EnvironmentalBadge()
            object RedYellowGreen : EnvironmentalBadge()
        }
    }

    private val roadSignView by lazy { findViewById<ImageView>(R.id.genericRoadSignView) }

    var type: Type = defaultType
        set(value) {
            if (Type.None != value) {
                updateRoadSignView(value.toDrawableResource(), value.toContentDescription())
            }
            roadSignView.visibility = value.toVisibility()
            field = value
        }

    constructor(context: Context) : super(context, null) {
        inflateLayout(context)
        type = defaultType
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        inflateLayout(context)
        type = defaultType
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        inflateLayout(context)
        type = defaultType
    }

    private fun inflateLayout(context: Context?) {
        LayoutInflater.from(context).inflate(layout, this, true)
    }

    private fun updateRoadSignView(@DrawableRes drawableResource: Int, @StringRes contentDescription: Int) {
        val drawable =
            VectorDrawableCompat.create(context.resources, drawableResource, context.theme)
        roadSignView.setImageDrawable(drawable)
        roadSignView.contentDescription = context.getString(contentDescription)
        invalidate()
        requestLayout()
    }

    @StringRes
    private fun Type.toContentDescription() = when (this) {
        Type.None -> throw IllegalStateException("Nothing to describe!")
        Type.DieselProhibition.CarsFreeUntilEuro5VOpenForResidentsBerlin,
        Type.DieselProhibition.CarsFreeUntilEuro5VOpenForResidentsHamburg -> R.string.diesel_prohibition_cars_free_until_euro_5_v_open_for_residents
        Type.DieselProhibition.HgvsFreeUntilEuroVOpenForResidentsHamburg -> R.string.diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg
        Type.DieselProhibition.FreeAsOfEuro5VExceptDeliveryVehiclesStuttgart -> R.string.diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart
        Type.DieselProhibition.CarsFreeUntilEuro5PetrolUntilEuro2Darmstadt -> R.string.prohibition_cars_free_until_euro_5_petrol_until_euro_2_darmstadt
        Type.DieselProhibition.HgvsCarsFreeUntilEuro5VPetrolUntilEuro2Darmstadt -> R.string.prohibition_hgvs_cars_free_until_euro_5_v_petrol_until_euro_2_darmstadt
        Type.EnvironmentalBadge.Green -> R.string.environmental_badges_content_description_green
        Type.EnvironmentalBadge.YellowGreen -> R.string.environmental_badges_content_description_yellow_green
        Type.EnvironmentalBadge.RedYellowGreen -> R.string.environmental_badges_content_description_red_yellow_green
    }

    @DrawableRes
    private fun Type.toDrawableResource() = when (this) {
        Type.None -> throw IllegalStateException("Nothing to draw!")
        Type.DieselProhibition.CarsFreeUntilEuro5VOpenForResidentsBerlin,
        Type.DieselProhibition.CarsFreeUntilEuro5VOpenForResidentsHamburg -> R.drawable.ic_diesel_prohibition_cars_free_until_euro_5_v_open_for_residents
        Type.DieselProhibition.HgvsFreeUntilEuroVOpenForResidentsHamburg -> R.drawable.ic_diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg
        Type.DieselProhibition.FreeAsOfEuro5VExceptDeliveryVehiclesStuttgart -> R.drawable.ic_diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart
        Type.DieselProhibition.CarsFreeUntilEuro5PetrolUntilEuro2Darmstadt -> R.drawable.ic_prohibition_cars_diesel_free_until_euro_5_petrol_until_euro_2_darmstadt
        Type.DieselProhibition.HgvsCarsFreeUntilEuro5VPetrolUntilEuro2Darmstadt -> R.drawable.ic_prohibition_hvgs_cars_diesel_free_until_euro_5_v_petrol_until_euro_2_darmstadt
        Type.EnvironmentalBadge.Green -> R.drawable.ic_environmental_badges_green
        Type.EnvironmentalBadge.YellowGreen -> R.drawable.ic_environmental_badges_yellow_green
        Type.EnvironmentalBadge.RedYellowGreen -> R.drawable.ic_environmental_badges_red_yellow_green
    }

    private fun Type.toVisibility() = if (this == Type.None) View.GONE else View.VISIBLE

    private companion object {
        private val layout = R.layout.road_sign
        private val defaultType = Type.EnvironmentalBadge.RedYellowGreen
    }

}
