package com.qa.ims.persistence.domain;

public class Items {

	private Long id;
	private String Name;
	private String description;

	public Items (String Name, String description) {
		this.setFirstName(Name);
		this.setSurname(description);
	}

	public Items(Long id, String Name, String description) {
		this.setId(id);
		this.setFirstName(Name);
		this.setSurname(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return Name;
	}

	public void setFirstName(String Name) {
		this.Name = Name;
	}

	public String getSurname() {
		return description;
	}

	public void setSurname(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + Name + " description:" + description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Items other = (Items) obj;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}
