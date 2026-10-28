
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Annotation to mark test methods
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    @Run
    public void testAddition() {
        System.out.println("Test addition executed");
        System.out.println("2 + 3 = " + (2 + 3));
    }

    @Run
    public void testSubtraction() {
        System.out.println("Test subtraction executed");
        System.out.println("5 - 2 = " + (5 - 2));
    }

    public void normalMethod() {
        System.out.println("This method will not run");
    }

    @Run
    public void testMultiplication() {
        System.out.println("Test multiplication executed");
        System.out.println("3 * 4 = " + (3 * 4));
    }
}

// Mini test runner
public class MiniTestRunner {

    public static void main(String[] args)
            throws Exception {

        MyTests tests = new MyTests();
        int count = 0;

        for (Method method : MyTests.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                method.invoke(tests);
                count++;
            }
        }

        System.out.println("Total tests executed: " + count);
    }
}
