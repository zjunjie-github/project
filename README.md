## 我的社区

## 部署
### 依赖
- Git
- JDK
- Maven
- MySQL
## 步骤
- yum update
- yun install git
- mkdir App
- cd App
- git clone https://github.com/zjunjie-github/project.git
- yum install maven
- mvn -v
- mvn compile package


## 资料
[Spring 文档](https://spring.io/guides)<br>
[Spring Web](https://spring.io/guides/gs/serving-web-content/)<br>
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)<br>
[Bootstrap](https://v3.bootcss.com/getting-started/)<br>
[es](https://elasticsearch.cn/)<br>
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)<br>
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)<br>
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)<br>
[markdown](http://editor.md.ipandao.com)<br>
[UFile SDK](https://github.com/ucloud/ufile-sdk-java)

## 工具
[Git](https://git-scm.com/download)<br>
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)<br>
[Lombok](https://www.projectlombok.org/setup/maven)<br>
[Postman](https://chrome.google.com/webstore)

## 脚本
```sql
create table USER
(
	ID INTEGER  auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

```
