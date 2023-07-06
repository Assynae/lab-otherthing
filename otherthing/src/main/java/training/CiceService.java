package training;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;


public class CiceService {
    public static final BigDecimal MINIMUM_WAGE_FACTOR = BigDecimal.valueOf(2.5);
    public static BigDecimal MINIMUM_WAGE = BigDecimal.valueOf(1014.00);

    public BigDecimal compute(final List<Employee> employees) {

        AtomicReference<BigDecimal> basis = new AtomicReference<>(BigDecimal.ZERO);

        if (employees != null && !employees.isEmpty()) {
            Predicate<Employee> nonInternEmployee = employee -> !employee.getIntern();

            employees.stream().filter(nonInternEmployee).forEach(employee -> {

                if (!employee.getIntern()) {
                    BigDecimal income = employee.calculateIncome(new ExternalEmployeeIncome());
                    if(income.compareTo(MINIMUM_WAGE.multiply(MINIMUM_WAGE_FACTOR)) < 0) {
                        basis.set(basis.get().add(income));
                    }
                }
            });

        }
         return basis.get().multiply(BigDecimal.valueOf(0.06)).stripTrailingZeros();
    }
}
