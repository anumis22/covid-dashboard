package covid.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import covid.dashboard.model.User;
import covid.dashboard.repository.UserRepository;
import covid.dashboard.service.CovidDashboardService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CovidDashboardApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTests {

	@MockBean
	private TestEntityManager entityManager;

	@Autowired
	private CovidDashboardService service;
	
	@Autowired
	private UserRepository repository;

	@MockBean
	TestRestTemplate restTemplate;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("anu.mishra@gmail.com");
		user.setPassword("anumis22");
		user.setFirstName("Anu");
		user.setLastName("Mishra");

		User savedUser = service.saveUser(user);
		User existUser = repository.findById(savedUser.getId()).get();
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
