package moneycalculatorconsole.ui;

import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.Money;

public class ConsoleMoneyViewer implements MoneyViewer{
    
    @Override
    public void show(Money money,Currency currency){
        System.out.println(money);
    }
    
}
