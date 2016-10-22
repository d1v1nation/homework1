package io.github.d1v1nation.calculator.layoutext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.percent.PercentRelativeLayout;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *
 * 17.09.16 of Calculator | ${PACKAGE_NAME}
 */
public class SquarePercentRelativeLayout extends PercentRelativeLayout {

    public SquarePercentRelativeLayout(Context context) {
        super(context);
    }

    public SquarePercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquarePercentRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int w, int h) {
        super.onMeasure(w, w); // now tis square AF.
    }
}
