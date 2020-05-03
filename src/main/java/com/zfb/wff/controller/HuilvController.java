package com.zfb.wff.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * "人民币":"CNY"
 * "美元": "USD"
 * "韩国元": "KRW"
 * "新台币": "TWD"
 * "日元": "JPY"
 * "澳大利亚元": "AUD"
 * "英镑": "GBP"
 * "印尼卢比": "IDR"
 * "新西兰元": "NZD"
 * "新加坡元": "SGD"
 * "泰国铢": "THB"
 * "瑞典克朗": "SEK"
 * "瑞士法郎": "CHF"
 * "卢布": "RUB"
 * "菲律宾比索": "PHP"
 * "港币": "HKD"
 * "林吉特": "MYR"
 * "欧元": "EUR"
 * "印度卢比": "INR"
 * "丹麦克朗": "DKK"
 * "加拿大元": "CAD"
 * "挪威克朗": "NOK"
 * "阿联酋迪拉姆": "AED"
 * "沙特里亚尔": "SAR"
 * "巴西里亚尔": "BRL"
 * "澳门元": "MOP"
 * "南非兰特": "ZAR"
 * "土耳其里拉": "TRY"
 *
 */
@RestController
@RequestMapping("/huilv")
public class HuilvController {
	
	@GetMapping
	String getHuilv() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://api.tianapi.com/txapi/fxrate/index?key=1fd43e3b714d686502ae42d87ba73c18&fromcoin=USD&tocoin=CNY&money=1";
		HttpMethod method = HttpMethod.GET;
		HttpEntity requestEntity = null;
		
		String huilv = "兑换1美元所需要的人民币：" + restTemplate.exchange(url, method, requestEntity, String.class).getBody().substring(50, 56);
		return huilv;
	}
}
