package com.javacourse.examples.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "film")
@NamedEntityGraphs(@NamedEntityGraph(name = "graph.Film.actors", attributeNodes = @NamedAttributeNode(value = "actors")))
@NamedQueries({
		@NamedQuery(name = "Film.findAll", query = "select f from Film f", hints = {
				@QueryHint(name = "javax.persistence.loadgraph", value = "graph.Film.actors") }),
		@NamedQuery(name = "Film.findByLanguage", query = "select f from Film f WHERE f.language.name = :languageName") })
public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "film_id")
	private Short filmId;
	@Basic(optional = false)
	@Column(name = "title")
	private String title;
	//@Lob // for a better mappig in MySQL
	private String description;
	@Column(name = "release_year")
	private Integer releaseYear;
	@Basic(optional = false)
	@Column(name = "rental_duration")
	private short rentalDuration;
	@Basic(optional = false)
	@Column(name = "rental_rate")
	private BigDecimal rentalRate;
	private Short length;
	@Basic(optional = false)
	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;
	private String rating;
	@Column(name = "special_features")
	private String specialFeatures;
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@ManyToOne(optional = false)
	private Language language;
	@JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
	@ManyToOne
	private Language originalLanguage;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actor> actors;
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "film") private
	 * Collection<FilmCategory> filmCategoryCollection;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "film") private
	 * Collection<FilmActor> filmActorCollection;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmId") private
	 * Collection<Inventory> inventoryCollection;
	 */

	public Film() {
	}

	public Film(Short filmId) {
		this.filmId = filmId;
	}

	public Film(Short filmId, String title, short rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost,
			Date lastUpdate) {
		this.filmId = filmId;
		this.title = title;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.lastUpdate = lastUpdate;
	}

	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public short getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(Actor actor) {
		actors.add(actor);
		actor.getFilms().add(this);
	}

	public void removeActor(Actor actor) {
		actors.remove(actor);
		actor.getFilms().remove(this);
	}

	/*
	 * @XmlTransient public Collection<FilmCategory> getFilmCategoryCollection() {
	 * return filmCategoryCollection; }
	 * 
	 * public void setFilmCategoryCollection(Collection<FilmCategory>
	 * filmCategoryCollection) { this.filmCategoryCollection =
	 * filmCategoryCollection; }
	 * 
	 * @XmlTransient public Collection<FilmActor> getFilmActorCollection() { return
	 * filmActorCollection; }
	 * 
	 * public void setFilmActorCollection(Collection<FilmActor> filmActorCollection)
	 * { this.filmActorCollection = filmActorCollection; }
	 * 
	 * 
	 * @XmlTransient public Collection<Inventory> getInventoryCollection() { return
	 * inventoryCollection; }
	 * 
	 * public void setInventoryCollection(Collection<Inventory> inventoryCollection)
	 * { this.inventoryCollection = inventoryCollection; }
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Film))
			return false;
		Film other = (Film) o;
		return filmId != null && filmId.equals(other.getFilmId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + "]";
	}

}
