package cn.edu.zju.ccnt.openapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.SystemError;
import cn.edu.zju.ccnt.openapi.service.SystemErrorService;
/**
 * 
 * @author zheng
 * 2015年3月20日 下午2:17:37
 */

@Service
@Transactional
public class SystemErrorServiceImpl extends DaoSupportImpl<SystemError> implements SystemErrorService{

}
