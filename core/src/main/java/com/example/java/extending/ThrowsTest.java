package com.example.java.extending;

public class ThrowsTest {

    static class Doubler {
        public static final int MAX_DOUBLE_VALUE = 16;

        int exec(int value) throws ValueToBigException {
            if(value > MAX_DOUBLE_VALUE) {
                throw new ValueToBigException(value);
            }
            return value * 2;
        }
    }

    static class PowerDoubler extends Doubler {
        int exec(int value) {
            try {
                int left = value;
                int result = 0;
                while (left > 0) {
                    int bite = Math.min(left, PowerDoubler.MAX_DOUBLE_VALUE);
                    result += super.exec(bite);
                    left -= bite;
                }
                return result;
            } catch (ValueToBigException error) {
                System.err.println(error.getMessage());
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Doubler baseDoubler = new Doubler();
        System.out.println(baseDoubler.getClass().getSimpleName());
        try {
            System.out.println(baseDoubler.exec(16));
            System.out.println(baseDoubler.exec(32));
        } catch (ValueToBigException e) {
            System.out.println("Failed to double value: " + e.getMessage());
        }

        Doubler coveredDoubler = new PowerDoubler();
        System.out.println(coveredDoubler.getClass().getSimpleName());
        try {
            System.out.println(coveredDoubler.exec(16));
            System.out.println(coveredDoubler.exec(32));
        } catch (ValueToBigException e) {
            System.out.println("Failed to double value: " + e.getMessage());
        }

        var varDoubler = new PowerDoubler();
        System.out.println(varDoubler.getClass().getSimpleName());
        System.out.println(varDoubler.exec(16));
        System.out.println(varDoubler.exec(32));
    }


    private static class ValueToBigException extends Exception {
        private static final long serialVersionUID = -6556024013033939576L;

        public ValueToBigException(int value) {
            super(String.format("%d is too big", value));
        }
    }
}
