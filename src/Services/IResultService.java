package Services;

import Domain.Result;

import java.util.List;

public interface IResultService {

    public List<Result> getAllResults();

    public Result getResultByID(int id);

    public void showAllResults();

    public List<Result> getTopJuniorResultsByDiscipline(String discipline);

    public void showTopFiveByDiscipline(String input);
}
