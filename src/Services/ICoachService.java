package Services;

import Domain.Coach;

import java.util.List;

public interface ICoachService {

    public List<Coach> getAllCoaches();

    public void showAllCoaches();

    public void showJuniorCoaches();

    public void showSeniorCoaches();

}
