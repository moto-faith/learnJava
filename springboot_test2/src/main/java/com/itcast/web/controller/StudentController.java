package com.itcast.web.controller;

import com.itcast.model.Student;
import com.itcast.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-28
 * Time: 16:28
 */
@Controller
@RequestMapping("stu")
public class StudentController {

    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("loginname","xp");
        model.addAttribute("age",33);
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"a","man"));
        list.add(new Student(3,"b","woman"));
        list.add(new Student(2,"c","man"));
        model.addAttribute("stuList",list);
        return "stu/list";
    }
}
