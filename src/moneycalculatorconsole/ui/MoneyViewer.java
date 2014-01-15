package moneycalculatorconsole.ui;

import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.Money;

public interface MoneyViewer {

    public void show(Money money,Currency currency);
}
