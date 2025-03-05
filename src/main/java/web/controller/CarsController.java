package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAOImpl;
import web.model.Car;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class CarsController {

	private final CarDAOImpl carDAO;

	public CarsController(CarDAOImpl carDAO) {
		this.carDAO = carDAO;
	}

	@GetMapping("/cars")
	public String getCar(@RequestParam (name = "count", defaultValue = "5") int amount, Model model){
		List<Car> cars = carDAO.getCar(amount);
		model.addAttribute("cars", cars);
		return "cars";
	}
	
}