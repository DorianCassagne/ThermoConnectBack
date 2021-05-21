package me.dcal.thermoconnect.control;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import me.dcal.thermoconnect.model.User;
import me.dcal.thermoconnect.model.api.BodyConnexion;
import me.dcal.thermoconnect.repository.UserRepository;



@RestController
public class UserControl {
	@Autowired
	UserRepository myuserrepo;
	@PostMapping(path = "/connexion",consumes = "application/json", produces = "application/json")
    @ResponseBody
	public Boolean check(@RequestBody BodyConnexion body,HttpServletRequest request,
            HttpServletResponse response, Model model) {
		System.out.println("body =" +body);
       return body.getLogin().equals("test") && body.getPassword().equals("test")  ;

    }


}
