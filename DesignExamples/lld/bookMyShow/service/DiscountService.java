package lld.bookMyShow.service;

import lld.bookMyShow.entities.Discount;
import lld.bookMyShow.entities.PaymentMode;
import lld.bookMyShow.entities.User;

public interface DiscountService {

    Discount getDiscount(User user, PaymentMode paymentMode, Double price);

}
