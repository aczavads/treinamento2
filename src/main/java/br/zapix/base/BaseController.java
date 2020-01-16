package br.zapix.base;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>, SERVICE extends BaseService<ENTITY, REPOSITORY>> {
	@Autowired
	private SERVICE service;

	@ApiOperation(value = "Recupera a lista com todos os dados", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ENTITY> get() {
		return service.findAll();
	}
	
	@ApiOperation(value = "Persiste uma nova instância", response = UUID.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String post(@ApiParam(value = "Objeto a ser persistido", required = true) @RequestBody ENTITY entity) {
		entity.markAsNew();
		return service.save(entity).getId();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)	
	public String put(@RequestBody ENTITY entity, @PathVariable String id) {
		if (!id.equals(entity.getId())) {
			throw new RequisicaoInvalida("IDs divergentees!");
		}
		return service.save(entity).getId();
	}
	public SERVICE getService() {
		return service;
	}
	
}



