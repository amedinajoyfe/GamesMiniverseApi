package joyfe.gamesMiniverse.apiController;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import joyfe.gamesMiniverse.secondaryClasses.User;
import joyfe.gamesMiniverse.services.UsersService;

@Tag(name = "Tareas 1", description = "Documentacion de la api")
@RestController
@RequestMapping("/${api-version}/${api-name}")
@CrossOrigin(origins = "*", allowedHeaders = {"POST", "GET", "PUT"})
public class ApiController {
	@Autowired
	UsersService usersService;
	
	@Operation(summary = "Comprobacion", description = "Este endpoint te comprobar si la Api está activa")
	@GetMapping(path = "/${users-endpoint}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String testApi() {
		return "Hola";
	}

	@Operation(summary = "Comprobacion de JSON", description = "Este endpoint te comprobar si se reciben bien los JSON")
	@GetMapping(path = "/testJson", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getData() {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("key4", "value1");
        responseData.put("key5", "value2");

        // Maps are converted to jsons on requests
        return responseData;
	}
	
	@Operation(summary = "${get-user-title}", description = "${get-user-description}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "${get-user-ok-response"),
			@ApiResponse(responseCode = "400", description = "${unexpected-error}"),
			@ApiResponse(responseCode = "404", description = "${user-not-found}")
	})
	@GetMapping(path = "/${users-endpoint}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		return ResponseEntity.ok().body(usersService.getUserById(id));
	}
	
	@Operation(summary = "${post-user-title}", description = "${post-user-description}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "${post-user-ok-response"),
			@ApiResponse(responseCode = "400", description = "${unexpected-error}")
	})
	@PostMapping(path = "/${users-endpoint}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody @Valid User newUser) throws URISyntaxException {
		usersService.addUser(newUser);
		return ResponseEntity.created(new URI("/users/" + newUser.getId())).body(newUser);
	}
	
	@Operation(summary = "${put-user-title}", description = "${put-user-description}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "${put-user-ok-response"),
			@ApiResponse(responseCode = "400", description = "${unexpected-error}"),
			@ApiResponse(responseCode = "404", description = "${user-not-found}")
	})
	@PutMapping(path = "/${users-endpoint}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateTask(@PathVariable long id, @RequestBody @Valid User newTask) throws URISyntaxException {
		return usersService.updateUser(id, newTask) ? ResponseEntity.created(new URI("/users/" + id)).body(newTask) : ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "${delete-user-title}", description = "${delete-user-description}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "${delete-user-ok-response"),
			@ApiResponse(responseCode = "400", description = "${unexpected-error}"),
			@ApiResponse(responseCode = "403", description = "${permission-denied}"),
			@ApiResponse(responseCode = "404", description = "${user-not-found}")
	})
	@DeleteMapping(path = "/${users-endpoint}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteTask(@PathVariable long id) {
		return usersService.deleteUser(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}