package cn.edu.zju.ccnt.openapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.News;
import cn.edu.zju.ccnt.openapi.service.NewsService;

/**
 * 
 * @author zheng
 * 2015年4月16日 下午4:40:17
 */
@Service
@Transactional
public class NewsServiceImpl  extends DaoSupportImpl<News> implements NewsService{

}
