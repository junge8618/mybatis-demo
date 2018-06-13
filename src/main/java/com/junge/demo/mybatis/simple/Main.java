package com.junge.demo.mybatis.simple;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(5,6,0,7,8);
		
		for (Integer tmp : intList) {
			try {
				if (0 == tmp) {
					continue;
				}
				
				System.out.println("calc:"+10/tmp);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("src:"+tmp);
			}
		}

	}

}
