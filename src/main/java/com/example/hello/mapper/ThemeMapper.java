package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hello.entity.Theme;

@Repository
public class ThemeMapper {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public ThemeMapper(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

    public List<Theme> findAllThemes() {
        return sqlSessionTemplate.selectList("com.example.hello.mapper.ThemeMapper.findAllThemes");
    }
}
