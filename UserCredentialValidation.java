import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserCredentialValidation {
    /*
    Use case 1: Valid first name (first name starts with capital letters and has
                minimum three characters)
     */

    public boolean userFirstNameVerification(String usr_first_name) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
        Matcher matcher = pattern.matcher(usr_first_name);
        Boolean first_Name_correct = matcher.matches();
        System.out.println(first_Name_correct);
        return first_Name_correct;
    }
    /*
    Use case 2: Valid last name (last name starts with capital letters and has
                minimum three characters)
     */

    public boolean userLastNameVerification(String usr_last_name) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
        Matcher matcher = pattern.matcher(usr_last_name);
        Boolean last_Name_correct = matcher.matches();
        System.out.println(last_Name_correct);
        return last_Name_correct;
    }

    /*
    Use case 3: Valid Email (3 mandatory parts and 1 optional part)
     */

    public boolean userEmailIdVerification(String usr_email_id) {
        Pattern pattern = Pattern.compile("[a-z0-9]{3,}([.+_-][a-zA-Z0-9]{1,}|[a-zA-Z0-9]*)[@]" +
                "[a-z0-9]{1,}[.]([a-z]{2,}[.][a-z]{2,}|[a-z]{2,})");
        Matcher matcher = pattern.matcher(usr_email_id);
        Boolean emailCorrect = matcher.matches();
        if (emailCorrect){
            System.out.println("Correct Email.");
        }else {
            System.out.println("Incorrect Email.");
        }
        return emailCorrect;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to BridgeLabz!");
        System.out.println("Today we shall verify credentials of a user.");
        UserCredentialValidation uc = new UserCredentialValidation();
        uc.userEmailIdVerification("abc+100@gmail.com");
        uc.userEmailIdVerification("abc-111@abc.net");
        uc.userEmailIdVerification("abc.100@abc.com.au");
        uc.userEmailIdVerification("abc.@gmail.com");
        uc.userEmailIdVerification("abc@abc@gmail.com");
        uc.userEmailIdVerification("abc..2002@gmail.com");
    }
}
