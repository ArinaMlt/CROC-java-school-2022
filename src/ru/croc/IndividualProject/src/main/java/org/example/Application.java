package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
  /*      public static void main(String[] args) throws IOException {

        try {
        System.out.println(GoogleTranslate.translate("r", "how are you"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
