package io.github.alberes.perfectnumber.services;

import org.springframework.stereotype.Service;

@Service
public class PerfectNumberService {

    public boolean isPerfectNumber(int number){
        long sum = 0L;
        for(int n = 1; n < number; n++){
            if(number % n == 0){
                sum += n;
            }
        }
        return sum == number;
    }
}
