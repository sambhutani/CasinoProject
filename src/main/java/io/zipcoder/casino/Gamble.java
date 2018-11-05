package io.zipcoder.casino;

public interface Gamble {
    public void Bet(int betAmount);
    public int Payout(int payoutAmount);
    public void Ante(int anteAmount);
}
