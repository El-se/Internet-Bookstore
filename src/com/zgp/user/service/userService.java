package com.zgp.user.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zgp.dao.UserMapper;
import com.zgp.domain.User;
import com.zgp.domain.UserExample;
import com.zgp.vo.UserPwdVO;

import mailhelper.Mail;
import mailhelper.MailUtils;
import uuid.UUIDHelper;

@Service
public class userService {
@Autowired
	private UserMapper userMapper;
	public void regist(User user) {
		// TODO Auto-generated method stub
		user.setStatus(false);
		user.setUid(UUIDHelper.getUUID());
		user.setActivationcode(UUIDHelper.getUUID()+UUIDHelper.getUUID());
		userMapper.insert(user);
		
		
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email.properties"));
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String host = prop.getProperty("host");
			Session session = MailUtils.createSession(host, username, password);
			String from = prop.getProperty("from");
			String to = user.getEmail();
			String subject = prop.getProperty("subject");
			String content = MessageFormat.format(prop.getProperty("content"),user.getLoginname(),
					user.getActivationcode());

			Mail mail = new Mail(from, to, subject, content);
			MailUtils.send(session, mail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void verifyactivationCode(List<User> users) {
		// TODO Auto-generated method stub
		User user = users.get(0);
		user.setStatus(true);
		userMapper.updateByPrimaryKey(user);
	}
	public List<User> selectuser(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.createCriteria().andLoginnameEqualTo(user.getLoginname()).andLoginpassEqualTo(user.getLoginpass());
		List<User> users = userMapper.selectByExample(example);
		return users;
	}
	public Boolean editpwd(String uid, UserPwdVO vo) {
		User user = userMapper.selectByPrimaryKey(uid);
		if (!user.getLoginpass().equals(vo.getLoginpass())) {
			return false;
		}
		user.setLoginpass(vo.getNewpass());
		userMapper.updateByPrimaryKey(user);
		return true;
	}

}
