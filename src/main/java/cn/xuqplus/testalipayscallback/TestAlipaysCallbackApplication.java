package cn.xuqplus.testalipayscallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class TestAlipaysCallbackApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestAlipaysCallbackApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TestAlipaysCallbackApplication.class, args);
  }

  @RequestMapping("")
  public String a(@RequestBody Map data) {
    data.forEach((k, v) -> LOGGER.info("key={}, val={}", k, v));
    return "ok";
  }

  @RequestMapping("callback")
  public String callback(@RequestBody Map data) {
    data.forEach((k, v) -> LOGGER.info("key={}, val={}", k, v));
    return "ok";
  }
}
