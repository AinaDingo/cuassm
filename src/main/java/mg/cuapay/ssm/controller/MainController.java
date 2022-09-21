package mg.cuapay.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableAutoConfiguration
public class MainController {

    @Value("${dynamodb.access.key}") //from parameter store
    private String accessKey;

    @Value("${exploreparamstore.device.token}")  //from parameter store
    private String deviceToken;


    @Value("${username}")       //from secret manager
    private String username;


    @GetMapping("/parameter")
    public ResponseEntity<String> getParam() {
        log.info("Parameter Store  Access Key {}", accessKey);
        log.info("Parameter Store Device Token {}", deviceToken);
        log.info("Secret Manager test1's value {}", username);

        return ResponseEntity.ok("hello");
    }
}