package blog.api;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "blog.api.mapper")
public class BlogAppMain {
    public static void main(String[] args) {
        try {
            SpringApplication.run(BlogAppMain.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}