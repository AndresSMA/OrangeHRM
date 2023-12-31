package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.RecruitmentPage;
import utilities.DriverManager;

public class RecruitmentSteps
{
    RecruitmentPage recruitmentPage = new RecruitmentPage(DriverManager.getDriver().driver);
    String Vacancy = "";
    @When("I click on the recruitment button")
    public void clickOnRecruitmentButton() throws InterruptedException
    {
        recruitmentPage.clickOnButtonRecruitment();
        Thread.sleep(500);
    }
    @Then("I must be in the recruitment page")
    public void isRecruitmentPageDisplayed()
    {
        Assertions.assertTrue(recruitmentPage.isButtonVacanciesDisplayed());
    }
    @When("I click on the vacancies button")
    public void clickOnVacanciesButton() throws InterruptedException
    {
        recruitmentPage.clickOnButtonVacancies();
        Thread.sleep(500);
    }
    @Then("I must be in the vacancies page")
    public void isVacanciesPageDisplayed()
    {
        Assertions.assertTrue(recruitmentPage.isVacanciesPageDisplayed());
    }
    @When("I click on the add new vacancy button")
    public void clickOnAddNewVacancyButton()
    {
        recruitmentPage.clickOnButtonAddVacancy();
    }
    @And("I set the vacancy name as {string}")
    public void setVacancyName(String name) throws InterruptedException
    {
        recruitmentPage.setVacancyName(name);
        Vacancy = name;
        Thread.sleep(500);
    }
    @And("I set the number of positions as {string}")
    public void setPositionsNumber(String number) throws InterruptedException
    {
        recruitmentPage.setNumberOfPositions(number);
        Thread.sleep(500);
    }
    @And("I click on the job title for vacancy button")
    public void clickOnJobTitleVacancyButton()
    {
        recruitmentPage.clickOnButtonDisplayJobTitle();
    }
    @And("I select the job title for vacancy: {string}")
    public void setJobTitleForVacancy(String job) throws InterruptedException
    {
        recruitmentPage.selectJobTitle(job);
        Thread.sleep(500);
    }
    @And("I set the description for the vacancy as {string}")
    public void setDescriptionForVacancy(String description) throws InterruptedException
    {
        recruitmentPage.setDescriptionTextBox(description);
        Thread.sleep(500);
    }
    @And("I set the hiring manager in form field as {string}")
    public void setHiringManager(String name) throws InterruptedException
    {
        recruitmentPage.setHiringManager(name);
        Thread.sleep(500);
    }
    @And("I set the active option: {string}")
    public void setActiveOption(String option) throws InterruptedException
    {
        if(option.equals("no"))
        {
            recruitmentPage.clickOnToggleButtonActive();
        }
        Thread.sleep(500);
    }
    @And("I set the Publish in RSS Feed and Web Page option: {string}")
    public void setPublishOption(String option) throws InterruptedException
    {
        if(option.equals("no"))
        {
            recruitmentPage.clickOnToggleButtonPublish();
        }
        Thread.sleep(500);
    }
    @Given("I click on the save vacancy button")
    public void clickOnSaveButton() throws InterruptedException {
        recruitmentPage.clickOnButtonSubmitVacancy();
        Thread.sleep(500);
    }
    @Then("The new created vacancy must have been recorded")
    public void isVacancyRecorded() throws InterruptedException
    {
        Assertions.assertTrue(recruitmentPage.isVacancyRecorded(Vacancy));
        Thread.sleep(500);
    }
}
