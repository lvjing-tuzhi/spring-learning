# MyISAM和InnoDB的区别

1. MySQL默认采用MyISAM。
2. MyISAM不支持事务，InnoDB支持事务。
3. MyISAM不支持外键，InnoDB支持外键
4. InnoDB支持数据行锁定，MyISAM不支持行锁定，只支持锁定整个表。即MyISAM同一个表上的读锁和写锁是互斥的，MyISAM并发读写时如果等待队列中既有读请求又有写请求，默认写请求的优先级高，即使读请求先到，所有MyISAM不适合有大量查询和修改并存的情况，那样查询进程会长时间阻塞。因为MyISAM是锁表，所以某项读操作耗时会使其他进程饿死。
5. InnoDB主键范围是MyISAM的2倍。
6. MyISAM支持GIS数据，InnoDB不支持。

