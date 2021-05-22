package me.dcal.thermoconnect.service;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import me.dcal.thermoconnect.service.FileStorageProperties;
import me.dcal.thermoconnect.file.FileStorageException;
@Service
public class FileService {


public final String fileStoragePath ;



public FileService(FileStorageProperties fileStorageProperties) {
	this.fileStoragePath = Paths.get(fileStorageProperties.getUploadDir()).toString();

    System.out.println(fileStoragePath);
	File file = new File(fileStoragePath);
	
	

	boolean dirCreated = file.mkdir();
	
}
	

//	@GetMapping("/filename")
//	public File[] filename() {
//		File repertoire = new File("server/src/main/resources/file/public/");
//
//		return repertoire.listFiles();
//	}
//	

	public FileSystemResource getFile(String filename) {
		return new FileSystemResource(new File(fileStoragePath+filename));
	}
	
	public String renameFile( String newfilename,String old,  String filename) {

		try{

			new File(fileStoragePath+"/"+old).renameTo(new File(fileStoragePath+newfilename));

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}
	
	
	public String savePublicFile(MultipartFile file, String filename) {

		try{
			byte barr[]=file.getBytes();

			BufferedOutputStream bout=new BufferedOutputStream(
					new FileOutputStream(fileStoragePath+filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}
	
	public boolean deleteFile(String filename) {
		File file = new File(fileStoragePath + filename);
    
		return file.delete();
    	
	}

}
