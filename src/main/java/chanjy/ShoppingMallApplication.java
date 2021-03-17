package chanjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("chanjy.mapper")
@SpringBootApplication
public class ShoppingMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallApplication.class, args);
    }

}
