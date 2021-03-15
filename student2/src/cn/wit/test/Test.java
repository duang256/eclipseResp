package cn.wit.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wit.mapper.TeacherMapper;
import cn.wit.pojo.Teacher;
import cn.wit.util.MyBatisUtil;

public class Test {
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		List<Teacher> list = mapper.selAll();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
	}
	
}
