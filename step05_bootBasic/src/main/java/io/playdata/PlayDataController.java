package io.playdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayDataController {

	//get방식만 수용하는 서비스 
	@GetMapping("getdata")
	public String m1() {
		return "playdata test";
	}
}
