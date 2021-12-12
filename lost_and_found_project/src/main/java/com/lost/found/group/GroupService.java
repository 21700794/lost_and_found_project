package com.lost.found.group;

public interface GroupService {
	public int insertGroup(GroupVO vo);
	public int updateGroup(GroupVO vo);
	public int deleteGroup(int id);
	public GroupVO getGroup(int seq);
	public List<GroupVO> getBoardList();
}
