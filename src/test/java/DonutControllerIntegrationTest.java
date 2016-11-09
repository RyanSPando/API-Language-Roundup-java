// import donuttycoon.Main;
// import com.google.gson.Gson;
// import org.junit.AfterClass;
// import static org.junit.Assert.*;
// import org.junit.BeforeClass;
// import org.junit.Test;
// import spark.Spark;
// import spark.utils.IOUtils;
//
// import java.io.IOException;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.util.HashMap;
// import java.util.Map;
//
// public class DonutControllerIntegrationTest {
//
//     @BeforeClass
//     public static void beforeClass() {
//         Main.main(null);
//     }
//
//     @AfterClass
//     public static void afterClass() {
//         Spark.stop();
//     }
//
//     @Test
//     public void aNewDonutShouldBeCreated() {
//         TestResponse res = request("POST", "/donuts?name=Glazed&topping=sugar&price=3");
//         Map<String, String> json = res.json();
//         assertEquals(200, res.status);
//         assertEquals("Glazed", json.get("name"));
//         assertEquals("sugar", json.get("topping"));
//         assertEquals("6", json.get("price"));
//         assertNotNull(json.get("id"));
//     }
//
//     private TestResponse request(String method, String path) {
//         try {
//             URL url = new URL("http://localhost:4567" + path);
//             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//             connection.setRequestMethod(method);
//             connection.setDoOutput(true);
//             connection.connect();
//             String body = IOUtils.toString(connection.getInputStream());
//             return new TestResponse(connection.getResponseCode(), body);
//         } catch (IOException e) {
//             e.printStackTrace();
//             fail("Sending request failed: " + e.getMessage());
//             return null;
//         }
//     }
//
//     private static class TestResponse {
//
//         public final String body;
//         public final int status;
//
//         public TestResponse(int status, String body) {
//             this.status = status;
//             this.body = body;
//         }
//
//         public Map<String,String> json() {
//             return new Gson().fromJson(body, HashMap.class);
//         }
//     }
// }
