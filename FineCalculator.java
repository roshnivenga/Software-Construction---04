import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    public static int calculateFine(LocalDate dueDate, LocalDate returnDate, int ratePerDay) {
        assert !returnDate.isBefore(dueDate) : "Return date must not be before due date";

        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        int fine = (int) daysLate * ratePerDay;

        assert fine >= 0 : "Fine must not be negative";
        return fine;
    }

    public static void main(String[] args) {
        LocalDate due = LocalDate.of(2024, 4, 10);
        LocalDate returned = LocalDate.of(2024, 4, 15);

        int fine = calculateFine(due, returned, 1);
        System.out.println("Fine: RM" + fine);
    }
}
