package me.dcal.thermoconnect.control;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import me.dcal.thermoconnect.model.User;
import me.dcal.thermoconnect.repository.UserRepository;



@RestController
public class UserControl {
	@Autowired
	UserRepository myuserrepo;
	@GetMapping("/ariuser")
    public String Register() {
		List<User> list=myuserrepo.findAll();
		System.out.println("PRINT USER");
		for(User u:list)
		{
			System.out.println(u);
		}
        return myuserrepo.findById("test").get().toString();
		
    }


}
