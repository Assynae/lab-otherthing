package training;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExternalEmployeeIncome implements EmployeeIncome {

    @Override
    public BigDecimal computeIncome(Employee employee) {
        List<Earning> earnings = employee.getEarnings();
        if (Objects.nonNull(earnings) && !earnings.isEmpty()) {
            Optional<BigDecimal> income = earnings.parallelStream()
                    .filter(Earning::isDeclaredEarningType)
                    .map(Earning::getAmount)
                    .reduce(BigDecimal::add);

            return income.orElse(BigDecimal.ZERO);
        }
        return BigDecimal.ZERO;
    }
}
