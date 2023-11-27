package exceptions;
import passes.RegularPass;

import java.util.Arrays;

public class RegularPassNotEnoughMoneyException extends Exception{
    private RegularPass pass;

    public RegularPassNotEnoughMoneyException(RegularPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "RegularPassNotEnoughMoneyException: on the pass with id " +
                pass.getUid() +
                " lefts only " +
                pass.getAmountOfMoney() +
                "UAH";
    }
}
