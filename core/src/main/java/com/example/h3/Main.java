package com.example.h3;

public class Main {
    private void o1() {
        int k = 8;
        System.out.printf("%d; %d++; %d%n", k, k++, k);

        System.out.printf("%d; ++%d; %d%n", k, ++k, k);
    }

    private void o2() {
        int i = 3;
        int j = i < 3 ? i++ + ++i : ++i >>> 1;
        //  j = false ? (3 + 5) : (4 => 0b100 => 0b10 => 2)
        System.out.printf("j = %d%n", j);
    }

    private void o3() {
        System.out.printf("1010 + 100 = %d%n", 0b1010 + 0b100);
    }

    private void o4() {
        int hours = (23 + 80) % 24;
        int days = (23 + 80) / 24;
        System.out.printf("80 hours after 23:00 is %d:00, that is %d days later%n", hours, days);
    }

    private void o5() {
        /**
            char: 0 tot 65.535
            byte: -128 tot 127
            short:  -32.768 tot 32.767
            int: -2147483648 tot 2147483647
            long: -2147483648 tot 2147483647

         Continous Delivery

        What are the ranges (minimum and maximum values) for all the known numeric primitives in java (byte,
        , long, double, float, char)?
        */
    }

    private void o6() {
        Client client1 = new Client("Jan");
        Client client2 = new Client("Piet");
        client2 = client1;
        client2.name = "Joris";
        System.out.println(client1.name);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.o1();
        main.o2();
        main.o3();
        main.o4();
        main.o6();

        long k = (0xFF000000L << 8) + 27;
        System.out.println(k);
        System.out.println((int) k);
    }

}

