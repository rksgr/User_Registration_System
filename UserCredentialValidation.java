import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
interface ValidateEntries{
    boolean entryValidation(String str);
}

public class UserCredentialValidation {
    /*
    Use case 1: Valid first name (first name starts with capital letters and has
                minimum three characters)
     */
    public boolean validateFirst(ValidateEntries validateentries, String usr_first_name){
        boolean first_name_correct = validateentries.entryValidation(usr_first_name);
        return first_name_correct;
    }
    /*
    Use case 2: Valid last name (last name starts with capital letters and has
                minimum three characters)
     */
    public boolean validateLast(ValidateEntries validateentries, String usr_last_name){
        boolean last_name_correct = validateentries.entryValidation(usr_last_name);
        return last_name_correct;
    }
    /*
    Use case 3: Valid Email (3 mandatory parts and 1 optional part)
     */
    public boolean validateEmail(ValidateEntries validateentries, String usr_email_id){
        boolean email_id_correct = validateentries.entryValidation(usr_email_id);
        return email_id_correct;
    }
    /*
    Use case 4: Valid Mobile No (country code followed by space and 10-digit number)
     */
    public boolean validateMobileNo(ValidateEntries validateentries, String usr_mobile_no){
        boolean mobile_no_correct = validateentries.entryValidation(usr_mobile_no);
        return mobile_no_correct;
    }
    /*
    Use case 5: Valid Password (Rule 1: Minimum 8 characters required)
     */
    public boolean validatePasswdMinChar(ValidateEntries validateentries, String usr_pwd){
        boolean pwd_correct = validateentries.entryValidation(usr_pwd);
        return pwd_correct;
    }
    /*
    Use case 6: Valid Password (Rule 2: At least 1 upper case required)
     */
    public boolean validatePasswdUpperCase(ValidateEntries validateentries, String usr_pwd){
        boolean pwd_correct = validateentries.entryValidation(usr_pwd);
        return pwd_correct;
    }
    /*
    Use case 7: Valid Password (Rule 3: At least 1 numeric required)
     */
    public boolean validatePasswdNumeric(ValidateEntries validateentries, String usr_pwd){
        boolean pwd_correct = validateentries.entryValidation(usr_pwd);
        return pwd_correct;
    }
    /*
    Use case 8: Valid Password (Rule 4: only 1 special character required) All rules followed
     */
    public boolean validatePasswdSplChar(ValidateEntries validateentries, String usr_pwd){
        boolean pwd_correct = validateentries.entryValidation(usr_pwd);
        return pwd_correct;
    }

    /*
    Use case 9: Should check all email samples provided separately
     */
    public boolean validateMultiEmails(ValidateEntries validateentries, String usr_email_id){
        boolean all_email_samples_correct = validateentries.entryValidation(usr_email_id);
        return all_email_samples_correct;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to BridgeLabz!");
        System.out.println("Today we shall verify credentials of a user.");
        UserCredentialValidation uc = new UserCredentialValidation();

        // lambda expression to ensure first name starts with capital letters
        // and has minimum three characters
        ValidateEntries validatefirstname = (usr_first_name) -> {
            Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
            Matcher matcher = pattern.matcher(usr_first_name);
            boolean first_Name_correct = matcher.matches();
            return first_Name_correct;
        };
        boolean result1 = uc.validateFirst(validatefirstname, "Mukund");
        System.out.println("result1:" + result1);

        // lambda expression to ensure last name starts with capital letters
        // and has minimum three characters
        ValidateEntries validatelastname = (usr_last_name) -> {
            Pattern pattern = Pattern.compile("[A-Z][a-z]{2,}");
            Matcher matcher = pattern.matcher(usr_last_name);
            boolean last_Name_correct = matcher.matches();
            return last_Name_correct;
        };
        boolean result2 = uc.validateLast(validatelastname, "Naravane");
        System.out.println("result2:" + result2);

        // lambda expression to ensure valid email id
        ValidateEntries validateemailid = (usr_email_id) -> {
            Pattern pattern = Pattern.compile("[a-z0-9]{3,}([.+_-][a-zA-Z0-9]+|[a-zA-Z0-9]*)[@]" +
                    "[a-z0-9]+[.]([a-z]{2,}[.][a-z]{2,}|[a-z]{2,})");
            Matcher matcher = pattern.matcher(usr_email_id);
            boolean emailCorrect = matcher.matches();
            return emailCorrect;
        };
        boolean result3 = uc.validateEmail(validateemailid, "mukund@aravane.com");
        System.out.println("result3:" + result3);

        // lambda expression to ensure mobile number starts with two digit country code
        // followed by ten-digit number.
        ValidateEntries validatemobilenum = (usr_mobile_no) -> {
            Pattern pattern = Pattern.compile("[0-9]{2}[\s][1-9][0-9]{9}");
            Matcher matcher = pattern.matcher(usr_mobile_no);
            boolean mobile_no_Correct = matcher.matches();
            return mobile_no_Correct;
        };
        boolean result4 = uc.validateMobileNo(validatemobilenum, "91 1234567890");
        System.out.println("result4:" + result4);

        // lambda expression to ensure password has minimum 8 characters
        ValidateEntries validatepwdminchar = (usr_pwd) -> {
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]{8,}");
            Matcher matcher = pattern.matcher(usr_pwd);
            boolean pwd_correct = matcher.matches();
            return pwd_correct;
        };
        boolean result5 = uc.validatePasswdMinChar(validatepwdminchar, "abcdefghij");
        System.out.println("result5:" + result5);

