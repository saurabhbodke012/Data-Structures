class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1= num1.length()-1;
        int p2= num2.length()-1;
       
        while( p1 >=0 || p2>=0){
            int val1 = 0;
            int val2 = 0;
            if(p1>= 0 ){
                val1= num1.charAt(p1) -'0';
            }

            if(p2>= 0 ){
                val2= num2.charAt(p2) -'0';
            }

            int value = (val1+val2+carry)%10;
            carry = (val1 + val2 + carry) /10;
            res.append(value);
            p1--;
            p2--;
        }

        if( carry !=0){
            res.append(carry);
        }

        return res.reverse().toString();
    }
}