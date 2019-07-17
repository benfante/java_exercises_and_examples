package com.javacourse.exercises.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertFilm implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(InsertFilm.class);

    private PreparedStatement insertFilm;
    private PreparedStatement findLanguageIdByName;
    private PreparedStatement insertActor;
    private PreparedStatement addActorToFilm;
    private PreparedStatement addFilmToInventory;

    public InsertFilm(Connection conn) throws SQLException {
        prepareStatements(conn);
    }

    public void close() throws SQLException {
        closeStatements();
    }

    private void prepareStatements(Connection conn) throws SQLException {
        insertFilm = conn.prepareStatement("insert into film(title, description, release_year, language_id, length) values (?, ?, ?, ?, ?);",
            Statement.RETURN_GENERATED_KEYS);
        findLanguageIdByName = conn.prepareStatement("SELECT language_id from language WHERE name = ?");
        insertActor = conn.prepareStatement("insert into actor(first_name, last_name) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
        addActorToFilm = conn.prepareStatement("insert into film_actor(film_id, actor_id) VALUES (?, ?);");
        addFilmToInventory = conn.prepareStatement("insert into inventory(film_id, store_id) VALUES (?, ?);");
        log.info("Statements prepared");
    }

    private void closeStatements() {
        DbUtils.closeQuietly(insertFilm);
        DbUtils.closeQuietly(findLanguageIdByName);
        DbUtils.closeQuietly(insertActor);
        DbUtils.closeQuietly(addActorToFilm);
        DbUtils.closeQuietly(addFilmToInventory);
        log.info("Statements closed");
    }

    /**
     * 
     * @return The auto-generated film id
     */
    public long insertFilm(String title, String description, int releaseYear, String languageName, int length) throws SQLException {
        insertFilm.setString(1, title);
        insertFilm.setString(2, description);
        insertFilm.setInt(3, releaseYear);
        insertFilm.setLong(4, findLanguageIdByName(languageName));
        insertFilm.setInt(5, length);
        insertFilm.executeUpdate();
        try (ResultSet rs = insertFilm.getGeneratedKeys()) {
            rs.next();
            long filmId = rs.getLong(1);
            log.info("Inserted film with title {} and id {}", title, filmId);
            return filmId;
        }
    }

    public long findLanguageIdByName(String languageName) throws SQLException {
        findLanguageIdByName.setString(1, languageName);
        try (ResultSet rs = findLanguageIdByName.executeQuery();) {
            rs.next();
            return rs.getLong(1);
        }
    }

    public long insertActor(String firstName, String lastName) throws SQLException {
        insertActor.setString(1, firstName);
        insertActor.setString(2, lastName);
        insertActor.executeUpdate();
        try (ResultSet rs = insertActor.getGeneratedKeys()) {
            rs.next();
            long actorId = rs.getLong(1);
            log.info("Added actor {} {} with id {}", firstName, lastName, actorId);
            return actorId;
        }
    }

    public void addActorToFilm(long actorId, long filmId) throws SQLException {
        addActorToFilm.setLong(1, filmId);
        addActorToFilm.setLong(2, actorId);
        addActorToFilm.executeUpdate();
        log.info("Added actor {} to film {}", actorId, filmId);
    }

    public void addFilmToInventory(long filmId, long storeId) throws SQLException {
    	addFilmToInventory.setLong(1, filmId);
    	addFilmToInventory.setLong(2, storeId);
    	addFilmToInventory.executeUpdate();
    	log.info("Added film {} to the inventory of store {}", filmId, storeId);
    }
    
    public static final void main(String[] args) throws SQLException {
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/sakila?serverTimezone=UTC&useSSL=false", "root", "root");
                InsertFilm app = new InsertFilm(conn);) {
            conn.setAutoCommit(false);
            long filmId = app.insertFilm("Fantozzi",
                "Il ragionier Ugo Fantozzi, dimenticato da molti giorni nei gabinetti murati della società ItalPetrolCemeTermoTessilFarmoMetalChimica viene ritrovato grazie a una \'rispettosa\' telefonata della moglie Pina che ha osato finalmente chiedere sue notizie. Da quel momento veniamo a conoscenza della sua vita familiare (ha una figlia, Mariangela, dall\'aspetto decisamente poco invitante), del suo segreto amore (la collega signorina Silvani) e soprattutto delle vessazioni a cui è sottoposto (e a cui talvolta si auto sottopone preventivamente) al lavoro.",
                1975, "Italian", 100);
            app.addActorToFilm(app.insertActor("Paolo", "Villaggio"), filmId);
            app.addActorToFilm(app.insertActor("Anna", "Mazzamauro"), filmId);
            app.addActorToFilm(app.insertActor("Gigi", "Reder"), filmId);
            app.addActorToFilm(app.insertActor("Giuseppe", "Anatrelli"), filmId);
            app.addActorToFilm(app.insertActor("Liù", "Bosisio"), filmId);
            app.addFilmToInventory(filmId, 2);
            app.addFilmToInventory(filmId, 2);
            app.addFilmToInventory(filmId, 1);
            app.addFilmToInventory(filmId, 1);
            app.addFilmToInventory(filmId, 1);
            conn.rollback(); // always rollbacking...just for testing it without really having changes on the DB
        }
    }
}
