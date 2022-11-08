package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//Event is the type, Integer is the type of primary key. CrudRepository is our base class that we are extending to create a repository.
//Contains the ability to put things in a database, the ability to retrieve them, to delete from database etc. Interact with Event objects in
//our database. Storing Event objects and primary key of those of objects is type, Integer. Integer is the class version of Integer. int is primitive.
//@Repository, should be managed, spring boot should create eventrepository objects then inject them, one way is autowired.
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
//crudrepository allows us to store and retrieve Spring will create a class on the fly like this:
//public class MyRepository implements EventRepository