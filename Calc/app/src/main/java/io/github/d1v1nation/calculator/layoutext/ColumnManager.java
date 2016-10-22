package io.github.d1v1nation.calculator.layoutext;

import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.LinkedList;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p>
 *         22.10.16 of Calculator | io.github.d1v1nation.calculator.layoutext
 */


public class ColumnManager {
    private final PercentRelativeLayout over;
    private final LinkedList<LinkedList<View>> layout;

    public ColumnManager(PercentRelativeLayout over) {
        this.over = over;
        this.layout = new LinkedList<>();
        layout.addLast(new LinkedList<View>());
    }

    public ColumnManager(PercentRelativeLayout over, LinkedList<LinkedList<View>> layout) {
        this.over = over;
        this.layout = layout;
    }

    public void register(View v) {
        if (v.getId() == View.NO_ID)
            v.setId(View.generateViewId());
        layout.getLast().add(v);
    }

    public void newColumn() {
        layout.addLast(new LinkedList<View>());
    }

    public void draw() {
        View leftRef = null;
        int rowLength = layout.size();
        for (LinkedList<View> column : layout) {
            int columnLength = column.size();
            View topRef = null;
            for (View v : column) {
                over.addView(v);

                PercentRelativeLayout.LayoutParams rlp = new PercentRelativeLayout.LayoutParams( // will be changed
                        0,
                        0);
                rlp.setMargins(0,0,0,0);

                PercentLayoutHelper.PercentLayoutInfo pInfo = rlp.getPercentLayoutInfo();
                pInfo.widthPercent = ((float) 1) / rowLength;
                pInfo.heightPercent = ((float) 1) / columnLength;
                pInfo.fillLayoutParams(rlp, 0, 0);

                if (leftRef != null) {
                    rlp.addRule(RelativeLayout.RIGHT_OF, leftRef.getId());
                }
                if (topRef != null) {
                    rlp.addRule(RelativeLayout.BELOW, topRef.getId());
                }

                v.setLayoutParams(rlp);

                topRef = v;
            }

            leftRef = column.peekFirst();
        }

        over.invalidate();
    }
}
