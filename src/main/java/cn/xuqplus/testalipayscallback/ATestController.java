package cn.xuqplus.testalipayscallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("aTest")
public class ATestController {

  @GetMapping("aa")
  public Object aa(HttpServletRequest request) {
    return "aa";
  }

  @PostMapping("aa")
  public Object aa0(HttpServletRequest request) {
    return "aa0";
  }
}
