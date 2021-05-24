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
	
		File file = new File(fileStoragePath);
		boolean dirCreated = file.mkdir();
	}

	public boolean saveAnimalImage(String username,int idAnimal, MultipartFile file,String fileName) {
		initUserAnimalFolder(username, idAnimal);
		saveFile(file, animalPath(username, idAnimal)+fileName);
		return true;
	}

	
	public boolean saveAnimalDocument(String username,int idAnimal, MultipartFile file,String fileName) {
		initUserAnimalFolder(username, idAnimal);
		saveFile(file, animalImagePath(username, idAnimal)+fileName);
		return true;
	}
	
	private void initUserAnimalFolder(String username, int idAnimal) {
		createDirectory(userPath(username));
		createDirectory(animalPath(username,idAnimal));
		createDirectory(animalImagePath(username,idAnimal));
	}
	private String userPath(String username) {
		return username+"/";
	}
	private String animalPath(String username,int idAnimal) {
		return userPath(username)+idAnimal+"/";
	}
	private String animalImagePath(String username,int idAnimal) {
		return animalPath(username,idAnimal)+"/image/";
	}
	private boolean createDirectory(String path) {
		File file = new File(fileStoragePath+"/"+path);
		return file.mkdir();
	}

	private FileSystemResource getFile(String filename) {
		return new FileSystemResource(new File(fileStoragePath+"/"+filename));
	}

	private boolean renameFile( String newfilename,String old,  String filename) {

		try{

			new File(fileStoragePath+"/"+old).renameTo(new File(fileStoragePath+"/"+newfilename));

		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return true;

	}


	private String saveFile(MultipartFile file, String filename) {

		try{
			byte barr[]=file.getBytes();

			BufferedOutputStream bout=new BufferedOutputStream(
					new FileOutputStream(fileStoragePath+"/"+filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		}catch(Exception e){System.out.println(e);}
		return "okay\n";

	}

	private boolean deleteFile(String filename) {
		File file = new File(fileStoragePath +"/"+ filename);

		return file.delete();

	}

}
