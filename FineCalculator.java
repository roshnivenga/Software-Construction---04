import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private LocalDate dueDate;
    private LocalDate returnDate;
    private int fine;

    public FineCalculator(LocalDate dueDate, LocalDate returnDate, int ratePerDay) {
        // Assertions for pre-conditions
        assert dueDate != null : "Due date must not be null";
        assert returnDate != null : "Return date must not be null";
        assert !returnDate.isBefore(dueDate) : "Return date must not be before due date";

        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fine = calculateFine(dueDate, returnDate, ratePerDay);

        // Assertion for post-condition
        assert fine >= 0 : "Fine must not be negative";
        assert invariant() : "Invariant violated: fine should be consistent with due and return dates.";
    }

    public int calculateFine(LocalDate dueDate, LocalDate returnDate, int ratePerDay) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        int fine = (int) daysLate * ratePerDay;

        // Assertion for non-negative fine
        assert fine >= 0 : "Fine must not be negative";
        return fine;
    }

    // Invariant: Ensure the fine is non-negative and consistent with the dates
    public boolean invariant() {
        return fine >= 0 && !returnDate.isBefore(dueDate);
    }

    public static void main(String[] args) {
        LocalDate due = LocalDate.of(2024, 4, 10);
        LocalDate returned = LocalDate.of(2024, 4, 15);

        FineCalculator calculator = new FineCalculator(due, returned, 1);
        System.out.println("Fine: RM" + calculator.fine);
    }
}