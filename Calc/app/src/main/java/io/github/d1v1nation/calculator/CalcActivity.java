package io.github.d1v1nation.calculator;

import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import io.github.d1v1nation.calculator.calcbuttons.ButtonFactory;
import io.github.d1v1nation.calculator.layoutext.ColumnManager;
import io.github.d1v1nation.calculator.mathactions.*;


public class CalcActivity extends AppCompatActivity {

    static final int BUTTON_ROWS = 4;
    static final int BUTTON_COLUMNS = 4;
    private CalcLogic calcLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int idDispatch = 1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        final ColumnManager cm = new ColumnManager((PercentRelativeLayout) findViewById(R.id.buttonPanel));

        if (savedInstanceState != null) {
            calcLogic = (CalcLogic) savedInstanceState.getParcelable("CalcLogic");
        }
        if (calcLogic == null) {
            calcLogic = new CalcLogic();
        }
        calcLogic.setLogicUpdater(
                (TextView) findViewById(R.id.indicatorFirstOperand),
                (TextView) findViewById(R.id.indicatorSecondOperand),
                (TextView) findViewById(R.id.indicatorOperation),
                (TextView) findViewById(R.id.indicatorResult)
        );

        calcLogic.updateViews();

        ButtonFactory buttonFactory = new ButtonFactory(this, calcLogic);

        cm.register(buttonFactory.produceOperal(new Div()));
        cm.register(buttonFactory.produceOperal(new Mul()));
        cm.register(buttonFactory.produceOperal(new Sub()));
        cm.register(buttonFactory.produceOperal(new Add()));
        cm.register(buttonFactory.produceClr());

        cm.newColumn();

        cm.register(buttonFactory.produceNumeral("7"));
        cm.register(buttonFactory.produceNumeral("4"));
        cm.register(buttonFactory.produceNumeral("1"));
        cm.register(buttonFactory.produceNumeral("."));

        cm.newColumn();

        cm.register(buttonFactory.produceNumeral("8"));
        cm.register(buttonFactory.produceNumeral("5"));
        cm.register(buttonFactory.produceNumeral("2"));
        cm.register(buttonFactory.produceNumeral("0"));

        cm.newColumn();

        cm.register(buttonFactory.produceNumeral("9"));
        cm.register(buttonFactory.produceNumeral("6"));
        cm.register(buttonFactory.produceNumeral("3"));
        cm.register(buttonFactory.produceEquator());


        cm.draw();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("CalcLogic", calcLogic);

        super.onSaveInstanceState(outState);
    }

}
