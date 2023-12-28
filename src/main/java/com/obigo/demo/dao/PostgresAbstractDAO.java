package com.obigo.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PostgresAbstractDAO {
	final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SqlSessionTemplate sqlSession;
     
    protected void printQueryId(String queryId) {
        if(logger.isDebugEnabled()){
        	//logger.debug("\t QueryId  \t:  " + queryId);
        }
    }
     
    public Object insert(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.insert(queryId, params);
    }
     
    public Object update(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.update(queryId, params);
    }
     
    public Object delete(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.delete(queryId, params);
    }

    public Object selectOne(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }
     
    public List<?> selectList(String queryId){
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }
     
    public List<?> selectList(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectList(queryId, params);
    }

    public List<?> selectList(String queryId, String param1, String param2, String param3){
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }

}
