# spring boot 프로젝트를 위한 초기 설정

### 오라클 설정
도커를 사용하는 방법
```shell
docker run --name oracle11 -d -p 1521:1521 oracleinanutshell/oracle-xe-11g
```
```
SELECT *
  FROM all_users;

CREATE USER hks713 IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE, DBA TO hks713;
```

