package me.dcal.thermoconnect;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
public class Accueil {


//    @RequestMapping("/")
//    public Test accueil(Model model) throws ParseException {
//    	System.out.println("cacapipi");
//    	return new Test(123);
//    }
    
	@GetMapping("/test")
	public String greeting(Model model) {
		System.out.println("dans greting gyvdeuyghj");
		return "index.htmlzefe";
	}
	@GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = new Resource() {
			
			@Override
			public InputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long lastModified() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public URL getURL() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URI getURI() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getFilename() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public File getFile() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean exists() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Resource createRelative(String relativePath) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long contentLength() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("marche pas");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


}