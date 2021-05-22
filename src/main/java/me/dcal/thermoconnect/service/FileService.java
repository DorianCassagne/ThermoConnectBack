package me.dcal.thermoconnect.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import me.dcal.thermoconnect.propertie.FileStorageProperties;

@Service
public class FileService {


	public final String fileStoragePath ;



	public FileService(FileStorageProperties fileStorageProperties) {
		this.fileStoragePath = Paths.get(fileStorageProperties.getUploadDir()).toString();

		System.out.println(fileStoragePath);
		File file = new File(fileStoragePath);
		boolean dirCreated = file.mkdir();
	}




	public boolean createDirectory(String path) {
		File file = new File(path);
		return file.mkdir();
	}

	public FileSystemResource getFile(String filename) {
		return new FileSystemResource(new File(fileStoragePath+filename));
	}

	public boolean renameFile( String newfilename,String old,  String filename) {

		try{

			new File(fileStoragePath+"/"+old).renameTo(new File(fileStoragePath+newfilename));

		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return true;

	}


	public String saveFile(MultipartFile file, String filename) {

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
