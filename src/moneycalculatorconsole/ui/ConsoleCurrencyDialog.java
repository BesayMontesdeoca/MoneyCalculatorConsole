/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculatorconsole.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.CurrencySet;


/**
 *
 * @author manuelmonterosantana
 */
public class ConsoleCurrencyDialog implements CurrencyDialog{
    private Currency currency;

    public void execute() {
        while (true) {
            System.out.println("Introduzca una divisa: ");
            String line = readLine();
            Currency[] currencies = CurrencySet.getInstance().search(line);
            if (check(currencies)) {
                break;
            }
        }
        
    }

    private String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException ex) {
        }
        return line;
    }

    private boolean check(Currency[] currencies) {
        if (currencies.length==0) {
            System.out.println("Moneda no encontrada");
            return false;
        }
        if (currencies.length==1) {
            currency=currencies[0];
            return true;
        }
        if (currencies.length>1) {
            System.out.println("Multiples coincidencias:");
            for (Currency currency1 : currencies) {
                System.out.println(currency1);
            }
            return false;
        }
        return false;
    }

    public Currency getCurrency() {
        return currency;
    }
}