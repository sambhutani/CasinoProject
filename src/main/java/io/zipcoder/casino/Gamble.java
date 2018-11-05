package io.zipcoder.casino;

public interface Gamble {
     void Bet(int betAmount);
     int Payout(int payoutAmount);
     void Ante(int anteAmount);
}
