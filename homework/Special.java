package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Special {
    SUN, MON, TUE, WED, THU, FRI, SAT;

    public void checkSaleDay(Special Special) {
        switch(Special) {
            case SUN:
                System.out.println("10% off on Sunday");
                break;
            case MON:
                System.out.println("20% off on Monday");
                break;
            case TUE:
                System.out.println("15% off on Tuesday");
                break;
            case WED:
                System.out.println("25% off on Wednesday");
                break;
            case THU:
                System.out.println("30% off on Thursday");
                break;
            case FRI:
                System.out.println("buy one get one free on Friday");
                break;
            case SAT:
                System.out.println("No sale on Saturday");
        }

    }
}
