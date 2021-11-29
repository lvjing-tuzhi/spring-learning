## spring声明式事务代码没问题，失效问题

检查数据库类型，在mysql数据库中 myisam引擎不支持事务，innodb引擎支持事务，把表的引擎修改为innodb