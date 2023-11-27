import exceptions.RegularPassNotEnoughMoneyException;
import exceptions.SchoolPassOverdueException;
import exceptions.SchoolPassTripFinishedException;
import exceptions.StudentPassOverdueException;
import passes.StudentPass;

import java.time.YearMonth;


public class PassTest {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        var pass = KievSmartCard.createPass(PassType.STUDENT_PASS);
        StudentPass studentPass = (StudentPass) pass;
        studentPass.setMonth(YearMonth.of(2024, 1));
        try {
            for (int i = 0; i < 51; i++) {
                turnstile.validateEntryPermission(studentPass);
            }

        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}
