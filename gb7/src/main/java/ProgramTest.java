import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class ProgramTest {
    @BeforeSuite
    public static void start() {
        System.out.println("start:");
    }
    @Test(priority = 8)
    public static void one() {
        System.out.println("one");
    }

    public static void two() {
        System.out.println("two");
    }

    @Test(priority = 3)
    public static void three() {
        System.out.println("three");
    }

    @Test
    public static void four() {
        System.out.println("four");
    }


    @AfterSuite
    public static void stop() {
        System.out.println("stop.");
    }
}
