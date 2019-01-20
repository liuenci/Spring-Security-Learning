package com.liuencier.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
// 注解标注到方法以及属性上
@Target({ElementType.METHOD, ElementType.FIELD})
// 标注为一个运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 通过哪个类来起作用
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
	// 三个属性是必须的，去掉下面两个测试会报错
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}