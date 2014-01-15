package moneycalculatorconsole;

import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.Money;
import moneycalculatorconsole.persistance.ExchangeRateLouder;
import moneycalculatorconsole.ui.CurrencyDialog;
import moneycalculatorconsole.ui.MoneyDialog;
import moneycalculatorconsole.ui.MoneyViewer;

public class ExchangeMoneyControl {
    private ExchangeRateLouder exchangeRateLouder;
    private CurrencyDialog currencyDialog;
    private MoneyDialog moneyDialog;
    private MoneyViewer moneyViewer;

    public ExchangeMoneyControl(
            ExchangeRateLouder exchangeRateLouder,
            CurrencyDialog currencyDialog,
            MoneyDialog moneyDialog,
            MoneyViewer moneyViewer) {
        this.exchangeRateLouder = exchangeRateLouder;
        this.currencyDialog = currencyDialog;
        this.moneyDialog = moneyDialog;
        this.moneyViewer = moneyViewer;
    }

    public void execute() {
        Money money = readMoney();
        Currency currency = readCurrency();
        exchangeRateLouder.load(money.getCurrency(), currency);
        moneyViewer.show(money, currency);
    }

    private Money readMoney() {
        moneyDialog.execute();
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        currencyDialog.execute();
        return currencyDialog.getCurrency();
    }
    
}
