import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement
import org.testng.Assert
import org.openqa.selenium.WebDriver as WebDriver
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/button_Saya Setuju'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/a_Fasilitas Kesehatan'))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Sehati Dashboard/input_Alamat Email Fasilitas Kesehatan_identifier'), 
    GlobalVariable.Email)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Sehati Dashboard/input_Kata Sandi_password'), GlobalVariable.Password)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/button_Masuk'))

WebUI.takeScreenshot()

def text = WebUI.getText(findTestObject('Object Repository/Page_Sehati Dashboard/div_Halo, Puskesmas Remu'))

WebUI.verifyMatch(text, 'Puskesmas Remu', true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/a_Data_Ibu'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent('Data Ibu', false)

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/a_Tab_Ibu_Hamil'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Lihat_Berdasarkan'))

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Lihat_Berdasarkan'), 'healthcare', true)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Data_Ibu/Input_field_cari_nama_ibu'), 'a')

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/button_tampilkan'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Tampilkan_Berdasarkan'))

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Tampilkan_Berdasarkan'), 'filter_age_mother', true)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Umur'))

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Data_Ibu/DropDown_Umur'), '20-35', true)

WebUI.takeScreenshot()

WebElement Table = driver.findElement(By.xpath("//table/tbody"))

List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

int total_nama_ibu_a

for (int row = 0; row < rows_count; row++) {
    List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
	
	String nama_ibu = Columns_row.get(1).getText()
	
	if(nama_ibu.contains("a")) {
		total_nama_ibu_a++
	}
}

if(total_nama_ibu_a>0) {
	println("There are "+total_nama_ibu_a+" contains a in nama ibu")
}else {
	println("There is no contains a in nama ibu")
}

WebUI.takeScreenshot()

Assert.assertEquals(rows_count,  Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Page_Data_Ibu/jumlah_ibu'))))

WebUI.closeBrowser()
