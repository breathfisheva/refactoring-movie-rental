package cn.xpbootcamp.refactor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerTest {

    @Test
    void should_return_correct_result_when_call_statement() {
        Customer customer = new Customer("老王");
        customer.addRental(new Rental(new Movie("同桌的你", Movie.CAMPUS), 4));
        customer.addRental(new Rental(new Movie("宠爱", Movie.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("战狼2", Movie.HISTORY), 6));

        assertThat("Rental Record for 老王：\n" +
                "\t同桌的你\t3.0\n" +
                "\t宠爱\t15.0\n" +
                "\t战狼2\t8.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points").isEqualTo(customer.statement());
    }

}