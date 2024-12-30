package Grind75;

import java.math.BigInteger;

public class _20_AddBinary {
    public String addBinary(String a, String b) {
        BigInteger ba = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        BigInteger bc = ba.add(bb);
        return bc.toString(2);
    }

    public static void main(String[] args) {
        _20_AddBinary obj = new _20_AddBinary();
        System.out.println(obj.addBinary("11", "1"));
        System.out.println(obj.addBinary("1010", "1011"));
        System.out.println(obj.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
