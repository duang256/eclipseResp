package cn.wit.service;

import cn.wit.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String pageSizeStr, String pageNumberStr);
}
