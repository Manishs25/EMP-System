package com.project.EmpSystem.controller;

import com.project.EmpSystem.entity.Employee;
import com.project.EmpSystem.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> emp = empService.getAllEmp();
        model.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "addemp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee, HttpSession session) {
        empService.addEmp(employee);
        System.out.println(employee);
        session.setAttribute("msg", "Employee added successfully...");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = empService.getEMpById(id);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
        empService.addEmp(e);
        session.setAttribute("msg", "Emp Data Update Sucessfully..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEMp(@PathVariable int id, HttpSession session) {

        empService.deleteEMp(id);
        session.setAttribute("msg", "Emp Data Delete Sucessfully..");
        return "redirect:/";
    }
}
