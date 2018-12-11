package ticTacToe;

import static ticTacToe.Game.*;

public class MediumLevel {
    private int string;
    private int row;

    public void medium() {
        int valueOfComputer = getActiveFigure();
        int valueOfHuman;

        if (scan(valueOfComputer)) {
            return;
        }

        if (valueOfComputer == CROSS) {
            valueOfHuman = ZERO;
        } else {
            valueOfHuman = CROSS;
        }

        if (scan(valueOfHuman)) {
            return;
        }

        new ComputerRival().easy();
    }

    private boolean scan(int value) {
        if (scanDown(value)) {
            ComputerRival.dataUpdate(string, row);
            return true;
        }

        if (scanRight(value)) {
            ComputerRival.dataUpdate(string, row);
            return true;
        }

        if (scanDiagonal(value)) {
            ComputerRival.dataUpdate(string, row);
            return true;
        }
        return false;
    }

    private boolean scanDown(int value) {
        for( int r = 0; r < 3; r++) {
            if (getFieldValue(0, r) == value &&
                    getFieldValue(1, r) == value &&
                    getFieldValue(2,r) == NULL) {
                string = 2;
                row = r;
                return true;
            }

            if (getFieldValue(1, r) == value &&
                    getFieldValue(2, r) == value &&
                    getFieldValue(0,r) == NULL ) {
                string = 0;
                row = r;
                return true;
            }
        }
        return false;
    }



    private boolean scanRight(int value) {
        for( int s = 0; s < 3; s++) {
            if (getFieldValue(s, 0) == value &&
                    getFieldValue(s, 1) == value &&
                    getFieldValue(s,2) == NULL ) {
                string = s;
                row = 2;
                return true;
            }

            if (getFieldValue(s, 1) == value &&
                    getFieldValue(s, 2) == value &&
                    getFieldValue(s,0) == NULL ) {
                string = s;
                row = 0;
                return true;
            }
        }
        return false;
    }

    private  boolean scanDiagonal(int value) {
        /*
            Check that first diagonal equal and not null
         */
        if (getFieldValue(0, 0) == value &&
                getFieldValue(1, 1) == value &&
                getFieldValue(2,2) == NULL ) {
            string = 2;
            row = 2;
            return true;
        }


        if (getFieldValue(1, 1) == value &&
                getFieldValue(2, 2) == value &&
                getFieldValue(0,0) == NULL ) {
            string = 0;
            row = 0;
            return true;
        }
        /*
            Check that second diagonal equal and not null
         */
        if (getFieldValue(0, 2) == value &&
                getFieldValue(1, 1) == value &&
                getFieldValue(2,0) == NULL ) {
            string = 2;
            row = 0;
            return true;
        }


        if (getFieldValue(2, 0) == value &&
                getFieldValue(1, 1) == value &&
                getFieldValue(0,2) == NULL ) {
            string = 0;
            row = 2;
            return true;
        }
        return false;
    }
}
