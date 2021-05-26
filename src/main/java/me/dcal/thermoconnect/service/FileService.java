package me.dcal.thermoconnect.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.dcal.thermoconnect.model.Animal;
import me.dcal.thermoconnect.model.api.BodyAnimal;
import me.dcal.thermoconnect.propertie.FileStorageProperties;
import me.dcal.thermoconnect.repository.AnimalRepository;

@Service
public class FileService {

	@Autowired
	AnimalRepository animalRepository;
	public final String fileStoragePath ;
	public final String fileStaticStoragePath ;

	public FileSystemResource getExampleFile() {
		return this.getFile("jpeg.png");
	}
	public FileSystemResource getAnimalImage(BodyAnimal ba) {
		Animal a = animalRepository.findById(ba.getIdAnimal()).get();
		if(a.getUrlPicture() == null) {
			return null;
		}
		return getFile(animalPath(ba.getBodyConnexion().getLogin(), ba.getIdAnimal())+"/"+a.getUrlPicture());
		
	}
	
	public boolean deleteAnimal(BodyAnimal ba) {
		Optional<Animal> oa =  animalRepository.findById(ba.getIdAnimal());
		if(oa.isEmpty())
			return false;
		animalRepository.delete(oa.get());
		return true;
	}
	
	public HttpEntity<byte[]> getStaticImage() throws IOException {

		int randomNum = ThreadLocalRandom.current().nextInt(1, 2+ 1);
	    RandomAccessFile f = new RandomAccessFile(fileStaticStoragePath+"/"+randomNum+".jpg", "r");
	    byte[] b = new byte[(int)f.length()];
	    f.readFully(b);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(b.length);

	    return new HttpEntity<byte[]>(b, headers);
	}
	public FileSystemResource getAnimalDocument(BodyAnimal ba) {
		Animal a = animalRepository.findById(ba.getIdAnimal()).get();
//		returna.getUrlPicture();
		if(ba.getDocuments().size() ==1 )
			return getFile(animalImagePath(ba.getBodyConnexion().getLogin(), ba.getIdAnimal())+"/"+ba.getDocuments().get(0));
		return null;
		
	}

	public FileService(FileStorageProperties fileStorageProperties) {
		this.fileStoragePath = Paths.get(fileStorageProperties.getUploadDir()).toString();
		this.fileStaticStoragePath = Paths.get(fileStorageProperties.getStaticDir()).toString();
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
		return animalPath(username,idAnimal)+"image/";
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
