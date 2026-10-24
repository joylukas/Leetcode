class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefix = new int[13];
        for (int i = 0; i < 12; i++) {
            prefix[i + 1] = prefix[i] + days[i];
        }

        int start = Math.max(doy(arriveAlice, prefix), doy(arriveBob, prefix));
        int end = Math.min(doy(leaveAlice, prefix), doy(leaveBob, prefix));
        return Math.max(0, end - start + 1);
    }

    private int doy(String s, int[] prefix) {
        int m = Integer.parseInt(s.substring(0, 2));
        int d = Integer.parseInt(s.substring(3, 5));
        return prefix[m - 1] + d;
    }
}