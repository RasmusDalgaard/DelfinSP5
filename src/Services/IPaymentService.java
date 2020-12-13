package Services;

import Domain.Payment;

import java.util.List;

public interface IPaymentService {

    public List<Payment> getMemberDebt();

    public void showMemberDebt();

}
