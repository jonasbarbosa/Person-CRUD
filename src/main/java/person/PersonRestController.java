package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
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

	@RequestMapping(value = "/r/delete/{id}", method = RequestMethod.GET)
	public boolean delete(@PathVariable Integer id) {
		if (repo.exists(id)) {
			repo.delete(id);
			return true;
		} else {
			return false;
		}
	}
}