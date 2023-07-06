package training;


import java.math.BigDecimal;
import java.util.Arrays;

public class Earning {
    private BigDecimal amount;
    private EarningType type;

    public Earning(final String amount, final EarningType type) {

        if (amount == null || amount.isEmpty()) throw new IllegalArgumentException("the amount must be not empty value ");
        this.amount = new BigDecimal(amount);
        this.type = type;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public EarningType getType() {
        return this.type;
    }

    public void setType(final EarningType type) {
        this.type = type;
    }

    public boolean isDeclaredEarningType() {
        return Arrays.asList(EarningType.SALARY, EarningType.BONUS, EarningType.VACATION_PAY, EarningType.OVERTIME).contains(type);
    }
}
