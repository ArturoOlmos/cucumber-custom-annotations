package stepdefinitions;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

//we extend Base class to access to driver and pages objects
public class steps extends Base {				

    @Given("^some other precondition$")
    public void some_other_precondition() throws Throwable {
        //************** test rootelements
    	//mainPage.enableDevTools();
    	//**************test custom annotation
    	//mainPage.first();
    	//**************test GET REST
    	//mainPage.testGET();
    	//**************test POST REST
    	//mainPage.testPOST();
    	//TEST shadowPath with generics methods
    	//mainPage.enableButton();
    	//TEST shadowPath with custom class
    	//mainPage.enableButtonWithCustomClass();
    	//TEST shadowPath with annotation
    	mainPage.enableButtonWithAnnotation();
    }

    @When("^I complete action$")
    public void i_complete_action() throws Throwable {
        //System.out.println("When.");
    }

}