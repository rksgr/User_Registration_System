import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class UserCredentialValidationTest {
    UserCredentialValidation uc = new UserCredentialValidation();

    // JUnit tests for the first name
    @Test
    public void givenFirstName_WhenAppropriate_ShouldReturnTrue(){
        boolean result = uc.userFirstNameVerification("Mukund");
        assertEquals(true,result);
    }
    @Test
    public void givenFirstName_WhenStartsWithSmallLetter_ShouldReturnFalse(){
        boolean result = uc.userFirstNameVerification("mukund");
        assertEquals(false,result);
    }

    // JUnit test cases for the last name
    @Test
    public void givenLastName_WhenAppropriate_ShouldReturnTrue(){
        boolean result = uc.userLastNameVerification("Naravane");
        assertEquals(true,result);
    }
    @Test
    public void givenLastName_WhenStartsWithSmallLetter_ShouldReturnFalse(){
        boolean result = uc.userLastNameVerification("naravane");
        assertEquals(false,result);
    }

    // JUnit test cases for the email ID
    @Test
    public void givenEmailID_WhenCorrect_ShouldReturnTrue(){
        boolean result = uc.userEmailIdVerification("mukund.naravane@bridgelabz.com");
        assertEquals(true,result);
    }
    @Test
    public void givenEmailID_IfNotContainsAtTheRateSymbol_ShouldReturnFalse(){
        boolean result = uc.userEmailIdVerification("mukund.naravanebridgelabz.com");
        assertEquals(false,result);
    }

    // JUnit test cases for the mobile number
    @Test
    public void givenMobileNum_WhenCorrect_ShouldReturnTrue(){
        boolean result = uc.userMobileNoVerification("91 9876543210");
        assertEquals(true,result);
    }
    @Test
    public void givenMobileNum_IfNotContainsSpaceAfterCountryCode_ShouldReturnFalse(){
        boolean result = uc.userMobileNoVerification("919876543210");
        assertEquals(false,result);
    }

    
    // JUnit test cases for the password
    @Test
    public void givenPassword_WhenCorrect_ShouldReturnTrue(){
        boolean result = uc.userPwdSplCharVerification("Mukund@1");
        assertEquals(true,result);
    }
    @Test
    public void givenPassword_IfNotContainsSpecialCharacter_ShouldReturnFalse(){
        boolean result = uc.userPwdSplCharVerification("Mukundnara1");
        assertEquals(false,result);
    }
}


