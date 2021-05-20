package me.dcal.thermoconnect;


//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//public class Accueil {


//    @RequestMapping("/")
//    public Test accueil(Model model) throws ParseException {
//    	System.out.println("cacapipi");
//    	return new Test(123);
//    }
    
//	@GetMapping("/test")
//	public String greeting(Model model) {
//		System.out.println("dans greting gyvdeuyghj");
//		return "index.htmlzefe";
//	}
//	@GetMapping("/downloadFile")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws MalformedURLException {
//        // Load file as Resource
//		Path filePath =  Paths.get("/src/test/index.html");
//        Resource resource = new UrlResource(filePath.toUri());
//       
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            System.out.println("marche pas");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
//
//
//}