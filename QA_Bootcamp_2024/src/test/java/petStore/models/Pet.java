package PetStore;

import PetStore.models.Category;
import PetStore.models.Pet;
import PetStore.models.Tag;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;

public class PetTest extends PetStore.BaseTest {
    @DataProvider(name = "FindPetById")
    public Iterator<Object[]> findPetDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"200","404",""});
        dp.add(new String[] {"10","200","doggie"});
        dp.add(new String[] {"9999","404",""});
        dp.add(new String[] {"101","200","khaire"});
        return dp.iterator();
    }
    @DataProvider(name = "FindPetByStatus")
    public Iterator<Object[]> findPetStatusDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"available","200"});
        dp.add(new String[] {"pending","200"});
        dp.add(new String[] {"sold","200"});
        return dp.iterator();
    }

    // GET /pet/{petId}
    @Test(dataProvider = "FindPetById")
    public void findPetById(String petId,String responseCode,String name){

        Response response = httpRequest.request(Method.GET,"/pet/" + petId);

        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(responseCode));

        System.out.println(response.getStatusLine());
        assertThat(response.getStatusLine(), Matchers.containsStringIgnoringCase("HTTP/1.1"));
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
        Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
        // Partea de Body
        //System.out.println(response.getBody().asString());
        JsonPath jsonPathEvaluator = response.jsonPath();
        if (response.getStatusCode() == 404){
            Assert.assertEquals(jsonPathEvaluator.getString("message"),"Pet not found");
        }
        if (response.getStatusCode() == 200){
            Assert.assertEquals(jsonPathEvaluator.getString("name"),name);
            /
    }
    @Test(dataProvider = "FindPetByStatus")
    public void findPetByStatus(String status,String responseCode){

        Response response ;
        if (status == null) {
            response = httpRequest.request(Method.GET, "/pet/findByStatus");
        } else {
            response = httpRequest
                    .queryParam("status", status)
                    .request(Method.GET, "/pet/findByStatus");
        }

        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(responseCode),"The code is not what we expected");

        JsonPath jsonPathEvaluator = response.jsonPath();
        if (response.getStatusCode() == 400){
            Assert.assertEquals(jsonPathEvaluator.getString("message"),"Invalid status value");
        }
        if (response.getStatusCode() == 200){
            System.out.println("Response: " + response.prettyPrint());
            Assert.assertEquals(jsonPathEvaluator.getString("[0].status"),status);

        }


    }

    @Test
    public void createPet(){
        Category cat = new Category(231,"myName");
        Tag tag = new Tag(542,"tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(699,cat,"Bobita",photoUrls,tags,"available");

        Gson gson = new Gson();
        System.out.println(gson.toJson(pet));

        Response response = sendRequest(Method.POST,"/pet",pet);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),415,"The code is not the same");


        String jsonOutput = gson.toJson(pet);
        Pet myPet = gson.fromJson(jsonOutput,Pet.class);
        System.out.println(myPet.getName());
    }


    @Test
    public void updatePet(){
        Category cat = new Category(231,"myName");
        Tag tag = new Tag(542,"tagName");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://myurl.com");
        Pet pet = new Pet(35,cat,"Toby",photoUrls,tags,"available");

        // Serializare
        Gson gson = new Gson();
        System.out.println(gson.toJson(pet));
        Response response = sendRequest(Method.PUT,"/pet",pet);
        System.out.println("Response Body: " + response.getBody().asString());

        String jsonOutput = gson.toJson(pet);
        Pet myPet = gson.fromJson(jsonOutput,Pet.class);
        System.out.println(response.getStatusCode());;

        Assert.assertEquals(myPet.getName(), pet.getName(), "Pet name not updated correctly!");
        Assert.assertEquals(response.getStatusCode(),415,"The code is not the same");



    }

    @Test
    public void uploadImage() {
        int petId = 100;

        File imageFile = new File("src/test/resources/petImage.jpeg");
        Assert.assertTrue(imageFile.exists(), "Imaginea nu există!");

        Response response = httpRequest
                .multiPart("file", imageFile)
                .post("/pet/" + petId + "/uploadImage");

        validateResponse(response,200,"Status code is not 200");


        String message = response.jsonPath().getString("message");
        Assert.assertNotNull(message, "Mesajul din răspuns este null!");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void deletePet(){
        int id = 7;
        Response response = sendRequest(Method.DELETE,"/pet/" + id,null);
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        if (response.getStatusCode() == 404){
            assertThat(response.getStatusLine(), Matchers.containsStringIgnoringCase("HTTP/1.1 404 Not Found"));
        }else{
            validateResponse(response,200,"The pet is not deleted");}
    }



}