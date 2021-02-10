package co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationVerticalSpacing(
    private val firstItemTopMargin: Int = -1,
    private val lastItemBottomMargin: Int = -1,
    private val dividerMargin: Int = -1
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val totalItems = parent.layoutManager?.itemCount

        if (totalItems != null) {
            when(position) {
                0 -> {
                    applyFirstItemTopMarginIfPossible(outRect)
                    applyDividerMarginIfPossible(outRect)
                }
                totalItems - 1 -> {
                    if (lastItemBottomMargin != -1) {
                        applyLastItemBottomMarginIfPossible(outRect)
                    } else {
                        applyDividerMarginIfPossible(outRect)
                    }
                }
                else -> applyDividerMarginIfPossible(outRect)
            }
        }
    }

    private fun applyFirstItemTopMarginIfPossible(rect: Rect) {
        if (firstItemTopMargin != -1) {
            rect.top = firstItemTopMargin
        }
    }

    private fun applyDividerMarginIfPossible(rect: Rect) {
        if (dividerMargin != -1) {
            rect.bottom = dividerMargin
        }
    }

    private fun applyLastItemBottomMarginIfPossible(rect: Rect) {
        if (lastItemBottomMargin != -1) {
            rect.bottom = lastItemBottomMargin
        }
    }
}