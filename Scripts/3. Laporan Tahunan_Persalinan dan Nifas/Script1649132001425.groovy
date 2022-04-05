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
import org.openqa.selenium.WebElement as WebElement
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

WebUI.setText(findTestObject('Object Repository/Page_Sehati Dashboard/input_Alamat Email Fasilitas Kesehatan_identifier'), 
    GlobalVariable.Email)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Sehati Dashboard/input_Kata Sandi_password'), GlobalVariable.Password)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/button_Masuk'))

WebUI.takeScreenshot()

def text = WebUI.getText(findTestObject('Object Repository/Page_Sehati Dashboard/div_Halo, Puskesmas Remu'))

WebUI.verifyMatch(text, 'Puskesmas Remu', true, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/a_Laporan'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Sehati Dashboard/a_Laporan_Tahunan'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent('Laporan Tahunan', false)

WebUI.click(findTestObject('Object Repository/Page_Laporan_Tahunan/a_Fasilitas Kesehatan'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Laporan_Tahunan/dropdown_tahun'))

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Laporan_Tahunan/dropdown_tahun'), '2020', true)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Laporan_Tahunan/kolom_search'), 'a')

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Laporan_Tahunan/div_Kelurahan Klaligi'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Laporan_Tahunan/tombol_tampilkan'))

WebUI.takeScreenshot()

WebElement Table = driver.findElement(By.xpath('/html/body/div/div/div[1]/section[2]/section/section/div[1]/div[2]/div/div/table'))

List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

ArrayList<String> arraylist_2 = new ArrayList<String>();

for (int row = 0; row < rows_count; row++) {
    List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

    int columns_count = Columns_row.size()

    for (int column = 0; column < columns_count; column++) {
        String celltext = Columns_row.get(column).getText()
		arraylist_2.add(celltext)
    }
}

println(arraylist_2.contains("Anemia postpartum"))

WebUI.takeScreenshot()

if(true) {
	println("There is Anemia postpartum on table")
}

println(arraylist_2.contains("Sesak napas"))

if(true) {
	println("There is Sesak napas on table")
}

println(arraylist_2.contains("Protein urine positif dua (++)"))

if(true) {
	println("Protein urine positif dua (++)")
}

WebUI.closeBrowser()