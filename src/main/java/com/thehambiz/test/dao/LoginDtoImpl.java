package com.thehambiz.test.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class LoginDtoImpl implements LoginDao{
SqlSession sqlSession;
@Override
public String loginCheck(UserDto dto) {
return sqlSession.selectOne("dbo.notice_board.login_check", dto);
 }
}
