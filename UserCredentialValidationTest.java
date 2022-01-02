import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class UserCredentialValidationTest {
    UserCredentialValidation uc = new UserCredentialValidation();

    // JUnit tests for the first name
    @Test
    public void givenFirstName_WhenAppropriate_ShouldReturnTrue(){
        boolean result = false;
        try {
            result = uc.userFirstNameVerification("Mukund");
            assertEquals(true,result);
        } catch (FirstNameInvalidException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenFirstName_WhenStartsWithSmallLetter_ShouldThrowInvalidFirstNameException(){
        boolean result = false;
        try{
            result = uc.userFirstNameVerification("mukund");
            assertEquals(false,result);
        } catch (FirstNameInvalidException e){
            e.printStackTrace();
        }
    }

    // JUnit test cases for the last name
    @Test
    public void givenLastName_WhenAppropriate_ShouldReturnTrue(){
        boolean result = false;
        try{
            result = uc.userLastNameVerification("Naravane");
            assertEquals(true,result);
        } catch (LastNameInvalidException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenLastName_WhenStartsWithSmallLetter_ShouldThrowInvalidLastNameException(){
        boolean result = false;
        try{
            result = uc.userLastNameVerification("naravane");
            assertEquals(false,result);
        } catch (LastNameInvalidException e){
            e.printStackTrace();
        }
    }

    // JUnit test cases for the email ID
    @Test
    public void givenEmailID_WhenCorrect_ShouldReturnTrue(){
        boolean result = false;
        try{
            result = uc.userEmailIdVerification("mukund.naravane@bridgelabz.com");
            assertEquals(true,result);
        } catch (EmailIdInvalidException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenEmailID_IfNotContainsAtTheRateSymbol_ShouldThrowInvalidEmailIdException(){
        boolean result = false;
        try{
            result = uc.userEmailIdVerification("mukund.naravanebridgelabz.com");
            assertEquals(false,result);
        } catch (EmailIdInvalidException e){
            e.printStackTrace();
        }
    }

    // JUnit test cases for the mobile number
    @Test
    public void givenMobileNum_WhenCorrect_ShouldReturnTrue(){
        boolean result = false;
        try{
            result = uc.userMobileNoVerification("91 9876543210");
            assertEquals(true,result);
        } catch (MobileNumInvalidException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenMobileNum_IfNotContainsSpaceAfterCountryCode_ShouldThrowInvalidMobileNumException(){
        boolean result = true;
        try{
            result = uc.userMobileNoVerification("919876543210");
            assertEquals(false,result);
        } catch (MobileNumInvalidException e){
            e.printStackTrace();
        }
    }

    // JUnit test cases for the password
    @Test
    public void givenPassword_WhenCorrect_ShouldReturnTrue(){
        boolean result = false;
        try{
            result = uc.userPwdSplCharVerification("Mukund@1");
            assertEquals(true,result);
        } catch (InvalidPasswordException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenPassword_IfNotContainsSingleSpecialCharacter_ShouldThrowInvalidPasswordException(){
        boolean result = true;
        try{
            result = uc.userPwdSplCharVerification("Mukundnara1");
            assertEquals(false,result);
        } catch (InvalidPasswordException e){
            e.printStackTrace();
        }
    }
}
