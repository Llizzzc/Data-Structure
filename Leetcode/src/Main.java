import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String encode = URLEncoder.encode("hello, 黎", StandardCharsets.UTF_8);
        System.out.println(encode);
        System.out.println(URLDecoder.decode(encode, StandardCharsets.UTF_8));
    }
}
