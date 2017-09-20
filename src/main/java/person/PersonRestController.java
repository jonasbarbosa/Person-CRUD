package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
public class PersonRestController {

	@Autowired
	private CustomerRepository repo;

	@RequestMapping(value = "/r/getAll", method = RequestMethod.GET)
	public synchronized List<Person> getAll() {
		return repo.findAll();
	}

	@RequestMapping(value = "/r/add", method = RequestMethod.POST)
	public synchronized boolean additem(@RequestBody Person p) {
		return (repo.saveAndFlush(p) != null);
	}

	@RequestMapping(value = "/r/update", method = RequestMethod.POST)
	public boolean update(@RequestBody Person p) {
		return (p.getName() != null && p.getAge() != 0 && p.getId() != 0 && repo.saveAndFlush(p) != null);
	}

	@RequestMapping(value = "/r/delete", method = RequestMethod.GET)
	public boolean delete(@RequestParam Integer id) {
		repo.delete(id);
		return true;
	}
}