import java.io.IOException;

public class App {

    public static void main(String[] args) {
        Http http = new Http();
        try {
            http.getData();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
