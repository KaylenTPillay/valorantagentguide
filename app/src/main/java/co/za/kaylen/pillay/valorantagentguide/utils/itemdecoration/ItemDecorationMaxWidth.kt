package co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylen.pillay.valorantagentguide.R
import co.za.kaylen.pillay.valorantagentguide.utils.getDisplayDimension

class ItemDecorationMaxWidth : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val margin = getMargin(view.context)
        outRect.left = margin
        outRect.right = margin
    }

    companion object {
        private var currentAdjustmentMargin: Int = 0
        private var currentDisplayDimension: Point = Point()

        private fun getMargin(context: Context): Int {
            val displayDimension = context.getDisplayDimension()
            if (currentDisplayDimension != displayDimension) {
                currentDisplayDimension = displayDimension
                val maxWidth = context.resources.getDimensionPixelSize(R.dimen.dimen_600)
                val screenWidth = currentDisplayDimension.x
                val availableSpace = (screenWidth - maxWidth)

                currentAdjustmentMargin = if (availableSpace <= 0) {
                    0
                } else {
                    availableSpace / 2
                }
            }

            return currentAdjustmentMargin
        }
    }
}