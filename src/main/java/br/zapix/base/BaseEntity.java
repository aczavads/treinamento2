package br.zapix.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseEntity implements Persistable<String> {
	@Id
	private String id;
	
	@Version
	private int version;
	
	@Transient
	@JsonIgnore
	private boolean markedAsNew = false;

	public BaseEntity(String id) {
		this.id = id;
	}

	public BaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return this.id == null || (this.id != null && this.markedAsNew);
	}

	public void markAsNew() {
		this.markedAsNew = true;		
	}
	
	public int getVersion() {
		return version;
	}
	
}
