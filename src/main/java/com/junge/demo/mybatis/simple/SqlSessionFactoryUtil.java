/**
 * 
 */
package com.junge.demo.mybatis.simple;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author "liuxj"
 *
 */
public class SqlSessionFactoryUtil {

	private static SqlSessionFactory instance;

	private static final ReentrantLock lock = new ReentrantLock();

	private SqlSessionFactoryUtil() {

	}

	public static SqlSessionFactory getInstance() {
		if (null == instance) {

			try {
				lock.lock();
				if (null == instance) {
					String resource = "mybitis-conf.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					instance = new SqlSessionFactoryBuilder().build(inputStream);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

		return instance;
	}
}
