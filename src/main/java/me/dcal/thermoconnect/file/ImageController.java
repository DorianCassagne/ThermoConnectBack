package me.dcal.thermoconnect.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class ImageController {
	public static final String PATH = "/tmp/thermoconnect/";


	

//	@GetMapping("/filename")
//	public File[] filename() {
//		File repertoire = new File("server/src/main/resources/file/public/");
//
//		return repertoire.listFiles();
//	}
//	
	
	@GetMapping("/file/getFile/{file}")
	public FileSystemResource getPublicFile(@PathVariable("file") String filename) {
		return new FileSystemResource(new File(PATH+filename));
	}

	@PostMapping("/file/renameFile/{filename}")
	public String renamePublicFile(@RequestParam("newfilename") String newfilename,@RequestParam("old") String old, @PathVariable("filename") String filename) {

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
