package me.dcal.thermoconnect.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.dcal.thermoconnect.service.FileService;



@Controller
public class publicController {
	
	@Autowired
	FileService fileService;
	

	@RequestMapping("/pic")
	@ResponseBody
	public HttpEntity<byte[]> getArticleImage() throws IOException {

		int randomNum = ThreadLocalRandom.current().nextInt(1, 4+ 1);
	    RandomAccessFile f = new RandomAccessFile("/tmp/thermo/"+randomNum+".jpg", "r");
	    byte[] b = new byte[(int)f.length()];
	    f.readFully(b);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(b.length);

	    return new HttpEntity<byte[]>(b, headers);
	}
}
