package com.akomaning.springdatabasedemo.jdbc;

import com.akomaning.springdatabasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthDate(resultSet.getTimestamp("birth_date"));
            return person;
        }
    }

    //get all person i.e select * from person
    public List<Person> getAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    //get a single person i.e select * from person where id
    public Person getById(int id) {
        //queryForObject is usually used when when querying for a specific item (or row) in a table
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id }, new PersonRowMapper());
    }

    //delete a single person i.e delete from person where id
    public int deleteById(int id) {
        //queryForObject is usually used when when querying for a specific item (or row) in a table
        return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
    }

    //Insert a single person i.e insert into person;
    public int insert(Person person) {
        //queryForObject is usually used when when querying for a specific item (or row) in a table
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " +
                    "values(?, ?, ?, ?,)",
                    new Object[]{ person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())}
                );
    }

    //Update a single person i.e insert into person;
    public int update(Person person) {
        //queryForObject is usually used when when querying for a specific item (or row) in a table
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ?"
                        + "where id = ?",
                new Object[]{ person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()}
        );
    }
}