        // lambda expression to ensure password has at least one upper case character
        ValidateEntries validatepwdUpperchar = (usr_pwd) -> {
            Pattern pattern = Pattern.compile("(?=.*[A-Z])[a-zA-Z0-9]{8,}");
            Matcher matcher = pattern.matcher(usr_pwd);
            boolean pwd_correct = matcher.matches();
            return pwd_correct;
        };
        boolean result6 = uc.validatePasswdUpperCase(validatepwdUpperchar, "abcdefghiJ");
        System.out.println("result6:" + result6);

        // lambda expression to ensure password has at least one numeric character
        ValidateEntries validatepwdNumeric = (usr_pwd) -> {
            Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}");
            Matcher matcher = pattern.matcher(usr_pwd);
            boolean pwd_correct = matcher.matches();
            return pwd_correct;
        };
        boolean result7 = uc.validatePasswdNumeric(validatepwdNumeric, "abcdefgh0J");
        System.out.println("result7:" + result7);

        // lambda expression to ensure password has only one special character
        ValidateEntries validatepwdsplchar = (usr_pwd) -> {
            int cnt_spl_char = 0;
            boolean pwd_correct = false;
            Pattern pattern1 = Pattern.compile("[~!@#$%^&*()_+-]");
            Matcher matcher1 = pattern1.matcher(usr_pwd);
            // count the number of special characters
            while (matcher1.find()){
                cnt_spl_char++;
            }

            // If only one special character exists
            if (cnt_spl_char==1){
                // Check for Minimum 8 characters out of which at least 1 upper case and 1 number
                Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9!@#$%^^&*)(_+-]{8,}");
                Matcher matcher = pattern.matcher(usr_pwd);
                pwd_correct = matcher.matches();
            }
            return pwd_correct;
        };
        boolean result8 = uc.validatePasswdSplChar(validatepwdsplchar, "abcd@efgh0J");
        System.out.println("result8:" + result8);

        // create an arraylist containing all the sample emails
        ArrayList<String> email_id_list = new ArrayList<>();
        email_id_list.add("abc@yahoo.com");
        email_id_list.add("abc-100@yahoo.com");
        email_id_list.add("abc.100@yahoo.com");
        email_id_list.add("abc111@abc.com");
        email_id_list.add("abc-100@abc.net");
        email_id_list.add("abc.100@abc.com.au");
        email_id_list.add("abc@1.com");
        email_id_list.add("abc@gmail.com.com");
        email_id_list.add("abc+100@gmail.com");

        // lambda expression to validate all email ids given in arraylist above
        email_id_list.forEach( (email_id) -> {
            boolean all_email_samples_correct = false;
            int cnt_correct_email_id = 0;
            boolean result = uc.validateEmail(validateemailid, email_id);
            // If email sample correct
            if (result) {
                System.out.println("Given email sample correct.");
            } else {
                System.out.println("Given email sample not correct.");
            }
        });
    }
}
