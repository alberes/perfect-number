package io.github.alberes.perfectnumber.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PerfectNumberServiceTests {

    @Autowired
    private PerfectNumberService service;

    @Test
    public void test_perfectNumber(){
        boolean perfectNumber = this.service.isPerfectNumber(6);
        Assertions.assertTrue(perfectNumber);

        perfectNumber = this.service.isPerfectNumber(28);
        Assertions.assertTrue(perfectNumber);

        perfectNumber = this.service.isPerfectNumber(496);
        Assertions.assertTrue(perfectNumber);

        perfectNumber = this.service.isPerfectNumber(8128);
        Assertions.assertTrue(perfectNumber);
    }

    @Test
    public void test_notPerfectNumber() {

        for (int n = 1; n < 500; n++) {
            if (n != 6 && n != 28 && n != 496 && n != 8128) {
                boolean perfectNumber = this.service.isPerfectNumber(n);
                Assertions.assertFalse(perfectNumber);
            }
        }
    }

}
