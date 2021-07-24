/**
 * 
 */
package com.SpringBootDemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yijun
 *
 */
@RestController
//@Controller
@RequestMapping("/hello")
public class Controller {
	@RequestMapping("")
	public String hello() {
		return "hello world";
	}

}
