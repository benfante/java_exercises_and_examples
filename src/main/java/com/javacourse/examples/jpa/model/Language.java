package com.javacourse.examples.jpa.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "language_id")
    private Short languageId;
    private String name;
    @Column(name = "last_update", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
    private Collection<Film> films;
    @OneToMany(mappedBy = "originalLanguage")
    private Collection<Film> filmsForOriginalLanguage;

    public Language() {
    }

    public Language(Short languageId) {
        this.languageId = languageId;
    }

    public Language(Short languageId, String name, Date lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }

    @XmlTransient
    public Collection<Film> getFilmsForOriginalLanguage() {
        return filmsForOriginalLanguage;
    }

    public void setFilmsForOriginalLanguage(Collection<Film> films) {
        this.filmsForOriginalLanguage = films;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Language))
			return false;
		Language other = (Language) o;
		return languageId != null && languageId.equals(other.getLanguageId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

    @Override
    public String toString() {
        return "Language[ languageId=" + languageId + " ]";
    }
    
}
