package LeetCode;

class NumberOfEmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;
        for(int i: hours){
            if(i>=target){
                result++;
            }
        }
        return result;
    }
}