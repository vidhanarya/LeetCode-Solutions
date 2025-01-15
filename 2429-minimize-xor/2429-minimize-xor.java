class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount1 = 0, bitCount2 = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & num1) > 0) bitCount1++;
            if ((mask & num2) > 0) bitCount2++;
            mask <<= 1;
        }


        mask = 1;
        while (bitCount1 != bitCount2) {
            if (bitCount1 > bitCount2 && (mask & num1) > 0) {
                num1 = num1 ^ mask;
                bitCount1--;
            } else if (bitCount1 < bitCount2 && (mask & num1) == 0) {
                num1 = num1 ^ mask;
                bitCount1++;
            }
            
            mask <<= 1;
        }

        return num1;
    }
}

