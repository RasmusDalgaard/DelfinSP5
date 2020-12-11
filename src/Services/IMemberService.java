package Services;

import Domain.Member;

import java.util.List;

public interface IMemberService {

    public void addMember();

    public List<Member> getAllMembers();

    public List<Member> getAllCompetitiveJuniors();

    public List<Member> getAllCompetitiveSeniors();

    public Member getMemberByID(int id);

    public void showAllMembers();

    public void showJuniorMembers();

    public void showSeniorMembers();


}
