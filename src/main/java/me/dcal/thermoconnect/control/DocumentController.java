package me.dcal.thermoconnect.control;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.service.FileService;
@RestController
public class DocumentController {
	public static final String PATH = "/tmp/thermoconnect/";


	

//	@GetMapping("/filename")
//	public File[] filename() {
//		File repertoire = new File("server/src/main/resources/file/public/");
//
//		return repertoire.listFiles();
//	}
//	
	

	@Autowired
	FileService fileservice;
	
	
	
	@PostMapping(path = "/getFile",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public FileSystemResource connexion(@RequestBody BodyConnexion body,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return fileservice.getExampleFile();
		
	}
	
//	@PostMapping(path = "/ajoutAnimal",consumes = {MediaType.APPLICATION_JSON_VALUE,
//			MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
//	@ResponseBody
//	public Integer addfile(@RequestPart("description")  BodyAnimal body,@RequestPart("files") List<MultipartFile> files
//			,@RequestPart("picture") MultipartFile picture, HttpServletRequest request,
//			HttpServletResponse response, Model model) {
//		System.out.println("upload");
//		System.out.println(body);
//		System.out.println();
//		fileservice.saveFile(files.get(0), "abc1.png");
//		fileservice.saveFile(files.get(1), "abc2.png");
//		fileservice.saveFile(picture, "pic.png");
//		return 1;
//	}
	@GetMapping("/file/getFile/{file}")
	public FileSystemResource getPublicFile(@PathVariable("file") String filename) {
		return new FileSystemResource(new File(PATH+filename));
	}

	@PostMapping("/file/renameFile/{filename}")
	public String renameFile(@RequestParam("newfilename") String newfilename,@RequestParam("old") String old, @PathVariable("filename") String filename) {

		try{

			new File(PATH+"/"+old).renameTo(new File(PATH+"/"+newfilename));

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}

	@PostMapping("/file/saveFile/{filename}")
	public String savePublicFile(@RequestParam("file") MultipartFile file, @PathVariable("filename") String filename) {

		try{
			byte barr[]=file.getBytes();

			BufferedOutputStream bout=new BufferedOutputStream(
					new FileOutputStream(PATH+"/"+filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}

	

}
