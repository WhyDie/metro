package exceptions;

import java.time.YearMonth;

public abstract class PassWithTermException extends Exception{
    public int calculateTermOfOverdue(){
        return -1;
    }
}

