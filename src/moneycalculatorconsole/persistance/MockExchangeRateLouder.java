
package moneycalculatorconsole.persistance;

import java.util.Date;
import moneycalculatorconsole.model.Currency;
import moneycalculatorconsole.model.ExchangeRate;


public class MockExchangeRateLouder implements ExchangeRateLouder{
    
    
    public ExchangeRate load(Currency from, Currency to, Date date){
        moneycalculatorconsole.model.Number rate = new moneycalculatorconsole.model.Number(1.45);
        return new ExchangeRate (from,to,rate,date);
    }
    public ExchangeRate load(Currency from, Currency to){
        return load(from,to,new Date());
    }
}
