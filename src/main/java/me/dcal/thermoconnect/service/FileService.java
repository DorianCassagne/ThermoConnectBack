package me.dcal.thermoconnect.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileService {

	
public static final String PATH = "/tmp/thermoconnect/";


	

//	@GetMapping("/filename")
//	public File[] filename() {
//		File repertoire = new File("server/src/main/resources/file/public/");
//
//		return repertoire.listFiles();
//	}
//	

	public FileSystemResource getFile(String filename) {
		return new FileSystemResource(new File(PATH+filename));
	}
	
	public String renameFile( String newfilename,String old,  String filename) {

		try{

			new File(PATH+"/"+old).renameTo(new File(PATH+newfilename));

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}
	
	
	public String savePublicFile(MultipartFile file, String filename) {

		try{
			byte barr[]=file.getBytes();

			BufferedOutputStream bout=new BufferedOutputStream(
					new FileOutputStream(PATH+filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}

}
