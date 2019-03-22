package cn.xuqplus.testalipayscallback;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import org.junit.Test;

public class TestAlipaysCallbackApplicationTests {

  @Test
  public void testAlipaySystemOauthTokenRequest() throws AlipayApiException {
    AlipayClient alipayClient = new DefaultAlipayClient(
            "https://openapi.alipay.com/gateway.do",
            "2018080760954356",
            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChuIgbxxxaOxIHXsQrQJB/4lqjTYlr5YGG2+IPzUMO//Ar/wiUMa5XJi3OxsoKm+JCRDrsIu7Oag3cfuo1W6jAbCwPzFcV3WkezB7MgDr/q/Do1nkgLHqk8N3OUjhQ8VnD1dX9spnMyHJkk0Zzv3W0ahFjGdWZpJg8b6WQ+SHb/PVXU9OMImUZ8rcQhJbFfPsXMPdSbGWW7fzOqjCd1J8UQOKfQ3auIlwzbR7mDliZyys2A5U4u+MeGOErNnDmM6nekQkryYMcOy1HD4+H7CNl1se+9GQsaMEHd+uB5LmTtkFBvyDTKZG/IzEt8pR/6FiaTFgMmFntFT7XFxP4kgq3AgMBAAECggEAYeVKv0Xwq85GQ5/iMCyNTFzBcUlmfqIXnoNMfTRL+7CCup9PmiXY23iJEjrT40gp1uNmp7sdxGX+rhNFw7cQmCrjIU0ZCmtVTwdRPYoCLPLwioIKIKfMNjx4iITNAnKXXCz9tO2AnK5aUPe2Fis4HVZ33/2rh65TWYJcPz4QeRHZORxkw5FDjUq5z8OAjM/RLNxWjcC491lKqs3xP8pFeocpQKS79STy5BaIYg3t0C5FsWpVYNjl+eN9TGbsiVurPXTQhZoE2WVYhtRIuGm2IM4pj84+7IIe2nmhWkUNYIwhgLB/HuZrW0WSm7uW3/O85eD4+CdrRWR1VEr1bn1eQQKBgQDNDYzv6nf/tb/yTOjURlF9504mpOxgrDWgeiHgMju52J8w3QlO9Zetu9ROnxHhqjjEtRFR13GaT4b5bNVvJpow8C3OqZxvwWbF0gaIr/bfF6YGgfgoZTEKhSk+1PA7ZP9wBWLl0AEU19XgkPCIqO0l/fKBxb/TIN7Uy56UPOcR3QKBgQDJ5tSVRH+N7M4BdQDjRolnoURPPp4s7KrShWpzIDRZ0auvVWsQem7bN8gFIsHss2eD4R7SaF+p/uFBaf/LSLWuQDXQJh2Fa5fWa5vYqXs9HRGpjmWAa19+KIgA2RpwNUK0CZoGXEafETbSILXvyRPk2wkN0O+HSGuEXitc040nowKBgDOo6Uv8V1Ud9gjWZYYtXRSKNL85p6/HUw9mFajFHxT4RUrrNRAmgZssihVwr/GZkAnG0GE9FQraZFfsmm0RXaFcsT2yr43cPMcz3Z+MLXcRHyvejKWosM1EtRp2TTu5ez0+ribV25/jrKeR/HeBj5WVwAX/yw8m5dzYm9Ae89wlAoGAIa59Zk1gDhgkIcAYHtIkmAIiOCoVDx+IO8iAAqartRQyVPSmAMC7/5wlpR2wRkGDkk+a6bT5yI05nMUHJC2ECYays3+4Swqw8NdQz2suoPpZePTFYBAJhS1Tyvhs3a007H3xkQAR0/V2NMW6ND9SL0qPDxv86Y+eSB3BlCHCmYsCgYAGo1Gik9SPpCvM9tKeq5Y3MnOv1966kdtJiSJecRJMon6twKBIRj4a21poNUqcRhzVpk0AOPvMpSfuLCETsFva97n8qCe3Ttgq5Cvk9wtuVi1a2JL3sRzGmGSvZik27cBJOJCvLIMgzSBHr6Ct+IXOt5s7F9/9Tb/ry8xo+6ZKgg==",
            "json",
            "GBK",
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoB3a1OPeLkhrNpGNZ2gcfyHBany5UMNbwxjRVGlwxcnQIEUwIe7vVJz4Vl277J4BBuuxBZwgp43/4OAs450D0doECzJ1nXz070aylTkalIrsqjuD8dY2fdjO0Msi7uYGuPmgXHke2GjxLLYHWsSKhMyjVYkOgQkYzKQbj5XDJmVrVh3yzeUu7hzb3a+a7cBNVk0sRqC16NKU38Y4nNAZgsgZn+p/rs39CxItqca2/qpdcmFJWPOtJZIE06iZ3OZeTtqx2CK+uUN8sgG0PL2k8iqSV2naSFiaiQT3omwjZOwOY/RHqtZFpMcK0Pnew1GnS7f99uGI0YDrZDA399kzrQIDAQAB",
            "RSA2");
    AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
    request.setGrantType("authorization_code");
    request.setCode("125e88c691fd410198371500d12bXX22");
//    request.setRefreshToken("201208134b203fe6c11548bcabd8da5bb087a83b"); // 不填也能请求成功
    AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
    if (response.isSuccess()) {
      System.out.println("调用成功");
    } else {
      System.out.println("调用失败");
    }
  }

