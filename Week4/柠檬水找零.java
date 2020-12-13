// 只要考虑5、10元的个数，20元用不到。
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int n = bills.length;
        for(int i = 0; i < n; i++) {
            if(bills[i]==5) {
                five++;
            }
            else if(bills[i]==10) {
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }
            else {
                if(five >= 1 & ten >=1){
                    five--;
                    ten--;
                }
                else if (five >=3 ){
                    five -=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}