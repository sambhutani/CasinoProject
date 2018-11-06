package io.zipcoder.casino;

public interface Gamble {
     void Bet(Player player, int betAmount);
     // void Bet(int betAmount);
     void Payout();
}
