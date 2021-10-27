package builder;

import common.constant.CardName;
import common.model.Issuer;

import java.time.LocalDateTime;

public interface Builder {

    void setTransactionNumber(long transactionNumber);

    void setTransactionName(String transactionName);

    void setTransactionSum(long transactionSum);

    void setTransactionDate(LocalDateTime transactionDate);

    void setIssuer(Issuer issuer);

    void setIssuer(int id, CardName name);

}
