## around advice
```xml
<dependencies>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.9.9.1</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>5.3.25</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.3.25</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>5.3.25</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

```

```java
//javaconfig
@Configuration
@ComponentScan({ "com.lavesh.aspect", "com.lavesh.bean" })
@EnableAspectJAutoProxy
public class Javaconfig {

}

advice
@Component
public class Calculator {

	public int add(int i, int j) {
		System.out.println("inside cal bean");
		return i + j;
	}
}


//aspect

@Component
@Aspect
@Order(1)
public class LoggingAspect {

	@Around(value = "execution(* com.lavesh.bean.Calculator.add(..))")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();

		System.out.println("args length " + args.length);
		System.out.println(args[0] + "   " + args[1]);

		Object object = joinPoint.proceed();

		return object;

	}
}

```