  @Test
  public void testAlipayUserInfoShareRequest() throws AlipayApiException {
    AlipayClient alipayClient = new DefaultAlipayClient(
            "https://openapi.alipay.com/gateway.do",
            "2018080760954356",
            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChuIgbxxxaOxIHXsQrQJB/4lqjTYlr5YGG2+IPzUMO//Ar/wiUMa5XJi3OxsoKm+JCRDrsIu7Oag3cfuo1W6jAbCwPzFcV3WkezB7MgDr/q/Do1nkgLHqk8N3OUjhQ8VnD1dX9spnMyHJkk0Zzv3W0ahFjGdWZpJg8b6WQ+SHb/PVXU9OMImUZ8rcQhJbFfPsXMPdSbGWW7fzOqjCd1J8UQOKfQ3auIlwzbR7mDliZyys2A5U4u+MeGOErNnDmM6nekQkryYMcOy1HD4+H7CNl1se+9GQsaMEHd+uB5LmTtkFBvyDTKZG/IzEt8pR/6FiaTFgMmFntFT7XFxP4kgq3AgMBAAECggEAYeVKv0Xwq85GQ5/iMCyNTFzBcUlmfqIXnoNMfTRL+7CCup9PmiXY23iJEjrT40gp1uNmp7sdxGX+rhNFw7cQmCrjIU0ZCmtVTwdRPYoCLPLwioIKIKfMNjx4iITNAnKXXCz9tO2AnK5aUPe2Fis4HVZ33/2rh65TWYJcPz4QeRHZORxkw5FDjUq5z8OAjM/RLNxWjcC491lKqs3xP8pFeocpQKS79STy5BaIYg3t0C5FsWpVYNjl+eN9TGbsiVurPXTQhZoE2WVYhtRIuGm2IM4pj84+7IIe2nmhWkUNYIwhgLB/HuZrW0WSm7uW3/O85eD4+CdrRWR1VEr1bn1eQQKBgQDNDYzv6nf/tb/yTOjURlF9504mpOxgrDWgeiHgMju52J8w3QlO9Zetu9ROnxHhqjjEtRFR13GaT4b5bNVvJpow8C3OqZxvwWbF0gaIr/bfF6YGgfgoZTEKhSk+1PA7ZP9wBWLl0AEU19XgkPCIqO0l/fKBxb/TIN7Uy56UPOcR3QKBgQDJ5tSVRH+N7M4BdQDjRolnoURPPp4s7KrShWpzIDRZ0auvVWsQem7bN8gFIsHss2eD4R7SaF+p/uFBaf/LSLWuQDXQJh2Fa5fWa5vYqXs9HRGpjmWAa19+KIgA2RpwNUK0CZoGXEafETbSILXvyRPk2wkN0O+HSGuEXitc040nowKBgDOo6Uv8V1Ud9gjWZYYtXRSKNL85p6/HUw9mFajFHxT4RUrrNRAmgZssihVwr/GZkAnG0GE9FQraZFfsmm0RXaFcsT2yr43cPMcz3Z+MLXcRHyvejKWosM1EtRp2TTu5ez0+ribV25/jrKeR/HeBj5WVwAX/yw8m5dzYm9Ae89wlAoGAIa59Zk1gDhgkIcAYHtIkmAIiOCoVDx+IO8iAAqartRQyVPSmAMC7/5wlpR2wRkGDkk+a6bT5yI05nMUHJC2ECYays3+4Swqw8NdQz2suoPpZePTFYBAJhS1Tyvhs3a007H3xkQAR0/V2NMW6ND9SL0qPDxv86Y+eSB3BlCHCmYsCgYAGo1Gik9SPpCvM9tKeq5Y3MnOv1966kdtJiSJecRJMon6twKBIRj4a21poNUqcRhzVpk0AOPvMpSfuLCETsFva97n8qCe3Ttgq5Cvk9wtuVi1a2JL3sRzGmGSvZik27cBJOJCvLIMgzSBHr6Ct+IXOt5s7F9/9Tb/ry8xo+6ZKgg==",
            "json",
            "GBK",
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoB3a1OPeLkhrNpGNZ2gcfyHBany5UMNbwxjRVGlwxcnQIEUwIe7vVJz4Vl277J4BBuuxBZwgp43/4OAs450D0doECzJ1nXz070aylTkalIrsqjuD8dY2fdjO0Msi7uYGuPmgXHke2GjxLLYHWsSKhMyjVYkOgQkYzKQbj5XDJmVrVh3yzeUu7hzb3a+a7cBNVk0sRqC16NKU38Y4nNAZgsgZn+p/rs39CxItqca2/qpdcmFJWPOtJZIE06iZ3OZeTtqx2CK+uUN8sgG0PL2k8iqSV2naSFiaiQT3omwjZOwOY/RHqtZFpMcK0Pnew1GnS7f99uGI0YDrZDA399kzrQIDAQAB",
            "RSA2");
    AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
    AlipayUserInfoShareResponse response = alipayClient.execute(request, "f303d022d79d45648a1c9bc0bb60NX22");
    if (response.isSuccess()) {
      System.out.println("调用成功");
    } else {
      System.out.println("调用失败");
    }
  }
}
