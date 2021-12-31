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
        Pattern pattern = Pattern.compile("[a-z0-9]{3,}([.+_-][a-zA-Z0-9]+|[a-zA-Z0-9]*)[@]" +
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
    /*
    Use case 4: Valid Mobile No (country code followed by space and 10-digit number)
     */
    public boolean userMobileNoVerification(String usr_mobile_no) {
        Pattern pattern = Pattern.compile("[0-9]{2}[\s][1-9][0-9]{9}");
        Matcher matcher = pattern.matcher(usr_mobile_no);
        Boolean mobile_no_Correct = matcher.matches();
        if (mobile_no_Correct){
            System.out.println("Correct Mobile Number.");
        }else {
            System.out.println("Incorrect Mobile Number.");
        }
        return mobile_no_Correct;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to BridgeLabz!");
        System.out.println("Today we shall verify credentials of a user.");
        UserCredentialValidation uc = new UserCredentialValidation();
        uc.userMobileNoVerification("91 9894569120");
        uc.userMobileNoVerification("789456120");
    }
}
