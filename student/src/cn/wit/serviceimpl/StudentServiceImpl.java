package cn.wit.serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wit.mapper.StudentMapper;
import cn.wit.mapper.TeacherMapper;
import cn.wit.pojo.PageInfo;
import cn.wit.pojo.Student;
import cn.wit.service.StudentService;
import cn.wit.util.MyBatisUtil;

public class StudentServiceImpl implements  StudentService{

	@Override
	public PageInfo showPage(String pageSizeStr, String pageNumberStr) {
		int pageSize = 2;
		int pageNumber = 1;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		
		//拿到所有返回Student集合
		List<Student> list = studentMapper.selByPage(pi);
		
		//查询出每个学生对应的老师信息
		for (Student student : list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo();
		
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		return pi;
	}

}
