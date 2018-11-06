package io.zipcoder.casino;

public interface Gamble {
     void Bet(Player player, int betAmount);
     int Payout(int payoutAmount);
}
