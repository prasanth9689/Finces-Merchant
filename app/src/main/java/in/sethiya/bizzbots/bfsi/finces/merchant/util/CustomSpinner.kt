package `in`.sethiya.bizzbots.bfsi.finces.merchant.util

import android.content.Context
import android.util.AttributeSet
import android.widget.Spinner

class CustomSpinner : Spinner {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun setSelection(position: Int, animate: Boolean) {
        val sameSelected = position == selectedItemPosition
        super.setSelection(position, animate)
        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually
            onItemSelectedListener?.onItemSelected(this, selectedView, position, selectedItemId)
        }
    }

    override fun setSelection(position: Int) {
        val sameSelected = position == selectedItemPosition
        super.setSelection(position)

        if (selectedView != null) {
            return
        }

        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually
            onItemSelectedListener?.onItemSelected(this, selectedView, position, selectedItemId)
        }
    }
}
