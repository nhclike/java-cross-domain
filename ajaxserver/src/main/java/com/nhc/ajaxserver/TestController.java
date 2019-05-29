package com.nhc.ajaxserver;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//@CrossOrigin   //spring支持跨域的注解
public class TestController {

    @GetMapping("/get1")
    private ResultBean get1(){
        System.out.print("TestController.get1()");
        ResultBean rb=new ResultBean("li");
        System.out.println(rb.getData()+"rb");
        rb.setData("get1 is ok");
        return new ResultBean("li");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user){

        System.out.println("TestController.postJson");
        return new ResultBean("postJson"+user.getName());
    }


    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value = "cookie1") String cookie1){
        System.out.println("TestController.getCookie");

        return new ResultBean("cookie1"+cookie1);
    }

    @GetMapping("/getHeader")
    public ResultBean  getHeader(@RequestHeader("x-header1") String header1,@RequestHeader("x-header2") String header2){
        System.out.println("TestController.getHeader");
        return new ResultBean("getHeader"+header1+""+header2);
    }
}

