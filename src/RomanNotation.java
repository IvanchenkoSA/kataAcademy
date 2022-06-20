public class RomanNotation {
    public String toRomanNotation(int x) {
        StringBuilder result = new StringBuilder();
        while (x > 0) {
            if (x >= 90) {
                if (x >= 100) {
                    result.append("C");
                    x -= 100;
                    if (x > 100) {
                        continue;
                    }
                } else {
                    result.append("XC");
                    x -= 90;
                }
            }
            if (x >= 40) {
                if (x >= 50) {
                    result.append("L");
                    x -= 50;
                } else {
                    result.append("XL");
                    x -= 40;
                }
            }
            if (x >= 9) {
                if (x >= 10) {
                    result.append("X");
                    x -= 10;
                    if (x >= 10) {
                        continue;
                    }
                    if (x == 9) {
                        result.append("IX");
                        x -= 9;
                    }
                }else {
                    result.append("IX");
                    x -= 9;
                }
            }
            if (x >= 4) {
                if (x >= 5) {
                    result.append("V");
                    x -= 5;
                } else {
                    result.append("I");
                    if (x == 4) {
                        result.append("V");
                        x -= 4;
                    } else {
                        x -= 1;
                    }
                }
            }
            if (x >= 1) {
                result.append("I");
                x -= 1;
            }
        }
        return result.toString();
    }
}
