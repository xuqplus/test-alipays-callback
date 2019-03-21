package cn.xuqplus.testalipayscallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

  @GetMapping("callback")
  public String callback(String app_id, String scope, String auth_code) {
    LOGGER.info("app_id={}, scope={}, auth_code={}, ", app_id, scope, auth_code);
    return String.format("app_id=%s, scope=%s, auth_code=%s, ", app_id, scope, auth_code);
  }

  @GetMapping("auth")
  public ModelAndView auth(ModelAndView mav, HttpServletRequest request) throws UnsupportedEncodingException {
    String remoteAddr = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length());
    String callback = URLEncoder.encode("http://106.12.80.76:8090/callback", "utf8");
    mav.setViewName(String.format("redirect:https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=%s&scope=auth_base&redirect_uri=%s",
            "2018080760954356",
            callback));
    return mav;
  }
}
