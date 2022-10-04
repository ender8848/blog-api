package blog.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogAppMain {
    public static void main(String[] args) {
        try {
            SpringApplication.run(BlogAppMain.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}