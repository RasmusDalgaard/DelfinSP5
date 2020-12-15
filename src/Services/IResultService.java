package Services;

import Domain.Result;

import java.util.InputMismatchException;
import java.util.List;

public interface IResultService {

    public List<Result> getAllResults();

    public Result getResultByID(int id);

    public void showAllResults();

    public List<Result> getTopJuniorResultsByDiscipline(String discipline);

    public List<Result> getTopSeniorResultsByDiscipline(String discipline);

    public void showTopFiveJuniorByDiscipline(String input);

    public void showTopFiveSeniorByDiscipline(String input);
}
