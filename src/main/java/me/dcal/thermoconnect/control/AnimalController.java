package me.dcal.thermoconnect.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.service.FileService;

@RestController
public class AnimalController {
	@Autowired
	FileService fileservice;



	@PostMapping(path = "/ajoutAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	@ResponseBody
	public Integer addfile(@RequestPart("description")  BodyAnimal body,@RequestPart("files") List<MultipartFile> files
			,@RequestPart("picture") MultipartFile picture, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		System.out.println("upload");
		System.out.println(body);
		System.out.println();
		fileservice.saveFile(files.get(0), "abc1.png");
		fileservice.saveFile(files.get(1), "abc2.png");
		fileservice.saveFile(picture, "pic.png");
		return 1;
	}
}
