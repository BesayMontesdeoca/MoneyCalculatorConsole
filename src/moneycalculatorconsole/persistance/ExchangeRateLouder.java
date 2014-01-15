package moneycalculatorconsole.persistance;

import java.util.Date;
import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.ExchangeRate;

public interface ExchangeRateLouder {
    
    public ExchangeRate load(Currency from, Currency to, Date date);
    public ExchangeRate load(Currency from, Currency to);
}
