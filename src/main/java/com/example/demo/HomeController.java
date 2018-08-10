package com.example.demo;

import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/base")
    public String baseForm(Model model)
    {
        model.addAttribute("baseform");
        return "base";
    }

    @RequestMapping("/")
    public String listEmployee(Model model)
    {
        model.addAttribute("employees",employeeRepository.findAll());
        return "employeelist";
    }

    @RequestMapping("/process" )
    public String processemployeeForm (@RequestParam("search") String firstname, Model model)
    {
        model.addAttribute("employees",employeeRepository.findByFirstname(firstname));
        return "employeelist";
    }
//    @RequestMapping("/processdepartmet" )
//    public String processdepartmentForm (@RequestParam("search") String name, Model model)
//    {
//        model.addAttribute("departments",departmentRepository.findByName(name));
//        return "departmentlist";
//    }
    @RequestMapping("/department")
    public String listdepartment(Model model)
    {
        model.addAttribute("departments",departmentRepository.findAll());
        return "departmentlist";
    }



    @PostMapping("/processdepartmet" )
    public String processFormDepartment (@RequestParam("searchdepartment") String departmentname, Model model)
    {
        model.addAttribute("departments",departmentRepository.findByName(departmentname));

      return "departmentlist";
    }

//    @PostMapping("/allemployee")
//    public String listallemployi(@PathVariable("id") String departmentname , Model model)
//    {
//
//        long val = Long.valueOf(departmentname);
//        model.addAttribute("employees",employeeRepository.findById(val));
//        return  "allemployee";
//    }

    @RequestMapping("/detail/{id}")
    public String showdetails(@PathVariable("id") long id , Model model)
    {
        model.addAttribute("employees",employeeRepository.findById(id).get());
        return  "employeeshow";
    }
    @RequestMapping("/detailnew/{id}")
    public String showdetailsemployee(@PathVariable("id") long id , Model model)
    {
        model.addAttribute("employees",employeeRepository.findBydepartment_id(id));
        return  "allemployee";
    }

}
