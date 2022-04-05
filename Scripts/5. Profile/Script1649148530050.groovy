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

WebUI.click(findTestObject('Object Repository/Page_Profile/a_Profile'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent('Profil', false)

WebUI.click(findTestObject('Object Repository/Page_Profile/a_Tab_Letak_Geografis'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Profile/a_Edit'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent('Edit Letak Geografis', false)

WebUI.sendKeys(findTestObject('Object Repository/Page_Profile/luas_wilayah_kerja'), Keys.chord(Keys.DELETE))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Profile/luas_wilayah_kerja'),'500')

WebUI.takeScreenshot()

WebUI.sendKeys(findTestObject('Object Repository/Page_Profile/wilayah_kerja_desa'), Keys.chord(Keys.DELETE))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Profile/wilayah_kerja_desa'),'500')

WebUI.takeScreenshot()

WebUI.sendKeys(findTestObject('Object Repository/Page_Profile/wilayah_kerja_dusun'), Keys.chord(Keys.DELETE))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Profile/wilayah_kerja_dusun'),'500')

WebUI.takeScreenshot()

WebUI.sendKeys(findTestObject('Object Repository/Page_Profile/batas_utara'), Keys.chord(Keys.DELETE))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Profile/batas_utara'),'Test')

WebUI.takeScreenshot()

WebUI.sendKeys(findTestObject('Object Repository/Page_Profile/batas_barat'), Keys.chord(Keys.DELETE))

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Profile/batas_barat'),'Test')

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Profile/button_simpan'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent('Edit Letak Geografis Berhasil', false)

WebUI.click(findTestObject('Object Repository/Page_Profile/button_kembali'))

WebUI.takeScreenshot()

String cut_value_luas_wilayah_kera= WebUI.getText(findTestObject('Object Repository/Page_Profile/value_luas_wilayah_kerja')).substring(0,3)

Assert.assertEquals('500',  cut_value_luas_wilayah_kera)

String cut_value_luas_wilayah_kerja_desa= WebUI.getText(findTestObject('Object Repository/Page_Profile/value_wilayah_kerja_desa')).substring(0,3)

Assert.assertEquals('500',  cut_value_luas_wilayah_kerja_desa)

String cut_value_luas_wilayah_kerja_dusun= WebUI.getText(findTestObject('Object Repository/Page_Profile/value_wilayah_kerja_dusun')).substring(0,3)

Assert.assertEquals('500',  cut_value_luas_wilayah_kerja_dusun)

Assert.assertEquals('Test',  WebUI.getText(findTestObject('Object Repository/Page_Profile/value_batas_utara')))

Assert.assertEquals('Test',  WebUI.getText(findTestObject('Object Repository/Page_Profile/value_batas_barat')))

WebUI.closeBrowser()


