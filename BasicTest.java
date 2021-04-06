package ru.krista.pfhd.autotest;
import com.google.common.collect.ImmutableList; import org.junit.*;
import ru.krista.core.autotest.ntp.*;
import ru.krista.core.autotest.rule.BaseRule;
import static com.codeborne.selenide.Selenide.open; public class OrganisationVerificationTest {
private String testStandUrl = System.getProperty("stand"); @Rule
public BaseRule rule = new BaseRule();
	@Test
	public void testOrganisationsAreVerified() {
		LogInPage logInPage = open(testStandUrl, LogInPage.class); 
		MainPage mainPage = logInPage.logIn("login", "password"); 
		mainPage.getNavigator().openForm(ImmutableList.of("Администратор справочников", "Организации и счета", "Учреждения (ОВ)"));
		Form organisationForm = mainPage.getWorkArea().findFormAndWaitForLoading("Учреждения (ОВ)");
		Toolbar toolbar = organisationForm.getMainToolbar();
		toolbar.findDropDownButton("Проверить документы").clickOn("Логический контроль");
	} 
}