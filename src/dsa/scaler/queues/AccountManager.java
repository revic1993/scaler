package dsa.scaler.queues;

import dsa.utils.Utils;

import java.util.*;

public class AccountManager {

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Utils.printSingleArr(accountManager.solve(2,100,new ArrayList<>(List.of(0,1,5))));
    }

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Account> availableAccounts = new LinkedList<>();
        Deque<Account> busyAccounts = new LinkedList<>();
        for(int i=1;i<=A;i++){
            availableAccounts.addLast(new Account(i));
        }
        for (int currentTime : C) {
            while (!busyAccounts.isEmpty() && busyAccounts.peekFirst().releaseTime <= currentTime) {
                availableAccounts.addLast(busyAccounts.removeFirst());
            }
            if (availableAccounts.isEmpty()) {
                result.add(0);
                continue;
            }
            Account currentAcc = availableAccounts.removeFirst();
            result.add(availableAccounts.size());
            currentAcc.releaseTime = currentTime + B;
            busyAccounts.add(currentAcc);
        }
        return result;
    }

    static class Account{
        int id;
        int releaseTime;
        public Account(int id){
            this.id = id;
            this.releaseTime = Integer.MAX_VALUE;
        }

        public boolean canBeReleased(int currentTime){
            return releaseTime <= currentTime;
        }
    }
}
