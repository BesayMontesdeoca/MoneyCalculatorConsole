package moneycalculatorconsole.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculatorconsole.model.Money;

public class ConsoleMoneyDialog implements MoneyDialog{

    private Money money;
    @Override
    public void execute()  {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            moneycalculatorconsole.model.Number number = new moneycalculatorconsole.model.Number(Double.valueOf(readAmount(read)));
            ConsoleCurrencyDialog currency = new ConsoleCurrencyDialog();
            currency.execute();
            money = new Money(number, currency.getCurrency());
        } catch (IOException ex) {
            Logger.getLogger(MoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String readAmount(BufferedReader read) throws IOException {
        System.out.println("Introduzca la Cantidad de dinero: ");
        return read.readLine();
    }

    @Override
    public Money getMoney() {
        return money;
    }
}