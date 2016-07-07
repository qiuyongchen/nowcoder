/**
 * Created by qiuyongchen on 16/7/6.
 */

public class GetPower {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double result = 1, b = base;

        int exp = exponent >= 0 ? exponent : -exponent;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= b;
            }

            b *= b;
            exp >>= 1;
        }

        return exponent > 0 ? result : 1 / result;
    }

    public static void main(String[] args) {
        GetPower getPower = new GetPower();
        System.out.println(getPower.Power(3, -2));
        System.out.println((1.0 / 9));
    }
}
