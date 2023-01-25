package org.rei.mvc.controller;

import org.rei.mvc.controller.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {


    //形參位置的request表示目前的請求
    //這是原生寫法，不需要這樣寫！
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + "password: " + password);
        return "success";
    }

    //通過控制器方法的形參獲取參數
    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username,
                            String password,
                            String[] hobby,
                            @RequestHeader(value="sayHaha",required = true,defaultValue = "hahaha")String host,
                            @CookieValue("JSESSIONID") String JSESSIONID) {
        //只要上方的參數名稱相同，就可以自動配對！(要html中tag對應的方法，預設傳輸方法為get的東西會噴到網址上)
        //若以String型別接收，當一個name有多個value時，會接收到一個用","分隔開的字串
        //若以String[]接收，則會收到一個Array
        //若前端的請求參數和controller中的變數不同，controller中會接到null值。此時可以用@RequestParam讓請求參數與變數有不同名稱
        //required莫認為true
        //傳參時，若參數非為必要，可加上defaultValue使null或""通過路徑配對門檻，進入控制器
        //RequestHeader用以取得Header中的資訊，如此處當value="Host"，則回傳localhost:8080；若找不到則可用defaultValue賦予預設值
        System.out.println("username: " + username + " password: " + password + " hobby" + Arrays.toString(hobby));
        return "success";
    }



    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        //Bean的constructor名稱要和form中的name相同才能注入資料
        return "success";
    }
}
