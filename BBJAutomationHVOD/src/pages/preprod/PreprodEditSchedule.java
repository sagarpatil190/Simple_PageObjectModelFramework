package pages.preprod;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utility.Utility;

public class PreprodEditSchedule extends Utility {
	
	WebDriver driver;
	By btnCommit = By.name("commit");
	public static HashMap<String,String> AssetID = new HashMap<String,String> ();
	
	public PreprodEditSchedule(WebDriver driver){
		this.driver = driver;
	}
	
	
	
	
	public boolean setContract(String strContract, String value){
		try{
			By byContract = By.id("select2-"+value+"_scheduling_metadata_attributes_1_value-container");
			if(existsElement(byContract, driver)){
				driver.findElement(byContract).click();
				By txtContractInput = By.xpath("//*[@id='select2-"+value+"_scheduling_metadata_attributes_1_value-results']//span[contains(text(),'"+strContract+"')]");
				if(existsElement(txtContractInput, driver)){
						driver.findElement(txtContractInput).click();
						return true;
				}
				return false;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setAsset(String value , String EpiName){
		try{
			By byAssetSpan = By.id("select2-"+value+"_scheduling_asset_id-container");
			if(existsElement(byAssetSpan, driver)){
				driver.findElement(byAssetSpan).click();
				By txtAsset = By.xpath("//*[@id='select2-"+value+"_scheduling_asset_id-results']/li[2]/ul/li");
				if(existsElement(txtAsset, driver)){
						String strAssetID[] = driver.findElement(txtAsset).getText().split(" ");
						if(!AssetID.containsKey(EpiName)){
							AssetID.put(EpiName, strAssetID[0]);
						}
						driver.findElement(txtAsset).click();
						return true;
				}
				return false;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public String getAssetID(String EpiName){
		return AssetID.get(EpiName);
	}
	
	public boolean setPlacement(String strPlacement, String value){
		try{
			By byContract = By.id("select2-"+value+"_scheduling_metadata_attributes_3_value-container");
			if(existsElement(byContract, driver)){
				driver.findElement(byContract).click();
				By txtContractInput = By.xpath("//*[@id='select2-"+value+"_scheduling_metadata_attributes_3_value-results']//span[contains(text(),'"+strPlacement+"')]");
				if(existsElement(txtContractInput, driver)){
						driver.findElement(txtContractInput).click();
						return true;
				}
				return false;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setSubscriptions(String strSubs, String value){
		try{
			
			By bySubs =  By.id("select2-"+value+"_scheduling_metadata_attributes_4_value-container");
			if(existsElement(bySubs, driver)){
				driver.findElement(bySubs).click();
				By txtSubsInput = By.xpath("//*[@id='select2-"+value+"_scheduling_metadata_attributes_4_value-results']//span[contains(text(),'"+strSubs+"')]");
				if(existsElement(txtSubsInput, driver)){
						driver.findElement(txtSubsInput).click();
						return true;
				}
				return false;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setPrice(String strPrice, String value){
		try{
			//strPrice="Film - Library (�3.00)";
			By byPrice = By.id("select2-"+value+"_scheduling_metadata_attributes_5_value-container");
			if(existsElement(byPrice, driver)){
				driver.findElement(byPrice).click();
				By txtPriceInput = By.xpath("//*[@id='select2-"+value+"_scheduling_metadata_attributes_5_value-results']//span[contains(text(),'"+strPrice+"')]");
				if(existsElement(txtPriceInput, driver)){
						driver.findElement(txtPriceInput).click();
						return true;
				}
				return false;
			}
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean clickSubmit(){
		try{
			if(existsElement(btnCommit, driver)){
				driver.findElement(btnCommit).click();
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}
	}
	

}
