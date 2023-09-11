package UI_StepDefinitions;

import java.sql.Driver;

import io.cucumber.java.en.*;

import utilities.PageManager;

public class NavigateTabs {
	private PageManager pages = PageManager.getInstance();

	@Given("Users goes to costco.com")
	public void users_goes_to_costco_com() {
		pages.CostcoPage().navigate();
	}

	@When("User clicks on Grocery")
	public void user_clicks_on_grocery() {
		pages.Dashboard().navigateToGroceryPage();

	}

	@Then("User clicks on Costco button")
	public void user_clicks_on_costco_button() {
		pages.CostcoPage().navigate();
	}

	@When("User clicks on Same-Day")
	public void user_clicks_on_same_day() {
		pages.Dashboard().navigateToSameDayPage();
	}

	@When("User clicks on Deals")
	public void user_clicks_on_deals() {
		pages.Dashboard().navigateToDealsPage();
	}

	@When("User clicks on Business Delivery")
	public void user_clicks_on_business_delivery() {
		pages.Dashboard().navigateToBusinessDeliveryPage();
	}

	@When("User clicks on Optical")
	public void user_clicks_on_optical() {
		pages.Dashboard().navigateOpticalToPage();
	}

	@When("User clicks on Pharmacy")
	public void user_clicks_on_pharmacy() {
		pages.Dashboard().navigateToPharmacyPage();
	}

	@When("User clicks on Services")
	public void user_clicks_on_services() {
		pages.Dashboard().navigateToServicesPage();
	}

	@When("User clicks on Photo")
	public void user_clicks_on_photo() {
		pages.Dashboard().navigateToPhotoPage();
	}

	@When("User clicks on Travel")
	public void user_clicks_on_travel() {
		pages.Dashboard().navigateToTravelPage();
	}

	@When("User clicks on Membership")
	public void user_clicks_on_membership() {
		pages.Dashboard().navigateToMembershipPage();
	}

	@When("User clicks on Locations")
	public void user_clicks_on_locations() {
		pages.Dashboard().navigateToLocationsPage();
	}

}
