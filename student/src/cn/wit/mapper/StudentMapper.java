package cn.wit.mapper;





import java.util.List;

import cn.wit.pojo.PageInfo;
import cn.wit.pojo.Student;

public interface StudentMapper {
	List<Student> selByPage(PageInfo pi);
	
	long selCountByPageInfo();
}
