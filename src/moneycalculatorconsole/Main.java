package moneycalculatorconsole;

import moneycalculatorconsole.persistance.CurrencySetLoader;
import moneycalculatorconsole.persistance.ExchangeRateLouder;
import moneycalculatorconsole.persistance.MockExchangeRateLouder;
import moneycalculatorconsole.ui.ConsoleCurrencyDialog;
import moneycalculatorconsole.ui.ConsoleMoneyDialog;
import moneycalculatorconsole.ui.ConsoleMoneyViewer;
import moneycalculatorconsole.ui.CurrencyDialog;
import moneycalculatorconsole.ui.MoneyDialog;
import moneycalculatorconsole.ui.MoneyViewer;

public class Main {

    public static void main(String[] args) {
        CurrencySetLoader.getInstance().load();
        ExchangeMoneyControl control = new ExchangeMoneyControl(
                createExchangeRateLouder(),
                createCurrencyDialog(),
                createMoneyDialog(),
                createMoneyViewer());
        control.execute();
    }

    private static ExchangeRateLouder createExchangeRateLouder() {
        return new MockExchangeRateLouder();
    }

    private static CurrencyDialog createCurrencyDialog() {
        return new ConsoleCurrencyDialog();
    }

    private static MoneyDialog createMoneyDialog() {
        return new ConsoleMoneyDialog();
    }

    private static MoneyViewer createMoneyViewer() {
        return new ConsoleMoneyViewer();
    }
}
