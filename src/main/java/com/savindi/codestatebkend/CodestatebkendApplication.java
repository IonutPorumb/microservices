package com.savindi.codestatebkend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CodestatebkendApplication {
    final static String serverUrl1 = "https://gist.githubusercontent.com/danielyewright/1bec2dea6427577545de/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_hash.json";
    final static String serverUrl2 = "https://gist.githubusercontent.com/danielyewright/1bec2dea6427577545de/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json";

    public static void main(String[] args) {

        SpringApplication.run(CodestatebkendApplication.class, args);
    }
    @ExceptionHandler
    public static String requestProcessedData(int urlId){
        String serverUrl = null;
        if(urlId == 1){
            serverUrl = serverUrl1;
        } else if (urlId ==2){
            serverUrl = serverUrl2;
        } else {
            return "ERROR";
        }

        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        System.out.println(serverUrl);
        return (result);
    }

    @GetMapping("/")
    public static String hello(){
        return "HELLO IN DATA READER";
    }

    @GetMapping("/readDataForCode")
    public static String requestCodeData(){
        return requestProcessedData(1);
    }
    @GetMapping("/readDataForState")
    public static String requestStateData(){
        return requestProcessedData(2);
    }





}
