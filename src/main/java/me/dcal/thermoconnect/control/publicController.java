package me.dcal.thermoconnect.control;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.dcal.thermoconnect.service.FileService;



@Controller
public class publicController {
	
	@Autowired
	FileService fileService;
	

	@RequestMapping("/pic")
	@ResponseBody
	public HttpEntity<byte[]> getRandomImage() throws IOException {
	    return fileService.getStaticImage();
	}
	
	@RequestMapping("/alive")
	@ResponseBody
	public Integer isAlive(){
	    return 1;
	}
}
