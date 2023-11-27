import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;
import java.time.YearMonth;
/**
 * This class implements the behavior of a subway turnstile.
 * @author Vishchun
 */
public class Turnstile {
    /**
     * Method {@code validateEntryPermission()} checks the conditions.
     * The method is passed {@link  MetroPass} and is checked via type checking ({@link SchoolPass}, {@link StudentPass}
     * and {@link RegularPass}).
     * @param pass pass for checking the passage through the turnstile
     *
     * @throws SchoolPassOverdueException if school pass expired
     * @throws SchoolPassTripFinishedException if the school pass has run out of trips per month
     * @throws RegularPassNotEnoughMoneyException if the regular pass has run out of money in the account
     * @throws StudentPassOverdueException if student pass expired
     */
    public void validateEntryPermission(MetroPass pass) throws SchoolPassOverdueException, SchoolPassTripFinishedException,
            StudentPassOverdueException, RegularPassNotEnoughMoneyException {
        if (pass instanceof SchoolPass schoolPass) {
            if ((schoolPass.getMonth().isBefore(YearMonth.now()))){
                KievSmartCard.addProhibition();
                throw new SchoolPassOverdueException(schoolPass);
            } else if ((schoolPass.getCountOfTrip() == 0)){
                KievSmartCard.addProhibition();
                throw new SchoolPassTripFinishedException(schoolPass);
            } else {
                schoolPass.setCountOfTrip((schoolPass.getCountOfTrip() - 1));
                KievSmartCard.addPermission();
            }
        } else if (pass instanceof StudentPass studentPass) {
            if (studentPass.getMonth().isBefore(YearMonth.now())) {
                KievSmartCard.addProhibition();
                throw new StudentPassOverdueException(studentPass);
            } else {
                KievSmartCard.addPermission();
            }
        } else if (pass instanceof RegularPass regularPass) {
            if (regularPass.getAmountOfMoney() < KievSmartCard.FARE) {
                KievSmartCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException(regularPass);
            } else {
                KievSmartCard.addPermission();
                KievSmartCard.subtractFair(regularPass);
            }
        }

    }
}