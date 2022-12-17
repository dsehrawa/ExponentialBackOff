package com.dsehrawa.exponentialbackoff;

import java.time.Duration;

class ExponentialBackOffTest {

    private static final int maxRetries = 5;
    private static final Duration retryInterval = Duration.ofMillis(2);
    private static final Duration maxRetryInterval = Duration.ofMinutes(32);

    public static void main(String[] args) {
        for(int i=0;i<maxRetries;i++){
            System.out.println(getRetryBackoffInterval(i));
        }
    }

    public static Duration getRetryBackoffInterval(int retriesCount) {
        double exponentialMultiplier = Math.pow(2.0, retriesCount);
        double result = exponentialMultiplier * retryInterval.toMillis();
        long millisToWait = (long) Math.min(result, maxRetryInterval.toMillis());
        return Duration.ofMillis(millisToWait);
    }

}