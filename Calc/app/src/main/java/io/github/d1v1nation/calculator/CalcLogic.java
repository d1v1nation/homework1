package io.github.d1v1nation.calculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * @author d1v1nation (catanaut@gmail.com)
 *         <p>
 *         19.09.16 of Calculator | io.github.d1v1nation.calculator
 */
public class CalcLogic implements Parcelable {

    private String stateLHOp = "", stateRHOp = "", stateOpn = "", stateCurrent = "";
    private Operation currentOp = null;
    private TextView twLHOp;
    private TextView twRHOp;
    private TextView twOpn;
    private TextView twCurrent;
    private boolean lastEq = false;
    private boolean curHasDot = false;

    // methods

    public CalcLogic() {

    }

    private void update(String sLH, String sRH, String sOpn, String sCur) {
        twLHOp.setText(sLH);
        twRHOp.setText(sRH);
        twOpn.setText(sOpn);
        twCurrent.setText(sCur);
    }

    public void setLogicUpdater(TextView twLHOp, TextView twRHOp, TextView twOpn, TextView twCurrent) {
        this.twLHOp = twLHOp;
        this.twRHOp = twRHOp;
        this.twOpn = twOpn;
        this.twCurrent = twCurrent;
    }

    public void updateViews() {
        update(stateLHOp, stateRHOp, stateOpn, stateCurrent);
    }


    public void appendNumeral(String s) {
        if (lastEq)
            clearAll();

        if (s.equals("."))
            if (curHasDot) {
                return;
            } else {
                curHasDot = true;
            }
        stateCurrent += s;
        updateViews();
    }

    public void clearCurrent() {
        stateCurrent = "";
        curHasDot = false;
        updateViews();
    }

    public void clearAll() {
        stateCurrent = stateLHOp = stateRHOp = stateOpn = "";
        currentOp = null;
        curHasDot = lastEq = false;
        updateViews();
    }

    public void setCurrentOp(Operation currentOp) {
        this.currentOp = currentOp;
        calculate();

        stateLHOp = stateCurrent;
        stateCurrent = "";
        stateRHOp = "";
        stateOpn = currentOp.getRepr();
        lastEq = false;
        updateViews();
    }


    /* TODO: handle multiple =, handle input after =
     * proposed solution: keep history
     */
    public void calculate() {
        if (currentOp == null)
            return;

        if (!lastEq)
            stateRHOp = stateCurrent;
        else
            stateLHOp = stateCurrent;

        lastEq = true;

        DecimalFormat dfEx = new DecimalFormat("0.############");
        DecimalFormat dfSci = new DecimalFormat("0.############E0");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dfs.setNaN("ПОДЛИВА ПОТЕКЛА");
        dfEx.setDecimalFormatSymbols(dfs);
        dfEx.setGroupingUsed(false);
        dfSci.setDecimalFormatSymbols(dfs);
        dfSci.setGroupingUsed(false);
        try {
            Double lh = dfEx.parse(stateLHOp).doubleValue();
            Double rh = dfEx.parse(stateRHOp).doubleValue();

            Double result = currentOp.getMathOp().apply(lh, rh);

            stateCurrent = dfEx.format(result);
            if (stateCurrent.length() >= 14) {
                stateCurrent = dfSci.format(result);
            }

            updateViews();
        } catch (ParseException e) {
            // DO NOTHING
        }
    }

    // SERIALIZABLE IS BAD AND SHOULD FEEL BAD

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(stateLHOp);
        out.writeString(stateRHOp);
        out.writeString(stateCurrent);
        out.writeString(stateOpn);
        out.writeValue(lastEq);
        out.writeValue(curHasDot);
        out.writeSerializable(currentOp);
    }

    public static final Parcelable.Creator<CalcLogic> CREATOR
            = new Parcelable.Creator<CalcLogic>() {
        public CalcLogic createFromParcel(Parcel in) {
            return new CalcLogic(in);
        }

        public CalcLogic[] newArray(int size) {
            return new CalcLogic[size];
        }
    };

    private CalcLogic(Parcel in) {
        stateLHOp = in.readString();
        stateRHOp = in.readString();
        stateCurrent = in.readString();
        stateOpn = in.readString();
        lastEq = (Boolean) in.readValue(null);
        curHasDot = (Boolean) in.readValue(null);
        currentOp = (Operation) in.readSerializable(); // UN SA FE
    }

}
