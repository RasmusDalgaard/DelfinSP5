package Services;

import Domain.Result;

import java.util.List;

public interface IResultService {

    public List<Result> getAllResults();

    public List<Result> getTopFiveJuniorCrawl();

    public List<Result> getTopFiveSeniorCrawl();

    public Result getResultByID(int id);

    public void showAllResults();

    public void showTopFiveJuniorResultsCrawl();

    public void showTopFiveSeniorResultsCrawl();

}
