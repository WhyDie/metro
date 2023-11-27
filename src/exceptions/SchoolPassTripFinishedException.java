package exceptions;
import passes.SchoolPass;

import java.util.Arrays;

public class SchoolPassTripFinishedException extends Exception {
    private final SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "ScoolPassTripFinishedException: the pass with id " +
                pass.getUid() +
                " has no more trip";
    }
}