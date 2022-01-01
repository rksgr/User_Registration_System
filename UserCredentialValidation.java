import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

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
                "[a-z0-9]+[.]([a-z]{2,}[.][a-z]{2,}|[a-z]{2,})");
        Matcher matcher = pattern.matcher(usr_email_id);
        Boolean emailCorrect = matcher.matches();
        return emailCorrect;
    }
    /*
    Use case 4: Valid Mobile No (country code followed by space and 10-digit number)
     */
    public boolean userMobileNoVerification(String usr_mobile_no) {
        Pattern pattern = Pattern.compile("[0-9]{2}[\s][1-9][0-9]{9}");
        Matcher matcher = pattern.matcher(usr_mobile_no);
        Boolean mobile_no_Correct = matcher.matches();
        return mobile_no_Correct;
    }
    /*
    Use case 5: Valid Password (Rule 1: Minimum 8 characters required)
     */
    public boolean userPasswordRuleFirstVerification(String usr_pwd) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{8,}");
        Matcher matcher = pattern.matcher(usr_pwd);
        Boolean pwd_Correct = matcher.matches();
        if (pwd_Correct){
            System.out.println("Correct Password.");
        }else {
            System.out.println("Incorrect Password.");
            if (usr_pwd.length()<8){
                System.out.println("Password should not contain less than 8 characters!");
            }
        }
        return pwd_Correct;
    }
    /*
    Use case 6: Valid Password (Rule 2: At least 1 upper case required)
     */
    public boolean userPwdUpperCaseVerification(String usr_pwd) {
        Pattern pattern = Pattern.compile("(?=.*[A-Z])[a-zA-Z0-9]{8,}");
        Matcher matcher = pattern.matcher(usr_pwd);
        Boolean pwd_Correct = matcher.matches();
        if (pwd_Correct){
            System.out.println("Correct Password.");
        }else {
            System.out.println("Incorrect Password.");
            System.out.println("Password should contain at least one upper case!");
        }
        return pwd_Correct;
    }
    /*
    Use case 7: Valid Password (Rule 3: At least 1 numeric required)
     */
    public boolean userPwdNumericVerification(String usr_pwd) {
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}");
        Matcher matcher = pattern.matcher(usr_pwd);
        Boolean pwd_Correct = matcher.matches();
        if (pwd_Correct){
            System.out.println("Correct Password.");
        }else {
            System.out.println("Incorrect Password.");
            System.out.println("Password should contain at least one numeric number!");
        }
        return pwd_Correct;
    }
    /*
    Use case 8: Valid Password (Rule 4: only 1 special character required) All rules followed
     */
    public boolean userPwdSplCharVerification(String usr_pwd) {
        int cnt_spl_char = 0;
        boolean pwd_Correct = false;
        Pattern pattern1 = Pattern.compile("[~!@#$%^&*()_+-]");
        Matcher matcher1 = pattern1.matcher(usr_pwd);

        // count the number of special characters
        while (matcher1.find()){
            cnt_spl_char++;
        }

        // If only one special character exists, verify count of other characters else return false
        if (cnt_spl_char==1){
            Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9!@#$%^^&*)(_+-]{8,}");
            Matcher matcher = pattern.matcher(usr_pwd);
            pwd_Correct = matcher.matches();
        }
        return pwd_Correct;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to BridgeLabz!");
        System.out.println("Today we shall verify credentials of a user.");
        UserCredentialValidation uc = new UserCredentialValidation();
        //boolean result = uc.userEmailSamplesPassTest();
        //System.out.println("All email samples passed"+ result);
        boolean result = uc.userPwdSplCharVerification("Asddfsdsd1*");
        System.out.println(result);
    }
}
