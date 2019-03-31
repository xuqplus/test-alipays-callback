package cn.xuqplus.testalipayscallback;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class TestAlipaysCallbackApplication {

  public static class AlipaysApp {
    public String appId;
    public String appName;
    public String publicKey;
    public String privateKey;
    public String domain;
    public String authCallbackUrl;

    public AlipaysApp(String appId, String appName, String publicKey, String privateKey, String domain, String authCallbackUrl) {
      this.appId = appId;
      this.appName = appName;
      this.publicKey = publicKey;
      this.privateKey = privateKey;
      this.domain = domain;
      this.authCallbackUrl = authCallbackUrl;
    }
  }

  private static final AlipaysApp app = new AlipaysApp(
          "2018080760954356",
          "xuqplus的创意工坊",
          "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",
          "http://192.168.1.5:8090/",
          "http://192.168.1.5:8090/callback/");

  private static final String getRemoteAddr(HttpServletRequest request) {
    String XForwardedFor = request.getHeader("X-Forwarded-For");
    if (StringUtils.isEmpty(XForwardedFor)) {
      return request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length());
    }
    return XForwardedFor;
  }

  private static final int nextInt(int n) {
    return new Random().nextInt(n);
  }

  public static class Res {
    public String code;
    public String msg;
    public Object data;

    public Res(String code, String msg, Object data) {
      this.code = code;
      this.msg = msg;
      this.data = data;
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(TestAlipaysCallbackApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TestAlipaysCallbackApplication.class, args);
  }

  @GetMapping("appToAppAuth")
  public ModelAndView appToAppAuth(ModelAndView mav, String orderNo) throws UnsupportedEncodingException {
    String callback = URLEncoder.encode(app.authCallbackUrl + orderNo, "utf8");
    LOGGER.info("auth, orderNO={}, callback={}", orderNo, callback);
    mav.setViewName(String.format("redirect:https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=%s&scope=auth_base&redirect_uri=%s", app.appId, callback));
    return mav;
  }

  @GetMapping("publicAppAuthorize")
  public ModelAndView publicAppAuthorize(ModelAndView mav, String no) throws UnsupportedEncodingException {
    String callback = URLEncoder.encode(app.authCallbackUrl + no, "utf8");
    LOGGER.info("auth, orderNO={}, callback={}", no, callback);
    mav.setViewName(String.format("redirect:https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=%s&scope=auth_base&redirect_uri=%s", app.appId, callback));
    return mav;
  }

  /**
   * 授权回调地址
   * userId, tradeNo绑定
   */
  @GetMapping("callback/{no}")
  public ModelAndView callback(@PathVariable String no, String app_id, String scope, String auth_code, ModelAndView mav) {
    LOGGER.info("callback, no={}, app_id={}, scope={}, auth_code={}, ", no, app_id, scope, auth_code);
    Object[] order = orders.get(no);
    if (null == order[5]) {
      AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", app.appId, app.privateKey, "json", "UTF-8", app.publicKey, "RSA2");
      AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
      request.setGrantType("authorization_code");
      request.setCode(auth_code);
      try {
        AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
          orders.get(no)[5] = response.getUserId(); // 支付宝userId
          users.put(response.getUserId(), no);
          LOGGER.info("no={}, userId={}", no, response.getUserId());
        }
      } catch (AlipayApiException e) {
        LOGGER.info("auth_code={}, 换取userId失败, e.message={}, e.getErrMsg={}", auth_code, e.getMessage(), e.getErrMsg());
      }
    }
    mav.addObject("no", no);
    if (null == order[6]) {
      Object[] merchant = (Object[]) order[4];
      mav.addObject("add", true);
      mav.addObject("userId", merchant[1]);
      mav.addObject("loginId", merchant[0]);
    }
    mav.setViewName("query");
    return mav;
  }

  /* order */
  private static Map<String, Object[]> orders = new HashMap<>();
  private static Map<String, Object[]> merchants = new HashMap<>();
  private static Map<String, String> users = new HashMap<>(); // 每个userId当前只有一单

  static {
    merchants.put("340824a05nw.cdb@sina.cn", new Object[]{"340824a05nw.cdb@sina.cn", "2088012758570434", null});
  }

  @GetMapping("order")
  public Object order(String no, String amount, String desc, ModelAndView mav, HttpServletRequest request) throws Exception {
    LOGGER.info("order no={}, amount={}, desc={}", no, amount, desc);
    if (StringUtils.isEmpty(no) && !StringUtils.isEmpty(amount)) {
      /* 创建 */
      long createAt = System.currentTimeMillis();
      no = String.format("no_%s_%s", createAt, nextInt(1000000));

      if (orders.containsKey(no)) {
        throw new Exception("no重复, 创建失败");
      }
      Object[] merchant = merchants.get(merchants.keySet().toArray()[nextInt(merchants.keySet().size())]);
      orders.put(no, new Object[]{no, amount, desc, createAt, merchant, null, null, null});
      mav.setViewName(String.format("redirect:https://render.alipay.com/p/s/i?scheme=%s",
              URLEncoder.encode(String.format("alipays://platformapi/startapp?saId=10000007&qrcode=%s",
                      URLEncoder.encode(String.format("%s/publicAppAuthorize?no=%s", getRemoteAddr(request), no), "utf-8")), "utf-8")));
    }
    return mav;
  }

  @GetMapping("query")
  public Object query(String no, HttpServletRequest request) throws UnsupportedEncodingException {
    LOGGER.info("query no={}", no);
    /* 查询 */
    Object[] order = orders.get(no);
    // 未绑定付款用户
    Object userId = order[5];
    Object aliTradeNo = order[6];
    Boolean payed = (Boolean) order[7];
    if (StringUtils.isEmpty(userId)) {
      String data = String.format("redirect:https://render.alipay.com/p/s/i?scheme=%s",
              URLEncoder.encode(String.format("alipays://platformapi/startapp?saId=10000007&qrcode=%s",
                      URLEncoder.encode(String.format("%s/publicAppAuthorize?no=%s", getRemoteAddr(request), no), "utf-8")), "utf-8"));
      return new Res("1", "redirect", data);
    }
    if (StringUtils.isEmpty(aliTradeNo)) {
      return new Res("2", "wait", null);
    }
    if (null != payed && payed) {
      return new Res("3", "payed", null);
    }
    return new Res("0", "ok", aliTradeNo);
  }

  /* vxp */
  @GetMapping("userId")
  public Object userId(String userId) {
    LOGGER.info("userId userId={}", userId);
    String no = users.get(userId);
    Object[] order = orders.get(no);
    Object amount = order[1];
    Object desc = order[2];
    Object createAt = order[3];
    Object[] merchant = (Object[]) order[4];
    Object userId0 = order[5];
    Object aliTradeNo = order[6];
    if (null == aliTradeNo) {
      Map r = new HashMap();
      r.put("no", no);
      r.put("amount", amount);
      r.put("desc", desc);
      r.put("createAt", createAt);
      r.put("merchant", merchant);
      r.put("userId", userId);
      return new Res("0", "ok", r);
    }
    return new Res("1", "err", null);
  }

  @GetMapping("update")
  public Object update(String no, String aliTradeNo) {
    LOGGER.info("update no={}, aliTradeNo={}", no, aliTradeNo);
    orders.get(no)[6] = aliTradeNo;
    return new Res("0", "ok", null);
  }

  @GetMapping("notify")
  public Object notify( String aliTradeNo) {
    LOGGER.info("notify aliTradeNo={}", aliTradeNo);
    return new Res("0", "ok", null);
  }
}
