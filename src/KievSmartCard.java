import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class KievSmartCard {
    /**
     * Trips per month
     */
    public static final int COUNT_OF_SCHOOL_TRIP_PER_MONTH = 50;
    /**
     * Price per trip
     */
    public static final int FARE = 8;
    /**
     * {@link ArrayList} for storing passes
     */
    private static final ArrayList<MetroPass> internalCardStorage = new ArrayList<>();
    /**
     * Permissions
     */
    private static int countOfPermissions;
    /**
     * Prohibitions
     */
    private static int countOfProhibitions;
    /**
     * The method selects the pass type from the enum and creates the corresponding pass.
     * @throws InputMismatchException If the selected enumeration is not correct
     */
    public static MetroPass createPass(PassType passType) {
        if(passType == PassType.SCHOOL_PASS){
            SchoolPass schoolPass = new SchoolPass(COUNT_OF_SCHOOL_TRIP_PER_MONTH);
            internalCardStorage.add(schoolPass);
            return schoolPass;
        } if(passType == PassType.REGULAR_PASS){
            RegularPass regularPass = new RegularPass();
            internalCardStorage.add(regularPass);
            return regularPass;
        } if (passType == PassType.STUDENT_PASS) {
            StudentPass studentPass =  new StudentPass();
            internalCardStorage.add(studentPass);
            return studentPass;
        }
        throw new InputMismatchException();
    }
    /**
     * Add  permission
     */
    public static void addPermission() {
        countOfPermissions++;
    }
    /**
     * Add prohibition
     */
    public static void addProhibition() {
        countOfProhibitions++;
    }
    /**
     * @return int number count of permissions
     */
    public static int getCountOfPermissions() {
        return countOfPermissions;
    }
    /**
     * @return int number count of prohibitions
     */
    public static int getCountOfProhibitions() {
        return countOfProhibitions;
    }
    /**
     * Add funds {@link RegularPass}.
     *
     * @param regularPass pass to which we want to add funds
     * @param founds funds that we want to add
     */
    public static void addFounds(RegularPass regularPass, int founds) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() + founds);
    }
    /**
     * @return int the total number of permits and prohibitions
     */

    public static int getTotalCountOfOverdueAndEmptyPass() {
        return countOfPermissions + countOfProhibitions;
    }
    /**
     * Subtracts funds to {@link RegularPass}.
     *
     * @param regularPass pass to which we want to subtract funds
     */

    public static void subtractFair(RegularPass regularPass) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney()-FARE);
    }
}
