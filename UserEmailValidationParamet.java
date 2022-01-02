import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
User Registration UC 11: JUnit Parameterised test to validate multiple entry for email address
 */
@RunWith(Parameterized.class)
public class UserEmailValidationParamet {
    private String user_email_id;
    private boolean resultExpected;
    private UserCredentialValidation usercredvalid;

    public UserEmailValidationParamet(String user_email_id, boolean resultExpected){
        super();
        this.user_email_id = user_email_id;
        this.resultExpected = resultExpected;
    }
    @Before
    public void initialize(){
        usercredvalid = new UserCredentialValidation();
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][] {{"abc+100@gmail.com",true},{"abc-111@abc.net",true},
                {"abc.100@abc.com.au",true}, {"abc.@gmail.com",false}, {"abc@abc@gmail.com",false}
        ,{"abc..2002@gmail.com",false}, {"abc@yahoo.com",true},{"abc@1.com",true}});
    }
    @Test
    public void testUserEmailEntered() throws EmailIdInvalidException {
        //System.out.println("The email entered is: "+ resultExpected);
        assertEquals(resultExpected,usercredvalid.userEmailIdVerification(user_email_id));
    }
}
