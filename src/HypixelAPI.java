import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class HypixelAPI {

    public static void main(String[] args) {
        String APIkey = "5234a6778cf2d15222192ed6";

        System.out.print("Which is your MC UUID? ");
        Scanner s = new Scanner(System.in);
        String UUID = s.nextLine();

        //String URL = "https://api.hypixel.net/player?key=" + APIkey + "&uuid=" + "bad34822-40a5-4d32-88c3-18b9581e8eb9";
        String URL = "https://api.hypixel.net/player?key=" + APIkey + "&uuid=" + UUID;
        makeAPICall(URL);
    }

    public static void makeAPICall(String url) {
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}