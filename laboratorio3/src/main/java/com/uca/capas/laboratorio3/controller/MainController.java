package com.uca.capas.laboratorio3.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.laboratorio3.domain.Student;

@Controller
public class MainController {
	private List<Student> students = new ArrayList<Student>();
	
	@GetMapping(path = "/ejemplo1", produces =MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos \n"+"Programacion n capas";
	}
	
	@GetMapping("/ejemplo2")
	public @ResponseBody List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("nombre1","apellido","10/10/1992","ing Informatica", true),
				new Student("nombre2","apellido","10/10/1992","ing Informatica", false)
				);
	}
	
    @GetMapping("/inicio")
    public String inicio(Student student){
        return "index";
    }
    
	@PostMapping("/formData")
	public ModelAndView procesar(Student student) {
		students.add(student);
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", this.students);
		return mav;
	}
	
}