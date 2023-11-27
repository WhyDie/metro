package exceptions;
import passes.SchoolPass;

import java.time.YearMonth;
import java.util.Arrays;

public class SchoolPassOverdueException extends PassWithTermException{
    private SchoolPass pass;

    public SchoolPassOverdueException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public int calculateTermOfOverdue() {
        return (YearMonth.now().getMonth().minus(pass.getMonth().getMonthValue())).getValue();
    }
    @Override
    public String toString() {
        return "SchoolPassOverdueException: the pass has been overdue " +
                (calculateTermOfOverdue()>1
                        ?calculateTermOfOverdue() + " months ago"
                        : calculateTermOfOverdue() + " month ago");
    }
}
