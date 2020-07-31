public class IntegerToRoman {
    public String intToRoman(int num) {
        int dv;
        String roman = "";
        if (num > 0){
            if (num >= 1000) {
                dv = num / 1000;
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'M';
                }
                num = num % 1000;
            }
            if (num >= 900 && num < 1000) {
                roman = roman + "CM";
                num = num % 100;
            }
            if (num >= 500 && num < 900) {
                dv = num / 100 - 5;
                roman = roman + 'D';
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'C';
                }
                num = num % 100;
            }
            if (num >= 400 && num < 500) {
                roman = roman + "CD";
                num = num % 100;
            }
            if (num >= 100 && num < 400) {
                dv = num / 100;
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'C';
                }
                num = num % 100;
            }
            if (num >= 90 && num < 100) {
                roman = roman + "XC";
                num = num % 10;
            }
            if (num >= 50 && num < 90) {
                dv = num / 10 - 5;
                roman = roman + 'L';
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'X';
                }
                num = num % 10;
            }
            if (num >= 40 && num < 50) {
                roman = roman + "XL";
                num = num % 10;
            }
            if (num >= 10 && num < 40) {
                dv = num / 10;
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'X';
                }
                num = num % 10;
            }
            if (num == 9) {
                roman = roman + "IX";
            }
            if (num >= 5 && num < 9) {
                dv = num - 5;
                roman = roman + 'V';
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'I';
                }
            }
            if (num == 4) {
                roman = roman + "IV";
            }
            if (num >= 1 && num < 4) {
                dv = num;
                for(int i = 0; i < dv; i++) {
                    roman = roman + 'I';
                }
            }
        }
        return roman;
    }
}