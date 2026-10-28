
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Annotation to check blank fields
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// Annotation to check maximum length
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Signup form with annotated fields
class SignupForm {
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(30)
    String email;

    SignupForm(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

// Validator using reflection
class FormChecker {

    static List<String> validate(Object obj)
            throws IllegalAccessException {

        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Object value = field.get(obj);
            String text = value == null ? "" : value.toString();

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (text.trim().isEmpty()) {
                    errors.add(field.getName() + " must not be blank");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                int max = field.getAnnotation(MaxLength.class).value();

                if (text.length() > max) {
                    errors.add(field.getName()
                            + " must not exceed " + max + " characters");
                }
            }
        }

        return errors;
    }
}

public class FormValidator {
    public static void main(String[] args)
            throws IllegalAccessException {

        SignupForm form = new SignupForm("", "thisisaverylongemailaddress@example.com");

        List<String> errors = FormChecker.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
