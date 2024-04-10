package com.example.hello.mapper;

import com.example.hello.entity.Theme;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ThemeMapper {

    @Select("SELECT * FROM Theme")
    List<Theme> findAllThemes();

    // SqlSessionFactoryをセットするメソッド
    @Autowired
    void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
}