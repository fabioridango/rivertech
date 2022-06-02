package api.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetPostStep {

    private Response response;
    private RequestSpecification request;

    @Given("Get request to API {string}")
    public void get_request_to_api(String baseURI) throws Throwable {

        // Setting BaseURI once
        RestAssured.baseURI = baseURI;

        request = RestAssured.given();
    }

    @Then("Response is satus code {string}")
    public void response_is_satus_code(String statusCode) throws Throwable {

        // Response object instance
        response = request.get();

        // Convert the response as string
        System.out.println(response.asString());

        // Validate Response Status
        int statusCodeValue = response.getStatusCode();
        Assert.assertEquals(statusCodeValue /*actual value*/,Integer.parseInt(statusCode) /*expected value*/,
                "Incorrect status code returned");
    }

    @Then("Response has the expected fields and values id:{string}, name:{string}, username:{string}, email:{string}, street:{string}, suite:{string}, city:{string}, zipcode:{string}, lat:{string}, lng:{string}, phone:{string}, website:{string}, name:{string}, catchPhrase:{string}, bs:{string}")
    public void response_has_the_expected_fields_and_values_id_name_username_email_street_suite_city_zipcode_lat_lng_phone_website_name_catch_phrase_bs(String idV, String nameV, String usernameV, String emailV, String streetV, String suiteV, String cityV, String zipcodeV, String latV, String lngV, String phoneV, String websiteV, String nameCV, String catchPhraseV, String bsV) throws Throwable {

        // JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Validate fields and value in the Response Body - Junit Assertion approach
        Assert.assertNotNull(jsonPathEvaluator.get("id"), "id field validation fails");
        int id = jsonPathEvaluator.get("id");
        Assert.assertEquals(Integer.parseInt(idV),id, "id field value validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("name"), "name field validation fails");
        String name = jsonPathEvaluator.get("name");
        Assert.assertEquals(name,nameV, "name field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("username"), "username field validation fails");
        String username = jsonPathEvaluator.get("username");
        Assert.assertEquals(username,usernameV, "username field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("email"), "email field validation fails");
        String email = jsonPathEvaluator.get("email");
        Assert.assertEquals(email,emailV, "email field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address"), "address field validation fails");

        Assert.assertNotNull(jsonPathEvaluator.get("address.street"), "address street field validation fails");
        String street = jsonPathEvaluator.get("address.street");
        Assert.assertEquals(street,streetV, "street field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address.suite"), "address suite field validation fails");
        String suite = jsonPathEvaluator.get("address.suite");
        Assert.assertEquals(suite,suiteV, "suite field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address.city"), "address city field validation fails");
        String city = jsonPathEvaluator.get("address.city");
        Assert.assertEquals(city,cityV, "city field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address.zipcode"), "address zipcode field validation fails");
        String zipcode = jsonPathEvaluator.get("address.zipcode");
        Assert.assertEquals(zipcode,zipcodeV, "zipcode field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address.geo.lat"), "address geo lat field validation fails");
        String lat = jsonPathEvaluator.get("address.geo.lat");
        Assert.assertEquals(lat,latV, "lat field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("address.geo.lng"), "address geo lng field validation fails");
        String lng = jsonPathEvaluator.get("address.geo.lng");
        Assert.assertEquals(lng,lngV, "lng field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("phone"), "phone field validation fails");
        String phone = jsonPathEvaluator.get("phone");
        Assert.assertEquals(phone,phoneV, "phone field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("website"), "website field validation fails");
        String website = jsonPathEvaluator.get("website");
        Assert.assertEquals(website,websiteV, "website field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("company"), "company field validation fails");

        Assert.assertNotNull(jsonPathEvaluator.get("company.name"), "company name field validation fails");
        String companyName = jsonPathEvaluator.get("company.name");
        Assert.assertEquals(companyName,nameCV, "website field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("company.catchPhrase"), "company catchPhrase " +
                "field validation fails");
        String catchPhrase = jsonPathEvaluator.get("company.catchPhrase");
        Assert.assertEquals(catchPhrase,catchPhraseV, "company catchPhrase field values validation fails" );

        Assert.assertNotNull(jsonPathEvaluator.get("company.bs"), "company bs field validation fails");
        String bs = jsonPathEvaluator.get("company.bs");
        Assert.assertEquals(bs,bsV, "company bs field values validation fails" );
    }
}