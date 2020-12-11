package Services;

import Domain.Result;

import java.util.List;

public interface IResultService {

    public List<Result> getAllResults();

    public Result getResultByID(int id);

    public void showAllResults();

}
