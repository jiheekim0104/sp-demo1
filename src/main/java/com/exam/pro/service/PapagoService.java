package com.exam.pro.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PapagoService {
	@Autowired
	private ObjectMapper om;
	
	 public String translate(Map<String, String> param) throws JsonMappingException, JsonProcessingException {
		 if(param.get("text")==null||"".equals(param.get("text"))) {
			 return "";
		 }
	        String clientId = "1Vx94DluTqt08MikxayF";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "cu8gGQ00g7";//애플리케이션 클라이언트 시크릿값";

	        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        String text;
	        try {
	            text = URLEncoder.encode(param.get("text"), "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("인코딩 실패", e);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

	        String res = post(apiURL, requestHeaders, text, param);
	        Map<String, Object> map = om.readValue(res, Map.class);
	        Map<String, Object> map1 = (Map<String, Object>) map.get("message");
	        Map<String, String> map2 = (Map<String, String>) map1.get("result"); 
	        String translatedText = map2.get("translatedText");
	        return translatedText;
	    }

	    private String post(String apiUrl, Map<String, String> requestHeaders, String text, Map<String, String> param){
	        HttpURLConnection con = connect(apiUrl);
	        String postParams = "source="+param.get("source")+"&target="+param.get("target")+ "&text=" +text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
	        try {
	            con.setRequestMethod("POST");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }

	            con.setDoOutput(true);
	            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
	                wr.write(postParams.getBytes());
	                wr.flush();
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
	                return readBody(con.getInputStream());
	            } else {  // 에러 응답
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }

	    private HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }

	    private String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
}
