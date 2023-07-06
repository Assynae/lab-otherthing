package training;

import java.math.BigDecimal;

public class InternalEmployeeIncome implements EmployeeIncome {
    @Override
    public BigDecimal computeIncome(Employee employee) {
        return BigDecimal.ZERO;
    }
}
