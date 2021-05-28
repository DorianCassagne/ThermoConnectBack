package me.dcal.thermoconnect.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;
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
	Random rand = new Random();

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
		if(!oa.isPresent())
			return false;
		animalRepository.delete(oa.get());
		return true;
	}
	
	public HttpEntity<byte[]> getStaticImage() throws IOException {
		File d = new File(fileStaticStoragePath+"/");
		System.out.println(d);
		File[] files = d.listFiles();
		System.out.println("nb de of picture"  + files.length);
	    RandomAccessFile f = new RandomAccessFile(files[rand.nextInt(files.length)], "r");
	    System.out.println(f);
	    byte[] b = new byte[(int)f.length()];
	    f.readFully(b);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(b.length);
	    f.close();

	    return new HttpEntity<byte[]>(b, headers);
	}
	public FileSystemResource getAnimalDocument(BodyAnimal ba) {
		if(ba.getDocuments().size() ==1 )
			return getFile(animalImagePath(ba.getBodyConnexion().getLogin(), ba.getIdAnimal())+"/"+ba.getDocuments().get(0));
		return null;
		
	}

	public FileService(FileStorageProperties fileStorageProperties) {
		this.fileStoragePath = Paths.get(fileStorageProperties.getUploadDir()).toString();
		this.fileStaticStoragePath = Paths.get(fileStorageProperties.getStaticDir()).toString();
		File file = new File(fileStoragePath);
		file.mkdir();
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

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
	private boolean deleteFile(String filename) {
		File file = new File(fileStoragePath +"/"+ filename);

		return file.delete();

	}

}
