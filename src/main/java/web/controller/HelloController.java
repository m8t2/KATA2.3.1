package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String getCar(Model model){
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Honda","CR-V", 2000));
		cars.add(new Car("Honda","Accord", 2001));
		cars.add(new Car("Honda","Stepwgn", 2002));
		cars.add(new Car("Honda","Pilot", 2008));
		cars.add(new Car("Honda","Jade", 2020));
		model.addAttribute("cars",cars);
		return "cars";
	}
	
}