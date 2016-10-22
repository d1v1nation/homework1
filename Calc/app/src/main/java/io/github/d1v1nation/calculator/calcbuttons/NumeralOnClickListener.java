package io.github.d1v1nation.calculator.calcbuttons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.d1v1nation.calculator.CalcLogic;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *
 * 17.09.16 of Calculator | ${PACKAGE_NAME}
 */
public class NumeralOnClickListener implements Button.OnClickListener {

    private final String numeral;
    private final CalcLogic updater;

    public NumeralOnClickListener(String numeral, CalcLogic updater) {
        this.numeral = numeral;
        this.updater = updater;
    }

    @Override
    public void onClick(View v) {
        updater.appendNumeral(numeral);
    }
}
