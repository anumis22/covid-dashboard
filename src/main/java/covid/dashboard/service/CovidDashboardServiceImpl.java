package covid.dashboard.service;

import covid.dashboard.model.User;
import covid.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidDashboardServiceImpl implements CovidDashboardService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
