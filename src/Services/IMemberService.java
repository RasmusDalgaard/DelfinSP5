package Services;

import Domain.Member;

import java.util.List;

public interface IMemberService {

    public void addMember();

    public List<Member> getAllMembers();

    public void showAllMembers();

}
