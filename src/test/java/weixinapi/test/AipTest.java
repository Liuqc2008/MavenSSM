package weixinapi.test;


import java.net.URLEncoder;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import weixin.sdk.api.WeixinOauth2Api;

public class AipTest {
	
	@Ignore
	@Test
	public void GetUserInfoByOpenId() throws Exception {
		Map<String, Object> resule = WeixinOauth2Api.GetUserInfoByOpenId("oOaWMty6ZXxCEr967bKp9NUH5hSU");
		
		System.out.println(JSON.toJSONString(resule));
	}
	
	//@Ignore
	@Test
	public void WeixinOauth2ApiGetCode() throws Exception {
		
		String returnUrl = URLEncoder.encode("http://313624981.tunnel.qydev.com/weixin/Oauth", "UTF-8");
		String codeUrl = WeixinOauth2Api.GetUrl(returnUrl, "snsapi_userinfo");
		
		System.out.println(codeUrl);
	}
}
