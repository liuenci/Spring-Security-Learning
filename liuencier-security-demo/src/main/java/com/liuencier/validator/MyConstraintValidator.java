package com.liuencier.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.liuencier.service.HelloService;
// 实现了 ConstraintValidator 这个接口就不需要再在类上添加 @Component 注解了，Spring 能自动识别
// ConstraintValidator<MyConstraint, Object> 泛型的第一个代表自定义注解的名字，第二个是可以作用的类型
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	// 可以自由的注入其他的类
	@Autowired
	private HelloService helloService;
	// 初始化的工作
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// 这里可以使用自己的逻辑来校验属性的合法性。一般用于复杂的逻辑
		helloService.greeting("tom");
		System.out.println(value);
		return false;
	}

}
