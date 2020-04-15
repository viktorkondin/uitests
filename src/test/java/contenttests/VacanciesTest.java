package contenttests;

import common.BaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class VacanciesTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(VacanciesTest.class);

    @BeforeClass
    public void setupTests()
    {
        logger.info("Open vacancies page");
        open("/careers/vacancies");
        logger.info("Vacancies page is open");
    }

    @Test
    public void pageTitleDisplayed() {
        $("title").shouldHave(attribute("text", "Job Vacancies | CyberCube"));
    }

    @Test
    public void pageHeaderDisplayed() {
        $(".container-sm").shouldHave(text("Job Vacancies"));
    }

    @Test
    public void pageFooterIsDisplayed() {
        $$(".widget-title").shouldHave(texts("SOLUTIONS", "ABOUT", "SUPPORT & RESOURCES", "SOCIAL"));
    }

    @Test
    public void vacanciesAreClickable() {
        logger.info("Clicking on vacancy");
        $(By.xpath("//*[@id='8a945f80-ee4e-4b8f-a867-a3b4dd780dd6']/a")).click();
        switchTo().window("CyberCube - Actuarial Analyst");
        logger.info("Vacancy is open");
        $(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/h2")).shouldHave(text("Actuarial Analyst"));
        switchTo().window("Job Vacancies | CyberCube");
    }

    @Test
    public void primaryMenuIsDisplayed() {
        $$("#primary-menu").shouldHave(texts("Products & Solutions About Resources"));
    }
}
