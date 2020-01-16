package br.zapix.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {
	@Autowired
	private REPOSITORY repo;

	public ENTITY save(ENTITY entity) {
		return repo.save(entity);
	}

	public List<ENTITY> findAll() {
		return repo.findAll();
	}
	
	public REPOSITORY getRepo() {
		return repo;
	}
	
}
